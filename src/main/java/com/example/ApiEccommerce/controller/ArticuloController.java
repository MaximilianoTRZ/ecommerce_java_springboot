package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.services.ArticuloServiceImpl;
import com.example.ApiEccommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")  //en @Controller esto no es necesario?
@RequestMapping(path = "api/v1/articulos")  //en @Controller esto no es necesario?
public class ArticuloController extends BaseControllerImpl<Articulo, ArticuloServiceImpl> {

    @Autowired
    CategoriaService categoriaService;
    @GetMapping("/busqueda")
    public String busqueda(Model model, @RequestParam(value="query", required = false) String q) {
        try {
            List <Articulo> articulos = servicio.findByTitle(q);
            model.addAttribute("listaArticulos", articulos);
            return "views/busqueda";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }

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

    @GetMapping("/eliminar")
    public String eliminar(Model model) {
        try {
            return "views/eliminar";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }

    //Con este metodo lo que hacemos es guardar el objeto en la base de datos
    @PostMapping("/guardarArticulo")
    public String guardarArticulo(@ModelAttribute("nuevoArticulo") Articulo articulo) throws Exception {
        servicio.save(articulo);
        return "redirect:/api/v1/articulos/crud";
    }


    //En este metodo lo que hago es crear el objeto, el cual va a ser cargado con los datos que se completan en el formulario
    //Envio las categorias porque el articulo tiene asociada una categoria
    @GetMapping("/nuevo")
    public String crearNuevoProducto(Model model) {
        try {
            Articulo nuevoArticulo= new Articulo();
            model.addAttribute("nuevoArticulo", nuevoArticulo);
            model.addAttribute("categorias", categoriaService.findAll());

            return "views/formulario";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", e.getMessage());
            return "error";
        }

    }


    @GetMapping("/editar")
    public String editarProducto(Model model) {
        try {
            return "views/formulario_editar";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", e.getMessage());
            return "error";
        }

    }

    @GetMapping("/crud")
    public String crud(Model model) throws Exception { //EL NOMBRE DEL METODO ES SOLO REPRESENTATIVO, NO SE UTILIZA
        try {
            List<Articulo> nombreVariable = servicio.findAll();
            model.addAttribute("nombreVariable", nombreVariable);
            return "views/crud"; //ACA TIENE QUE IR EL NOMBRE DE LA PLANTILLA DONDE SE QUIERE USAR
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

    @GetMapping("/inicio")  //si quisiera que dos direcciones me llevaran a la misma pagina pondria {"/dir1","/dir2"}
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
