package com.vsatyarc.jwt;


import java.io.Serializable;

/**
 * Created by VSatyaRC
 * E-Mail: v.satya.rc@gmail.com
 */

public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
