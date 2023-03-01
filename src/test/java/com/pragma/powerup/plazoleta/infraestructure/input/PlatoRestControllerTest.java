package com.pragma.powerup.plazoleta.infraestructure.input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.powerup.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.plazoleta.application.handler.PlatoHandler;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(value = PlatoRestController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class PlatoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PlatoHandler platoHandler;

    @Test
    void crearPlato() throws Exception {
        PlatoRequestDto platoRequestDto = new PlatoRequestDto();
        PlatoResponseDto platoResponseDto = new PlatoResponseDto();

        String request = objectMapper.writeValueAsString(platoRequestDto);
        String response = objectMapper.writeValueAsString(platoResponseDto);

        when(platoHandler.crearPlato(Mockito.any())).thenReturn(platoResponseDto);

        this.mockMvc.perform(post("/api/v1/plazoleta/plato/crearPlato").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(response)));
    }

    @Test
    void modificarPlato() throws Exception {

        PlatoRequestDto platoRequestDto = new PlatoRequestDto();
        PlatoResponseDto platoResponseDto = new PlatoResponseDto();

        String request = objectMapper.writeValueAsString(platoRequestDto);
        String response = objectMapper.writeValueAsString(platoResponseDto);

        when(platoHandler.modificarPlato(Mockito.any())).thenReturn(platoResponseDto);

        this.mockMvc.perform(patch("/api/v1/plazoleta/plato/modificarPlato").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(response)));
    }

    @Test
    void habilitarODeshabilitarPlato() throws Exception {

        PlatoRequestDto platoRequestDto = new PlatoRequestDto();
        PlatoResponseDto platoResponseDto = new PlatoResponseDto();

        String request = objectMapper.writeValueAsString(platoRequestDto);
        String response = objectMapper.writeValueAsString(platoResponseDto);

        when(platoHandler.activarODesactivarPlato(Mockito.any())).thenReturn(platoResponseDto);

        this.mockMvc.perform(patch("/api/v1/plazoleta/plato/habilitarDeshabilitarPlato").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(response)));
    }
}