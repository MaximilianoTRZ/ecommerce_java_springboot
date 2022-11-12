package com.example.ApiEccommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;


import javax.persistence.*;

import java.util.Collection;
import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
@Table(name= "cuenta")

public class Cuenta extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private Date fechaFinVigencia;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "cuenta_roles",
            joinColumns = @JoinColumn(name = "cuenta_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
    )
    private Collection<Rol> roles;
}