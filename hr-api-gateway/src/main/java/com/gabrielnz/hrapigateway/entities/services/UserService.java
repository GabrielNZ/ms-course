package com.gabrielnz.hrapigateway.entities.services;

import com.gabrielnz.hrapigateway.entities.User;
import com.gabrielnz.hrapigateway.entities.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserFeignClient userFeignClient;

    public User findByEmail(String email) {
    User user = userFeignClient.findByEmail(email).getBody();
    if(user == null){
        throw new IllegalArgumentException("Email not found");
    }
        return user;
    }
}
