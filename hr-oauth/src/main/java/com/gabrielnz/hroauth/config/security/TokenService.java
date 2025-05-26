package com.gabrielnz.hroauth.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gabrielnz.hroauth.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RefreshScope
@Service
public class TokenService {
    @Value("${MY_SECRET}")
    private String mySecret;

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(mySecret);
        return JWT.create().withIssuer("API_JWT_TOKEN").withSubject(user.getEmail()).withExpiresAt(Instant.now().plusSeconds(1000)).sign(algorithm);
    }
    public String verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(mySecret);
        return JWT.require(algorithm).withIssuer("API_JWT_TOKEN").build().verify(token).getSubject();
    }
}
