package com.gabrielnz.hroauth.services;

import com.gabrielnz.hroauth.entities.User;
import com.gabrielnz.hroauth.feignclients.UserFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserFeignClient userFeignClient;

@CircuitBreaker(name = "hr-user", fallbackMethod = "fallback")
    public User findByEmail(String email) {
    User user = userFeignClient.findByEmail(email).getBody();
    if(user == null){
        throw new IllegalArgumentException("Email not found");
    }
        return user;
    }

    public User fallback(String email, Throwable throwable) {
        return new User();
    }
}
