package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Distribuidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistribuidorRepo extends JpaRepository<Distribuidor, String> {
    Distribuidor findByNitDistribuidor(String nitDistribuidor);
}
