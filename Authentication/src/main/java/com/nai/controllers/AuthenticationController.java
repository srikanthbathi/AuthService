package com.nai.controllers;


import com.nai.auth.jwt.JwtTokenUtil;
import com.nai.domain.AuthRequest;
import com.nai.domain.User;
import com.nai.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    MongoTemplate userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/validate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        if (authenticate(authRequest.getUsername(), authRequest.getPassword())){
            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
            String jwt = jwtTokenUtil.generateToken(userDetails);
            Map<String, String> k = new HashMap<>();
            k.put("jwt", jwt);
            return ResponseEntity.ok(k);
        }

            return ResponseEntity.ok("INVALID USER");
    }

    @PostMapping("/signin")
    public Map<String, String> signin(@RequestBody User user) {
        String pass = user.getPassword();
        pass = bCryptPasswordEncoder.encode(pass);
        user.setPassword(pass);
        userRepository.insert(user);
        String jwt = jwtTokenUtil.generateToken(new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities()));
        Map<String, String> k = new HashMap<>();
        k.put("jwt", jwt);
        return k;
    }


    private boolean authenticate(String user, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user, password));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
