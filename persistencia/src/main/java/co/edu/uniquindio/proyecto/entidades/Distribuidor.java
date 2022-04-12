package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Distribuidor implements Serializable {

    @Id
    @Column(name = "nitDistribuidor")
    @EqualsAndHashCode.Include
    private String nitDistribuidor;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "ciudad", length = 30, nullable = false, unique = true)
    private String ciudad;

    @OneToMany(mappedBy = "distribuidorPedido")
    private List<Pedido> pedidos;
}
