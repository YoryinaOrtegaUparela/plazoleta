package com.pragma.powerup.plazoleta.domain.spi;

import com.pragma.powerup.plazoleta.application.dto.UsuarioRemoteResponseDto;

public interface UsuarioRemotePort {
    UsuarioRemoteResponseDto validarRolUsuario(Long idUsuario);


}