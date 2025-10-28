package gestionresiduos_gateway.demo.security;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component("roleGuard")
public class RoleGuardGatewayFilterFactory extends AbstractGatewayFilterFactory<RoleGuardGatewayFilterFactory.Config> {

  public RoleGuardGatewayFilterFactory() {
    super(Config.class);
  }

  public static class Config {
    // coma-separados en yml (e.g., "ADMIN,CHOFER")
    private String anyRole;
    public String getAnyRole() { return anyRole; }
    public void setAnyRole(String anyRole) { this.anyRole = anyRole; }
  }

  @Override
  public GatewayFilter apply(Config config) {
    final Set<String> required = parseRoles(config.getAnyRole());

    return (exchange, chain) -> {
      String rolesHeader = exchange.getRequest().getHeaders().getFirst("X-User-Roles");
      Set<String> userRoles = parseRoles(rolesHeader);

      if (required.isEmpty() || intersects(userRoles, required)) {
        return chain.filter(exchange);
      }
      return forbid(exchange, "Forbidden: missing role(s) " + required);
    };
  }

  private Set<String> parseRoles(String csv) {
    if (!StringUtils.hasText(csv)) return Set.of();
    return Arrays.stream(csv.split(","))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .collect(Collectors.toSet());
  }

  private boolean intersects(Set<String> a, Set<String> b) {
    for (String r : a) if (b.contains(r)) return true;
    return false;
  }

  private Mono<Void> forbid(ServerWebExchange exchange, String msg) {
    exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
    var buffer = exchange.getResponse().bufferFactory().wrap(msg.getBytes());
    return exchange.getResponse().writeWith(Mono.just(buffer));
  }
}
