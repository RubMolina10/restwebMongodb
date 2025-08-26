package com.frmnetbot.restwebMongodb.Security;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String jwtSecret = "miClaveSuperSecreta"; // 🔒 cámbiala
    private final long jwtExpirationMs = 86400000; // 24 horas

    // Generar token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // usuario como "dueño" del token
                .setIssuedAt(new Date()) // fecha de creación
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) // expiración
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Obtener usuario desde el token
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validar token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
