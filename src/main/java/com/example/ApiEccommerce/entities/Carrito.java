package com.example.ApiEccommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited

@Entity
@Table(name= "carrito")

public class Carrito extends Base{

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCarrito> detalleCarrito = new ArrayList<DetalleCarrito>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
}