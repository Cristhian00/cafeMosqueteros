package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.config.TextExporter;
import co.edu.uniquindio.proyecto.entidades.NoSocio;
import co.edu.uniquindio.proyecto.entidades.Socio;
import co.edu.uniquindio.proyecto.servicios.NoSocioServicio;
import co.edu.uniquindio.proyecto.servicios.SocioServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class SociosBean implements Serializable {

    @Autowired
    private SocioServicio socioServicio;

    @Getter
    @Setter
    private List<Socio> socios;

    @Getter
    @Setter
    private Exporter<DataTable> textExporter;

    @PostConstruct
    public void init() {
        socios = socioServicio.listarSocio();
        textExporter = new TextExporter();
    }
}
