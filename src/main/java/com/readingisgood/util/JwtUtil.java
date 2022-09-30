package com.readingisgood.util;

import com.readingisgood.model.TokenType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@ConfigurationProperties(prefix = "jwt.auth")
public class JwtUtil {

    private String secret;
    private long activationExpiry;

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setActivationExpiry(long activationExpiry) {
        this.activationExpiry = activationExpiry;
    }

    private Date getTokenExpirationDate(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = getTokenExpirationDate(token);
        return expiration.before(new Date());
    }

    private String getAudience(String token) {
        return getClaim(token, Claims::getAudience);
    }

    public String getId(String token) {
        return getClaim(token, Claims::getId);
    }

    public String getSubject(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public String generateActivationToken(String sessionId, String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder().setClaims(claims)
                .setId(sessionId)
                .setSubject(username)
                .setAudience(TokenType.ACTIVATION.getType())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + activationExpiry))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String generateResetPasswordToken(String sessionId, String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder().setClaims(claims)
                .setId(sessionId)
                .setSubject(username)
                .setAudience(TokenType.RESET_PASSWORD.getType())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + activationExpiry))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String generateAuthToken(String sessionId, String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder().setClaims(claims)
                .setId(sessionId)
                .setSubject(username)
                .setAudience(TokenType.AUTHENTICATION.getType())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public boolean validateToken(String token, String username, TokenType tokenType) {
        if (tokenType == TokenType.ACTIVATION) {
            return validateActivationToken(token, username);
        } else if (tokenType == TokenType.RESET_PASSWORD) {
            return validateResetPasswordToken(token, username);
        } else {
            return validateAuthToken(token, username);
        }
    }

    public boolean validateActivationToken(String token, String username) {
        final String subject = getSubject(token);
        final String audience = getAudience(token);
        return (TokenType.ACTIVATION.getType().equals(audience) &&
                subject.equals(username) && !isTokenExpired(token));
    }

    public boolean validateResetPasswordToken(String token, String username) {
        final String subject = getSubject(token);
        final String audience = getAudience(token);
        return (TokenType.RESET_PASSWORD.getType().equals(audience) &&
                subject.equals(username) && !isTokenExpired(token));
    }

    public boolean validateAuthToken(String token, String username) {
        final String subject = getSubject(token);
        final String audience = getAudience(token);
        return (TokenType.AUTHENTICATION.getType().equals(audience) && subject.equals(username));
    }
}
