package com.vsatyarc.controller;


import com.vsatyarc.jwt.JwtTokenUtil;
import com.vsatyarc.services.CustomUserDetails;
import com.vsatyarc.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by VSatyaRC
 * E-Mail: v.satya.rc@gmail.com
 */

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public CustomUserDetails getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        CustomUserDetails user = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
        return user;
    }

}
