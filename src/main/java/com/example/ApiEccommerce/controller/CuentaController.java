package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.services.CategoriaService;
import com.example.ApiEccommerce.services.CuentaServiceImpl;

import lombok.extern.java.Log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cuenta")
public class CuentaController extends BaseControllerImpl<Cuenta, CuentaServiceImpl>{
	
	CuentaServiceImpl cs;
    @GetMapping("/verficar")
    public String signin(@ModelAttribute Model model,
    		 @RequestParam(value="query", required = false) String user, 
             @RequestParam(value="query", required = false) String password) {
        try {
        	System.out.println("AAAAAAAAAAAAAA");
        	Cuenta cuenta = cs.verifyByUserPass(user, password); 
        	System.out.println("AAAAAAAAAAAAAA");
        	System.out.println(cuenta);

            return "views/inicio";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }
    
    @GetMapping("/signin")
    public String signin(Model model) {
        try {
            return "views/Signin";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }
    
  

}
