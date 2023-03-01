package com.pragma.powerup.plazoleta.infraestructure.remote.feing;

import com.pragma.powerup.plazoleta.application.dto.request.UsuarioRemoteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.UsuarioRemoteResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "usuario", url = "http://localhost:8081/api/v1/usuario")
public interface UsuarioRemoteClient {

    @RequestMapping(method = RequestMethod.GET, value = "/validarRolUsuario/{usuarioId}", produces = "application/json")
    UsuarioRemoteResponseDto validarRolUsuario(@PathVariable("usuarioId") Long postId);

    @RequestMapping(method = RequestMethod.GET, value = "/validarUsuarioPorCorreo", produces = "application/json")
    UsuarioRemoteResponseDto validarUsuarioPorCorreo(@RequestBody UsuarioRemoteRequestDto usuarioRemoteRequestDto);

}
