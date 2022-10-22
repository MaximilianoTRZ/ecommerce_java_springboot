package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.services.CuentaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cuentas")
public class CuentaController extends BaseControllerImpl<Cuenta, CuentaServiceImpl>{

}
