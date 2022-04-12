package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Compra;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {
    @Autowired
    private eCompraRepo compraRepo;

    @Test
    public void registrarCompraTest(){
        Compra c = new Compra();
        c.setIdCompra(234);
        Compra guardada = compraRepo.save(c);
        //Comprobamos que si haya quedado
        Assertions.assertNotNull(guardada);

    }
    @Test
    public void eliminarCompraTest(){
        Compra c = new Compra();
        c.setIdCompra(234);

        //Primero lo guardamos
        Compra registrada = compraRepo.save(c);
        //Luego lo eliminamos
        compraRepo.delete(registrada);
        //Por último, verificamos que si haya quedado borrado
        Compra buscado = compraRepo.findById(432).orElse(null);
        Assertions.assertNull(buscado);
    }
    @Test
    public void actualizarCompraTest(){
        Compra c = new Compra();
        c.setIdCompra(543);

        //Primero lo guardamos
        Compra registrada = compraRepo.save(c);
        //Modificamos el nombre
        registrada.setIdCompra(765);
        //Con save guardamos el registro modificado
        compraRepo.save(registrada);
        //Por último, verificamos que si haya quedado actualizado
        Compra buscado = compraRepo.findById(32).orElse(null);
        //Assertions.assertEquals("Juanita Lopez", buscado.getNombre());
    }
    @Test
    public void listarCompraTest(){
        //Obtenemos la lista de todos los usuarios
        List<Compra> lista = compraRepo.findAll();
        //Imprimimos la lista
        System.out.println(lista);
    }
}
