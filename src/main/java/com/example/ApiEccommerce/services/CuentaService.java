package com.example.ApiEccommerce.services;




import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.ApiEccommerce.entities.Cuenta;


public interface CuentaService extends BaseService <Cuenta, Long>, UserDetailsService{

}