package gestionresiduos_gateway.demo.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

  @Value("${security.jwt.secret}")
  private String secret;

  private Key key() {
    return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
  }

  public Jws<Claims> parse(String token) throws JwtException {
    return Jwts.parserBuilder()
        .setSigningKey(key())
        .build()
        .parseClaimsJws(token);
  }

  @SuppressWarnings("unchecked")
  public List<String> extractRoles(Claims claims) {
    Object r = claims.get("roles");
    if (r instanceof List<?>) {
      return (List<String>) r;
    }
    return List.of(); // sin roles
  }

  public String subject(Claims claims) {
    return claims.getSubject();
  }
}
