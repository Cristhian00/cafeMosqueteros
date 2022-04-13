package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleCompraTest {
    @Autowired
    private DetalleCompraRepo  detalleCompraRepo ;

    @Test
    public void registrarDetalleCompraTest(){
    DetalleCompra detalleCompra = new DetalleCompra();
    detalleCompra.setCantidad(3);
    detalleCompra.setPrecioUnitario(15.000);


    }
    @Test
    public void eliminarDetalleCompraTest(){
        DetalleCompra detalleCompra = new DetalleCompra();

    }
    @Test
    public void actualizarCompraTest(){

    }
    @Test
    public void listarDetalleCompraTest(){

    }
}
