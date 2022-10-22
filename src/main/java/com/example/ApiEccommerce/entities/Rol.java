package com.example.ApiEccommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited

@Entity
@Table(name= "rol")

public class Rol extends Base{

    private String nombreRol;
}
