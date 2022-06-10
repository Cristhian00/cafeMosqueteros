package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.WepApplication;
import co.edu.uniquindio.proyecto.entidades.EstadoSocio;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.servicios.JerarquiaServicio;
import co.edu.uniquindio.proyecto.servicios.SocioServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WepApplication.class)
@AutoConfigureMockMvc
public class SocioRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SocioServicio padre;

    @Autowired
    private JerarquiaServicio jerarquia;

    @Test
    @Transactional
    public void listarSociosTest() throws Exception {
        mockMvc.perform(get("/api/socio")
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void obtenerSocioTest() throws Exception {
        mockMvc.perform(get("/api/socio/id/{cedula}", 123456)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void crearSocioTest() throws Exception {

        Socio socio = new Socio("777999", "Fabricio", "Gomez", "fabri@gmail.com",
                "3109877676", "socio", new Date(), EstadoSocio.PENDIENTE,
                padre.obtenerSocio("123456"), jerarquia.obtenerJerarquia(1));

        mockMvc.perform(post("/api/socio").contentType("application/json")
                        .content(objectMapper.writeValueAsString(socio))).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

    @Test
    @Transactional
    public void eliminarSocioTest() throws Exception {
        mockMvc.perform(delete("/api/socio/eliminar/{cedula}", 102938)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void actualizarSocioTest() throws Exception {
        Socio socio = new Socio("102938", "Fabricio", "Gomez", "fabri@gmail.com",
                "3109877676", "socio", new Date(), EstadoSocio.PENDIENTE,
                padre.obtenerSocio("123456"), jerarquia.obtenerJerarquia(1));
        socio.setPrimerNombre("Luisa");
        socio.setEstado(EstadoSocio.ACTIVO);

        mockMvc.perform(put("/api/socio/actualizar/{cedula}", socio.getCedula())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(socio)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
