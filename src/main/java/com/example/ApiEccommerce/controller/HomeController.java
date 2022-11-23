package com.example.ApiEccommerce.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.services.ArticuloServiceImpl;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/")
public class HomeController extends BaseControllerImpl<Articulo, ArticuloServiceImpl>{


    @GetMapping("/inicio")  //si quisiera que dos direcciones me llevaran a la misma pagina pondria {"/dir1","/dir2"}
    public String inicio(Model model) throws Exception { //EL NOMBRE DEL METODO ES SOLO REPRESENTATIVO, NO SE UTILIZA
        try {
            String usuario = "Master";
            model.addAttribute("nombreVariable", usuario);

            PageRequest pageRequest = PageRequest.of(0, 8);
            Page<Articulo> pageArticulo = servicio.findAll(pageRequest);
            model.addAttribute("articulo", pageArticulo);

            return "views/inicio"; //ACA TIENE QUE IR EL NOMBRE DE LA PLANTILLA DONDE SE QUIERE USAR
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }
    }
}