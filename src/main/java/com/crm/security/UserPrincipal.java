package com.crm.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.crm.core.model.Usuario;

public class UserPrincipal implements UserDetails{
    
    private static final long serialVersionUID = 7473133157963386488L;
    
    private String password;
    private String username;
    private Collection<GrantedAuthority> authorities;
    
    public UserPrincipal(Usuario usuario) {
        password = "";
        username = usuario.getEmail();
        authorities = usuario.getGrupos()
                .stream()
                .map(grupo -> new SimpleGrantedAuthority(grupo.getNombre()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
