package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Factura;
import com.example.ApiEccommerce.services.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/facturas")
public class FacturaController extends BaseControllerImpl<Factura , FacturaServiceImpl>{

}
