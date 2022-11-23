package com.example.ApiEccommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
@Table(name= "articulo")

public class Articulo extends Base{

    private String nombre;

    private double precio;

    private String descripcion;

    private String foto;

    private int stock;

    private Date fechaVigencia;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_categoria")
    private Categoria categoria;
}