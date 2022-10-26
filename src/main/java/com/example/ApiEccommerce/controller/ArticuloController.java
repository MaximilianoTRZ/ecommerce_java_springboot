package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.services.ArticuloServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")  //en @Controller esto no es necesario?
@RequestMapping(path = "api/v1/articulos")  //en @Controller esto no es necesario?
public class ArticuloController extends BaseControllerImpl<Articulo, ArticuloServiceImpl>{

    @GetMapping("/lista")
    public String ListaArticulos(Model model) throws Exception { //EL NOMBRE DEL METODO ES SOLO REPRESENTATIVO, NO SE UTILIZA
        try {
            List<Articulo> nombreVariable=servicio.findAll();
            model.addAttribute("nombreVariable", nombreVariable);
            return "views/productos"; //ACA TIENE QUE IR EL NOMBRE DE LA PLANTILLA DONDE SE QUIERE USAR
        }catch (Exception e){
            model.addAttribute("error",e);
            return "error";
        }
    }

    @GetMapping("/inicio")
    public String inicio(Model model) throws Exception { //EL NOMBRE DEL METODO ES SOLO REPRESENTATIVO, NO SE UTILIZA
        try {
            String usuario= "Ivan";
            model.addAttribute("nombreVariable", usuario);
            return "views/inicio"; //ACA TIENE QUE IR EL NOMBRE DE LA PLANTILLA DONDE SE QUIERE USAR
        }catch (Exception e){
            return "views/error";
        }
    }
}
