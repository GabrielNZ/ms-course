package com.gabrielnz.hroauth.feignclients;

import com.gabrielnz.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam(defaultValue = "null@null.com") String email);
}
