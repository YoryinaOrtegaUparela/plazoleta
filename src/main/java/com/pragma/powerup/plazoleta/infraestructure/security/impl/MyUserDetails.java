package com.pragma.powerup.plazoleta.infraestructure.security.impl;


import com.pragma.powerup.plazoleta.application.dto.response.UsuarioRemoteResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetails implements UserDetails {

    private UsuarioRemoteResponseDto usuarioRemoteResponseDto;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + usuarioRemoteResponseDto.getCodigoRol()));
    }

    @Override
    public String getPassword() {
        return usuarioRemoteResponseDto.getClave();
    }

    @Override
    public String getUsername() {
        return usuarioRemoteResponseDto.getCorreo();
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
