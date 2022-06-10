package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.WepApplication;
import co.edu.uniquindio.proyecto.entidades.NoSocio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WepApplication.class)
@AutoConfigureMockMvc
public class NoSocioRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    public void listarNoSociosTest() throws Exception {
        mockMvc.perform(get("/api/noSocio")
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void obtenerNoSocioTest() throws Exception {
        mockMvc.perform(get("/api/noSocio/id/{cedula}", 123456)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void crearNoSocioTest() throws Exception {
        NoSocio noSocio = new NoSocio("777999", "Fabricio", "Gomez", "fabri@gmail.com",
                "3109877676", "usuario");

        mockMvc.perform(post("/api/noSocio").contentType("application/json")
                        .content(objectMapper.writeValueAsString(noSocio))).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

    @Test
    @Transactional
    public void eliminarNoSocioTest() throws Exception {
        mockMvc.perform(delete("/api/noSocio/eliminar/{cedula}", 444666)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void actualizarNoSocioTest() throws Exception {
        NoSocio noSocio = new NoSocio("444666", "Fabricio", "Gomez", "fabri@gmail.com",
                "3109877676", "usuario");
        noSocio.setPrimerNombre("Luisa");
        noSocio.setCelular("3222224323");

        mockMvc.perform(put("/api/noSocio/actualizar/{cedula}", noSocio.getCedula())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(noSocio)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
