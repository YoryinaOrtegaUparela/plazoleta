package com.pragma.powerup.plazoleta.infraestructure.security.impl;

import com.pragma.powerup.plazoleta.application.dto.request.UsuarioRemoteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.UsuarioRemoteResponseDto;
import com.pragma.powerup.plazoleta.domain.spi.UsuarioRemotePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements  UserDetailsService {
    private final UsuarioRemotePort usuarioRemotePort;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        UsuarioRemoteRequestDto usuarioRemoteRequestDto = new UsuarioRemoteRequestDto();
        usuarioRemoteRequestDto.setCorreo(correo);

        UsuarioRemoteResponseDto usuarioRemoteResponseDto =
                usuarioRemotePort.validarUsuarioPorCorreo(usuarioRemoteRequestDto);

        return new MyUserDetails(usuarioRemoteResponseDto);
    }
}
