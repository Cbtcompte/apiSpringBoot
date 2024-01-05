package springboot.pdl.pdl.projet.config;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import springboot.pdl.pdl.projet.models.User;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class JwtConfig {
    
    private final String ENCRYPTION_KEY = "2e9c406e66688dc90cbde28fc1560cd40acecccfcadd579024b6a0c1c80db7fd8cd8cdc8dvq6v9nhyju9cd562d6fvgtb65yt9r6sdf5gn1uj39k7tgr4en1r5tiu4t4f51848962115e5h5tj4t1f2e";
    
    
    public String generate(User user){
        final Long currentime = System.currentTimeMillis();
        final Long expirationTime = currentime+30*60*1000;

        final Map<String, Object> claims = Map.of(
            "name" , user.getName(),
            Claims.SUBJECT, user.getEmail(),
            Claims.EXPIRATION, new Date(expirationTime)
        );

        final String bearer = Jwts.builder()
            .setIssuedAt(new Date(currentime))
            .setExpiration(new Date(expirationTime))
            .setSubject(user.getEmail())
            .setClaims(claims)
            .signWith(getKey(), SignatureAlgorithm.HS512)
            .compact();

        return bearer;
    }

    public Key getKey(){
        final byte[] decoder = Decoders.BASE64.decode(ENCRYPTION_KEY);

        return Keys.hmacShaKeyFor(decoder);
    }

     public String extractUsername(String token) {
        return this.getClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        return this.getClaim(token, Claims::getExpiration);
    }

    private <T> T getClaim(String token, Function<Claims, T> function) {
        Claims claims = getAllClaims(token);
        System.out.println("claims : "+claims);
        return function.apply(claims);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
