package gestionresiduos_gateway.demo.security;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import reactor.core.publisher.Mono;

@Component
public class AuthHeaderFilter implements GlobalFilter, Ordered {

  private static final List<String> PUBLIC_PATTERNS = List.of(
      "/auth/", 
      "/usuarios/",
      "/api/auth/",
      "/api/usuarios/",
      "/clientes/",
      "/api/clientes/",
      "/api/admin/clientes"
  );
  private final JwtUtil jwt;

  public AuthHeaderFilter(JwtUtil jwt) {
    this.jwt = jwt;
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    String path = exchange.getRequest().getURI().getPath();

    // Rutas públicas: no requieren token
    if (isPublic(path)) {
      return chain.filter(exchange);
    }

    // Requiere Authorization: Bearer <token>
    List<String> authz = exchange.getRequest().getHeaders().getOrEmpty(HttpHeaders.AUTHORIZATION);
    if (authz.isEmpty() || !authz.get(0).startsWith("Bearer ")) {
      return unauthorized(exchange, "Missing or invalid Authorization header");
    }

    String token = authz.get(0).substring("Bearer ".length());
    try {
      Jws<Claims> jws = jwt.parse(token);
      Claims claims = jws.getBody();
      String sub = jwt.subject(claims);
      List<String> roles = jwt.extractRoles(claims);

      // Propagar identidad a los microservicios
      var mutated = exchange.getRequest()
          .mutate()
          .header("X-User-Sub", sub != null ? sub : "")
          .header("X-User-Roles", String.join(",", roles))
          .build();

      return chain.filter(exchange.mutate().request(mutated).build());

    } catch (JwtException ex) {
      return unauthorized(exchange, "Invalid or expired token");
    }
  }

  private boolean isPublic(String path) {
    return PUBLIC_PATTERNS.stream().anyMatch(path::startsWith);
  }

  private Mono<Void> unauthorized(ServerWebExchange exchange, String msg) {
    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
    byte[] bytes = msg.getBytes();
    var buffer = exchange.getResponse().bufferFactory().wrap(bytes);
    return exchange.getResponse().writeWith(Mono.just(buffer));
  }

  @Override
  public int getOrder() {
    return -1; // ejecutar temprano
  }
}
