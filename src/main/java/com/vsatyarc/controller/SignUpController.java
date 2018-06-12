package com.vsatyarc.controller;


import com.vsatyarc.controller.dto.UserRegistrationDTO;
import com.vsatyarc.jwt.JwtTokenUtil;
import com.vsatyarc.model.security.User;
import com.vsatyarc.repository.UserRepository;
import com.vsatyarc.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/signUp")
public class SignUpController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping
    public Map registerUserAccount(@RequestBody UserRegistrationDTO userDto) {

        String userEmail = userDto.getEmail();
        System.out.println("User Details: " + userDto);
        User user = userRepository.findByEmail(userEmail);

        Map<String, String> response = new HashMap();

        if (user != null) {
            response.put("status", "0");
            response.put("message", "User exists already.");
            return response;
        } else {
            userRepository.save(userDto.getUser());
            final UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
            final String token = jwtTokenUtil.generateToken(userDetails);
            response.put("status", "1");
            response.put("token", token);
            response.put("message", "User registration successful.");
            return response;

        }

    }
}
