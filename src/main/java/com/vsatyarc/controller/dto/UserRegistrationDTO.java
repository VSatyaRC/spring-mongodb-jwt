package com.vsatyarc.controller.dto;


import com.vsatyarc.model.security.Authority;
import com.vsatyarc.model.security.AuthorityName;
import com.vsatyarc.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VSatyaRC
 * E-Mail: v.satya.rc@gmail.com
 */

public class UserRegistrationDTO {


    private User user;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @Email
    @NotEmpty
    private String email;

    @AssertTrue
    private Boolean terms;

    @NotEmpty
    private String mobileNumber;

    private String gender;

    private String role;

    public String getRole() {
        return role;
    }

    @Autowired
    private PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

    public User getUser() {


        user = new User();

        user.setName(getName());
        user.setEmail(getEmail());
        user.setTerms(getTerms());
        user.setMobileNumber(getMobileNumber());
        user.setGender(getGender());
        user.setPassword(passwordEncoder.encode(getPassword()));

        Authority authority = new Authority();
        List<Authority> authorities = new ArrayList<>();

        if (role.matches("ROLE_USER")) {
            authority.setName(AuthorityName.ROLE_USER);
        } else {
            authority.setName(AuthorityName.ROLE_ADMIN);

        }
        authorities.add(authority);
        user.setAuthorities(authorities);

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return
                "Name: " + name + "/n" +
                        "E-mail: " + email + "/n" +
                        "Password: ********/n" +
                        "Mobile Number: " + mobileNumber + "/n" +
                        "Gender: " + gender + "/n" +
                        "Terms: " + terms + "/n";
    }
}
