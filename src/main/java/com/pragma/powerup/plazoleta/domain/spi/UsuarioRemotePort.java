package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.application.dto.request.UsuarioRemoteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.UsuarioRemoteResponseDto;

public interface UsuarioRemotePort {
    UsuarioRemoteResponseDto validarRolUsuario(Long idUsuario);

    UsuarioRemoteResponseDto validarUsuarioPorCorreo(UsuarioRemoteRequestDto usuarioRemoteRequestDto);
}
