package com.pragma.powerup.plazoleta.infraestructure.persistence.adapter;

import com.pragma.powerup.plazoleta.domain.exception.InformacionNoEncontradaException;
import com.pragma.powerup.plazoleta.domain.model.Categoria;
import com.pragma.powerup.plazoleta.domain.model.Menu;
import com.pragma.powerup.plazoleta.domain.model.Plato;
import com.pragma.powerup.plazoleta.domain.model.SeccionMenu;
import com.pragma.powerup.plazoleta.domain.spi.PlatoPersistencePort;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.IPlatoConCategoria;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoConCategoria;
import com.pragma.powerup.plazoleta.infraestructure.persistence.entity.PlatoEntity;
import com.pragma.powerup.plazoleta.infraestructure.persistence.mapper.PlatoEntityMapper;
import com.pragma.powerup.plazoleta.infraestructure.persistence.repository.PlatoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlatoPersistenceAdapter implements PlatoPersistencePort {

    private PlatoEntityMapper platoEntityMapper;
    private PlatoRepository platoRepository;

    public PlatoPersistenceAdapter(PlatoEntityMapper platoEntityMapper, PlatoRepository platoRepository) {
        this.platoEntityMapper = platoEntityMapper;
        this.platoRepository = platoRepository;
    }

    @Override
    public Plato crearPlato(Plato plato) {
        PlatoEntity platoEntity = platoEntityMapper.convertirPlatoAPlatoEntity(plato);
        PlatoEntity platoGuardado = platoRepository.save(platoEntity);

        plato.setId(platoGuardado.getId());
        return plato;
    }

    @Override
    public Plato obtenerPlatoPorId(Long idPlato) throws InformacionNoEncontradaException{
        Optional<PlatoEntity> platoEntityModificar = platoRepository.findById(idPlato);
        if(!platoEntityModificar.isPresent()){
            throw new InformacionNoEncontradaException("El plato suministrado no existe");
        }
        Plato platoModificar = platoEntityMapper.convertirPlatoEntityAPlato(platoEntityModificar.get());
        return platoModificar;
    }

    @Override
    public void modificarPlato(Plato platoModificado) {
        PlatoEntity platoEntity = platoEntityMapper.convertirPlatoAPlatoEntity(platoModificado);
        platoRepository.save(platoEntity);

    }

    @Override
    public List<SeccionMenu> obtenerSeccionMenu(Menu menu) {

        Pageable paginador = PageRequest.of(Integer.parseInt(menu.getPagina()+""),
                Integer.parseInt(menu.getNumeroRegistros()+""));

        List<PlatoConCategoria> platoConCategoria = platoRepository.platosConCategoria(menu.getIdRestaurantes(), paginador);

        //Lista con todas las categorias de cada plato del restaurante
        List<String> categoriasDeRestaurante = new ArrayList<>();
        for(int i=0; i<platoConCategoria.size(); i++){
            String categoriaPlato = platoConCategoria.get(i).getNombreCategoria();
            if(!categoriasDeRestaurante.contains(categoriaPlato)){
                categoriasDeRestaurante.add(categoriaPlato);
            }
        }

        //Lista de secciones de Menu
        List<SeccionMenu> seccionMenus = new ArrayList<>();
        for(String categoria: categoriasDeRestaurante){

            SeccionMenu seccionMenu = new SeccionMenu();
            seccionMenu.setCategoria(categoria);

            List<Plato> platosDeCategoria = new ArrayList<>();
            for(int i=0; i<platoConCategoria.size(); i++){
                if(categoria.equals(platoConCategoria.get(i).getNombreCategoria())) {
                    Plato plato = new Plato();
                    plato.setNombre(platoConCategoria.get(i).getNombre());
                    plato.setDescripcion(platoConCategoria.get(i).getDescripcion());
                    plato.setPrecio(String.valueOf(platoConCategoria.get(i).getPrecio()));
                    platosDeCategoria.add(plato);
                }
            }

            seccionMenu.setPlatos(platosDeCategoria);
            seccionMenus.add(seccionMenu);
        }
        return seccionMenus;
    }
}
