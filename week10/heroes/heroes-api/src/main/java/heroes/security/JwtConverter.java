package heroes.security;

import heroes.models.AppUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtConverter {

    // 1. Signing key
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 2. "Configurable" constants
    private final String ISSUER = "bug-safari";
    private final int EXPIRATION_MINUTES = 15;
    private final int EXPIRATION_MILLIS = EXPIRATION_MINUTES * 60 * 1000;

    public String userToToken(AppUser user) {

        String authorities = user.getAuthorities().stream()
                .map(i -> i.getAuthority())
                .collect(Collectors.joining(","));

        // 3. Use JJWT classes to build a token.
        return Jwts.builder()
                .setIssuer(ISSUER)
                .setSubject(user.getUsername())
                .claim("authorities", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(key)
                .compact();
    }

    public AppUser tokenToUser(String token) {

        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        try {
            // 4. Use JJWT classes to read a token.
            Jws<Claims> jws = Jwts.parserBuilder()
                    .requireIssuer(ISSUER)
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.substring(7));

            String username = jws.getBody().getSubject();
            String authStr = (String) jws.getBody().get("authorities");
            int appUserId = jws.getBody().get("appUserId", Integer.class);

            List<GrantedAuthority> roles = Arrays.stream(authStr.split(","))
                    .map(r -> new SimpleGrantedAuthority(r))
                    .collect(Collectors.toList());

            AppUser user = new AppUser();
            user.setAppUserId(appUserId);
            user.setUsername(username);
            user.setAuthorities(roles);
            return user;

        } catch (JwtException e) {
            // 5. JWT failures are modeled as exceptions.
            System.out.println(e);
        }

        return null;
    }
}
