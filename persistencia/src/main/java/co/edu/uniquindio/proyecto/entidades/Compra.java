package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompra")
    private int idCompra;

    @Column(name= "fecha")
    private Date fecha;

    @Column(name = "total")
    private double total;

    @ManyToOne
    private Socio socioCompra;

    @OneToMany( mappedBy = "compraDetalle")
    private List<DetalleCompra> detalleCompras;

    @OneToMany( mappedBy = "compraEstado")
    private List<DetalleEstado> estados;

    public Compra() {
        super();
    }
}
