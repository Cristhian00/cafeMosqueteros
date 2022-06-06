package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.WepApplication;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.TipoProductoServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WepApplication.class)
@AutoConfigureMockMvc
public class ProductoRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private TipoProductoServicio tipo;

    @Test
    @Transactional
    public void listarProductosTest() throws Exception {
        mockMvc.perform(get("/api/producto")
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void obtenerPorIdTest() throws Exception {
        mockMvc.perform(get("/api/producto/id/{id}", 1)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void registrarTest() throws Exception {
        Producto producto = new Producto("Milo", "Es un polvo para preparar bebidas", 18000,
                8900, 100, tipo.obtenerTipo(2));

        mockMvc.perform(post("/api/producto").contentType("application/json")
                        .content(objectMapper.writeValueAsString(producto))).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

    @Test
    @Transactional
    public void actualizarTest() throws Exception {
        Producto producto = productoServicio.obtenerProducto(1);
        producto.setNombre("Miel de café");
        producto.setUnidadesDisponibles(200);

        mockMvc.perform(put("/api/producto/actualizar/{id}", producto.getIdProducto())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(producto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void eliminarTest() throws Exception {
        mockMvc.perform(delete("/api/producto/eliminar/{id}", 1)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
