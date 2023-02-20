package com.pragma.powerup.plazoleta.infraestructure.remote.feing;

import com.pragma.powerup.plazoleta.application.dto.UsuarioRemoteResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "usuario", url = "http://localhost:8081/api/v1/usuario/validarRolUsuario")
public interface UsuarioRemoteClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{usuarioId}", produces = "application/json")
    UsuarioRemoteResponseDto validarRolUsuario(@PathVariable("usuarioId") Long postId);
}
