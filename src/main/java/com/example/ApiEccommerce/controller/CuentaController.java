package com.example.ApiEccommerce.controller;



import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.repositories.CuentaRepository;
import com.example.ApiEccommerce.services.CuentaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cuenta")
public class CuentaController extends BaseControllerImpl<Cuenta, CuentaServiceImpl>{
	@Autowired
	CuentaRepository cuentaRepository;

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
    
    
  

}
