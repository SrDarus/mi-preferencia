package com.memoria_colectiva.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import com.memoria_colectiva.api.models.entity.Authority;

public class SecurityAuthority implements GrantedAuthority {
    @Autowired
    private Authority authority;

    public SecurityAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
    
}
