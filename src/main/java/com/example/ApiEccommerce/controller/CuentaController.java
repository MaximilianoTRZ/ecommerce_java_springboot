package com.example.ApiEccommerce.controller;



import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.services.CuentaServiceImpl;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cuenta")
public class CuentaController extends BaseControllerImpl<Cuenta, CuentaServiceImpl>{
	
	CuentaServiceImpl cs;
	
    @GetMapping("/Signin")
    public String signin() {
        try {
            return "views/Signin";
        } catch (Exception e) {
            return "error";
        }

    }
	
    @PostMapping("/Signin/verificar")
    public String verificar(Model model,@RequestParam(value="username") String username) {
        try {
            return "views/inicio";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }
    

    
  

}
