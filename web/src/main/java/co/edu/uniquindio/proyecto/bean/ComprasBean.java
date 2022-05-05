package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.config.TextExporter;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;
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
public class ComprasBean implements Serializable {

    @Autowired
    private CompraServicio compraServicio;

    @Getter
    @Setter
    private List<Compra> compras;

    @Getter
    @Setter
    private Exporter<DataTable> textExporter;

    @PostConstruct
    public void init() {
        compras = compraServicio.listarCompra();
        textExporter = new TextExporter();
    }
}
