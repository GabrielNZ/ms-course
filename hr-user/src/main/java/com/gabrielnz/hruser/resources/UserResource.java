package com.gabrielnz.hruser.resources;

import com.gabrielnz.hruser.entities.User;
import com.gabrielnz.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }
    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam(defaultValue = "null@null.com") String email) {
        return ResponseEntity.ok().body(userRepository.findByEmail(email));
    }
}
