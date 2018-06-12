package com.vsatyarc.model.security;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by VSatyaRC
 * E-Mail: v.satya.rc@gmail.com
 */

@Document
public class User {

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;
    private String password;
    private String name;
    private String email;
    private Boolean terms;
    private String mobileNumber;
    private Boolean enabled;
    private Date lastPasswordResetDate;
    private List<Authority> authorities;
    private String gender;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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