package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Ganancia;

import java.util.List;

public interface GananciaServicio {
    Ganancia registrarGanancia(Ganancia g) throws Exception;

    Ganancia actualizarGanancia(Ganancia g) throws Exception;

    List<Ganancia> listarGanancia();
}
