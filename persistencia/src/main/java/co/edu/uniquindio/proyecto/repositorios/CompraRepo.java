package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("SELECT c FROM Compra c WHERE c.socioCompra.cedula = ?1")
    List<Compra> obtenerCompras(String cedula);

    @Query("SELECT c FROM Compra c WHERE c.fecha = ?1")
    List<Compra> obtenerCompras(Date fecha);

    @Query("SELECT c FROM Compra c WHERE c.idCompra = ?1")
    Compra obtenerCompra(int id);


}
