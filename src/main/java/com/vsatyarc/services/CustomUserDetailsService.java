package com.vsatyarc.services;


import com.vsatyarc.model.security.User;
import com.vsatyarc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by VSatyaRC
 * E-Mail: v.satya.rc@gmail.com
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User tempUser = userRepository.findByEmail(email);
        if (tempUser != null) {
            return new CustomUserDetails(tempUser);
        }
        return null;
    }

}
