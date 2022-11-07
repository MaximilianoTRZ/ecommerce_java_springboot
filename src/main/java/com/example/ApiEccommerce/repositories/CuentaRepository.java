package com.example.ApiEccommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.entities.Cuenta;

public interface CuentaRepository extends BaseRepository<Cuenta, Long>{
	
    @Query(
            value = "SELECT usuario,contrasenia FROM Cuenta "
            		+ "WHERE usuario = user and contrasenia = password ",
            nativeQuery = true)
    Cuenta verifyByUserPass(@Param("user") String user,@Param("pass") String password);
	
	
}
