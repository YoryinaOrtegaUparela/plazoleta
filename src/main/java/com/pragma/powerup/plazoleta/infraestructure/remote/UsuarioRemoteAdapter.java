package com.pragma.powerup.plazoleta.infraestructure.remote;

import com.pragma.powerup.plazoleta.application.dto.response.UsuarioRemoteResponseDto;
import com.pragma.powerup.plazoleta.domain.spi.UsuarioRemotePort;
import com.pragma.powerup.plazoleta.infraestructure.remote.feing.UsuarioRemoteClient;

public class UsuarioRemoteAdapter implements UsuarioRemotePort {

    private UsuarioRemoteClient usuarioRemoteClient;

    public UsuarioRemoteAdapter(UsuarioRemoteClient usuarioRemoteClient) {
        this.usuarioRemoteClient = usuarioRemoteClient;
    }

    @Override
    public UsuarioRemoteResponseDto validarRolUsuario(Long idUsuario) {
        return usuarioRemoteClient.validarRolUsuario(idUsuario);
    }
}
