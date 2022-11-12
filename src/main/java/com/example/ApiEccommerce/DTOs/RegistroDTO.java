package com.example.ApiEccommerce.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDTO {

    private String nombre;
    private String apellido;
    private String direccion;
    private int nroDireccion;
    private String usuario;
    private String contrasenia;
    private String email;

}
