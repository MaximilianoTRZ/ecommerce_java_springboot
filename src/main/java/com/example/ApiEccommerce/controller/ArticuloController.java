package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.services.ArticuloServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")  //en @Controller esto no es necesario?
@RequestMapping(path = "api/v1/articulos")  //en @Controller esto no es necesario?
public class ArticuloController extends BaseControllerImpl<Articulo, ArticuloServiceImpl> {

    @GetMapping("/carrito")
    public String carrito(Model model) {
        try {
            return "views/carrito";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }

    @GetMapping("/signup")
    public String signup(Model model) {
        try {
            return "views/Signup";
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

    @GetMapping("/detalle/{id}")
    public String detalleArticulo(Model model, @PathVariable("id") long id) {
        try {
            Articulo articulo = servicio.findById(id);
            model.addAttribute("detalleArticulo", articulo);
            return "views/detalleProducto";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }

    @GetMapping("/lista")
    public String ListaArticulos(Model model) throws Exception { //EL NOMBRE DEL METODO ES SOLO REPRESENTATIVO, NO SE UTILIZA
        try {
            List<Articulo> nombreVariable = servicio.findAll();
            model.addAttribute("nombreVariable", nombreVariable);
            return "views/productos"; //ACA TIENE QUE IR EL NOMBRE DE LA PLANTILLA DONDE SE QUIERE USAR
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }
    }

    @GetMapping("/inicio")
    public String inicio(Model model) throws Exception { //EL NOMBRE DEL METODO ES SOLO REPRESENTATIVO, NO SE UTILIZA
        try {
            String usuario = "Master";
            model.addAttribute("nombreVariable", usuario);
            return "views/inicio"; //ACA TIENE QUE IR EL NOMBRE DE LA PLANTILLA DONDE SE QUIERE USAR
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }
    }
}
