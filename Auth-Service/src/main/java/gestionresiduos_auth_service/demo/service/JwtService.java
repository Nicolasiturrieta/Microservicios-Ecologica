package gestionresiduos_auth_service.demo.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.Date;

@Service
public class JwtService {
    @Value("${security.jwt.secret}")
    private String secret;
    @Value("${security.jwt.expiration-minutes}")
    private long expMin;

    public String generate(String sub, Collection<String> roles) {
        var key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        var now = new Date();
        var exp = Date.from(Instant.now().plus(Duration.ofMinutes(expMin)));
        return Jwts.builder().setSubject(sub).claim("roles", roles).setIssuedAt(now).setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256).compact();
    }
}