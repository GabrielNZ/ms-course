package com.gabrielnz.hrapigateway.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class TokenService {
    @Value("${MY_SECRET}")
    private String mySecret;

    public String verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(mySecret);
        return JWT.require(algorithm).withIssuer("API_JWT_TOKEN").build().verify(token).getSubject();
    }
}