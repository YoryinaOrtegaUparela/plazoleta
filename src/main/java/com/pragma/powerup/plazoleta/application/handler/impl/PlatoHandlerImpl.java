package com.pragma.powerup.plazoleta.application.handler.impl;

import com.pragma.powerup.plazoleta.application.dto.request.MenuRequestDto;
import com.pragma.powerup.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.MenuResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.SeccionMenuResponseDto;
import com.pragma.powerup.plazoleta.application.handler.PlatoHandler;
import com.pragma.powerup.plazoleta.application.mapper.PlatoMapper;
import com.pragma.powerup.plazoleta.domain.api.PlatoServicePort;
import com.pragma.powerup.plazoleta.domain.model.Menu;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.model.SeccionMenu;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Negative;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoHandlerImpl implements PlatoHandler {

    private PlatoMapper platoMapper;
    private PlatoServicePort platoServicePort;


    public PlatoHandlerImpl(PlatoMapper platoMapper, PlatoServicePort platoServicePort) {
        this.platoMapper = platoMapper;
        this.platoServicePort = platoServicePort;
    }

    @Override
    public PlatoResponseDto crearPlato(PlatoRequestDto platoRequestDto) {
        //Mapeo plato requestDto a un plato
        Plato plato = platoMapper.convertirPlatoRequestDtoAPlato(platoRequestDto);
        //llevo el plato a través del puerto de servicio
        Plato platoGuardado = platoServicePort.crearPlato(plato);
        PlatoResponseDto platoResponseDto = platoMapper.convertirPlatoAPlatoResponsetDto(platoGuardado);
        return platoResponseDto;
    }

    @Override
    public PlatoResponseDto modificarPlato(PlatoRequestDto platoRequestDto) {
        Plato plato = platoMapper.convertirPlatoRequestDtoAPlato(platoRequestDto);
        Plato platoModificado = platoServicePort.modificarPlato(plato);
        PlatoResponseDto platoResponseDto = platoMapper.convertirPlatoAPlatoResponsetDto(platoModificado);
        return platoResponseDto;
    }

    @Override
    public PlatoResponseDto activarODesactivarPlato(PlatoRequestDto platoRequestDto) {
        Plato plato = platoMapper.convertirPlatoRequestDtoAPlato(platoRequestDto);
        Plato platoActualizado = platoServicePort.activarODesactivarPlato(plato);
        PlatoResponseDto platoResponseDto = platoMapper.convertirPlatoAPlatoResponsetDto(platoActualizado);
        return platoResponseDto;
    }

    @Override
    public MenuResponseDto obtenerMenu(MenuRequestDto menuRequestDto) {
        Menu menu = new Menu();

        menu.setIdRestaurantes(menuRequestDto.getIdRestaurantes());
        menu.setPagina(menuRequestDto.getPagina());
        menu.setNumeroRegistros(menuRequestDto.getNumeroRegistros());

        List<SeccionMenu> listaSeccionMenu = platoServicePort.obtenerMenu(menu);

        List<SeccionMenuResponseDto> seccionMenuResponseDto = new ArrayList<>();

        for (SeccionMenu seccion:listaSeccionMenu) {
            SeccionMenuResponseDto seccionMenuResponseDto1 = new SeccionMenuResponseDto();
            seccionMenuResponseDto1.setCategoria(seccion.getCategoria());

            List<PlatoResponseDto> platoResponseDtoList = new ArrayList<>();
            List<Plato> platos= seccion.getPlatos();
            for (Plato plato: platos) {
                PlatoResponseDto platoResponseDto = new PlatoResponseDto();
                platoResponseDto.setNombre(plato.getNombre());
                platoResponseDto.setDescripcion(plato.getDescripcion());
                platoResponseDto.setPrecio(plato.getPrecio());
                platoResponseDtoList.add(platoResponseDto);

            }
            seccionMenuResponseDto1.setPlatoResponseDtoList(platoResponseDtoList);
            seccionMenuResponseDto.add(seccionMenuResponseDto1);
        }

        MenuResponseDto menuResponseDto = new MenuResponseDto();
        menuResponseDto.setSeccionMenuResponseDtos(seccionMenuResponseDto);

        return menuResponseDto;
    }
}
