package net.bitstechworld.users.Infrastructure.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import net.bitstechworld.users.Application.Ports.JWTPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Service
public class JWTService implements JWTPort {
    private Long expirationTime;
    private SecretKey secretKey;

    public JWTService(@Value("${jwt.exp-time}") Long expirationTime, @Value("${jwt.secret}") String secret) {
        this.expirationTime = expirationTime;
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateJWT(long id, String email) {
        Instant now = Instant.now();
        Instant expirationTime = now.plusMillis(this.expirationTime);
        return Jwts.builder().subject(email).claim("id", id).issuedAt(Date.from(now)).expiration(Date.from(expirationTime)).signWith(this.secretKey).compact();
    }
}
