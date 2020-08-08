package org.globaldev.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

class JWTAuth {
    // EXPIRATION_TIME = 1 dias
    private static final long EXPIRATION_TIME = TimeUnit.DAYS.toMillis(1);
    private static final String SECRET = "RDrifbeKZpjlE7RpNIxQN7N6HS1khs9496c0qHEgWrx9b438p2v4ti7tOjDEdJzj";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";
    private static final String CLAIMS_PRIVILEGES = "privileges";

    static void addAuthentication(HttpServletResponse response, Authentication auth) {
        Date expiration = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        Claims claims = Jwts.claims()
                .setIssuedAt(new Date())
                .setSubject(auth.getName())
                .setExpiration(expiration)
                .setSubject(auth.getName());

        claims.put(CLAIMS_PRIVILEGES, auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        String JWT = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .setClaims(claims)
                .compact();

        response.setHeader("content-type", "application/json");

        String jwtToken = "{ \"token\": \"" + TOKEN_PREFIX + " " + JWT + "\"}";

        try {
            response.getWriter().write(jwtToken);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {

            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            String user = claims.getSubject();

            List<GrantedAuthority> objects = new ArrayList<>();
            if (claims.containsKey(CLAIMS_PRIVILEGES)) {
                List<String> privileges = (List<String>) claims.get(CLAIMS_PRIVILEGES);
                for (String privilege : privileges) {
                    objects.add(() -> privilege);
                }
            }
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, objects);
            }
        }
        return null;
    }
}
