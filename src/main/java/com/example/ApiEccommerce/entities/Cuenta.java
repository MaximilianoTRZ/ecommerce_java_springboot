package com.example.ApiEccommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
@Table(name= "cuenta")

public class Cuenta extends Base{

    private String email;

    private String password;

    private Date fechaFinVigencia;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="cuenta_rol",
            joinColumns =@JoinColumn(name ="email"),
            inverseJoinColumns =
            @JoinColumn(name="rol_id"))
    private List<Rol> rol = new ArrayList<Rol>();
}
