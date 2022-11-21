package com.example.ApiEccommerce.controller;



import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.entities.Factura;
import com.example.ApiEccommerce.repositories.CuentaRepository;
import com.example.ApiEccommerce.services.CuentaServiceImpl;

import com.example.ApiEccommerce.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cuenta")
public class CuentaController extends BaseControllerImpl<Cuenta, CuentaServiceImpl>{
    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    FacturaService facturaService;

    @GetMapping("/Signin")
    public String signin() {
    	
        return "views/Signin";
    }

    @GetMapping("/Signin/verificar")
    public String verificar(Model model) {

    	
        return "views/inicio";
    }

    @GetMapping("/Signin/logout")
    public String logOut() {
        return "views/inicio";
    }


    @GetMapping("/facturas")
    public String facturas(Model model) {
        try {

        List<Factura> listFactura = facturaService.findAll();
        model.addAttribute("listFactura", listFactura);

            return "views/facturas";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }

    



}