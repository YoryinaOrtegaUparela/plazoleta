package com.pragma.powerup.plazoleta.infraestructure.input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.powerup.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.ListaRestaurantesResponseDto;
import com.pragma.powerup.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.powerup.plazoleta.application.handler.RestauranteHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = RestauranteRestController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class RestauranteRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RestauranteHandler restauranteHandler;

    @Test
    void crearRestaurante() throws Exception {

        RestauranteRequestDto restauranteRequestDto = new RestauranteRequestDto();
        RestauranteResponseDto restauranteResponseDto = new RestauranteResponseDto();

        String request = objectMapper.writeValueAsString(restauranteRequestDto);
        String response = objectMapper.writeValueAsString(restauranteResponseDto);

        when(restauranteHandler.crearRestaurante(Mockito.any())).thenReturn(restauranteResponseDto);

        this.mockMvc.perform(post("/api/v1/plazoleta/restaurante/crearRestaurante").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(response)));
    }

    @Test
    void listarRestaurantes() throws Exception {

        RestauranteRequestDto restauranteRequestDto = new RestauranteRequestDto();
        ListaRestaurantesResponseDto listaRestaurantesResponseDto = new ListaRestaurantesResponseDto();
        String response = objectMapper.writeValueAsString(listaRestaurantesResponseDto);

        when(restauranteHandler.listarRestaurantes(restauranteRequestDto)).thenReturn(listaRestaurantesResponseDto);

        this.mockMvc.perform(get("/api/v1/plazoleta/restaurante/listarRestaurantes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(response)));
    }
}