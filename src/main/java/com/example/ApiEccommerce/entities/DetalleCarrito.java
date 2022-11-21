package com.example.ApiEccommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited

@Entity
@Table(name= "detalleCarrito")

public class DetalleCarrito extends Base{

    private int cantidad;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_articulo")
    private Articulo articulo;
}
