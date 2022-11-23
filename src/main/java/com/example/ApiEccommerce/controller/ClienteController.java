package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Cliente;
import com.example.ApiEccommerce.services.ClienteServiceImpl;
import com.example.ApiEccommerce.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolService rolService;

    //inicio funcion guardar un nuevo producto
    @GetMapping("/nuevo")
    public String crearNuevoCliente(Model model) {
        try {
            Cliente nuevoCliente = new Cliente();

            model.addAttribute("nuevoCliente", nuevoCliente);


            return "views/Signup";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("nuevoCliente") Cliente cliente) throws Exception {

        cliente.getCuenta().setPassword(passwordEncoder.encode(cliente.getCuenta().getPassword()));
        servicio.save(cliente);
        return "redirect:/api/v1/cuenta/Signin";
    }

}
