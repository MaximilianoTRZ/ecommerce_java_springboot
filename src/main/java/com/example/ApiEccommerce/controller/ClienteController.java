package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.DTOs.RegistroDTO;
import com.example.ApiEccommerce.entities.Cliente;
import com.example.ApiEccommerce.services.ClienteService;
import com.example.ApiEccommerce.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/signup")
    public String mostrarSignup() {
        try {
            return "views/signup/index";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/saveUsuario")
    public String registrarUsuario(@ModelAttribute("nuevoUsuario") RegistroDTO registration) throws Exception{
        clienteService.save(registration);
        return "views/Signin/index";
    }
}
