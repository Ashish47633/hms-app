package com.hms.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenDto {
    private String token;
    private String type;

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
