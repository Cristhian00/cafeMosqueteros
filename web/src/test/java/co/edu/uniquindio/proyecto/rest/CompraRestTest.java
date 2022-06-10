package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.WepApplication;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.SocioServicio;
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
public class CompraRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CompraServicio compraServicio;

    @Autowired
    private ProductoServicio producto;

    @Autowired
    private SocioServicio socio;

    @Test
    @Transactional
    public void listar() throws Exception {
        mockMvc.perform(get("/api/compra")
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void listarDetallesTest() throws Exception {
        mockMvc.perform(get("/api/compra/detalle")
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void obtenerPorIdTest() throws Exception {
        mockMvc.perform(get("/api/compra/id/{id}", 1)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void registrarTest() throws Exception {
        Compra compra = new Compra(socio.obtenerSocio("123456"), null, EstadoCompra.PENDIENTE);

        mockMvc.perform(post("/api/compra").contentType("application/json")
                        .content(objectMapper.writeValueAsString(compra))).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

    @Test
    @Transactional
    public void actualizarEstadoTest() throws Exception {
        Compra compra = new Compra(socio.obtenerSocio("123456"), null, EstadoCompra.RECHAZADA);
        compra.setIdCompra(1);

        mockMvc.perform(put("/api/compra/actualizar")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(compra)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void agregarDetalleTets() throws Exception {
        Producto proAux = producto.obtenerProducto(2);
        DetalleCompra detalleCompra = new DetalleCompra(10, proAux.getPrecioVenta(),
                proAux, compraServicio.obtenerCompra(1));

        mockMvc.perform(post("/api/compra/agregarProducto").contentType("application/json")
                        .content(objectMapper.writeValueAsString(detalleCompra))).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

    @Test
    @Transactional
    public void eliminarTest() throws Exception {
        mockMvc.perform(delete("/api/compra/eliminar/{id}", 1)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
