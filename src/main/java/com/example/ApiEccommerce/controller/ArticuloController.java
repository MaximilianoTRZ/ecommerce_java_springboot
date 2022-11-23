package com.example.ApiEccommerce.controller;

import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.entities.DetalleCarrito;
import com.example.ApiEccommerce.entities.DetalleFactura;
import com.example.ApiEccommerce.services.ArticuloServiceImpl;
import com.example.ApiEccommerce.services.CategoriaService;
import com.example.ApiEccommerce.services.DetalleCarritoService;
import com.example.ApiEccommerce.services.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(path = "api/v1/articulos")  //en @Controller esto no es necesario?
public class ArticuloController extends BaseControllerImpl<Articulo, ArticuloServiceImpl> {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    DetalleCarritoService detalleCarritoService;

    @Autowired
    DetalleFacturaService detalleFacturaService;

    /*Pagina de barra de busqueda sin paginar*/
    @GetMapping("/busqueda")
    public String busqueda(Model model, @RequestParam(value = "query", required = false) String q) {
        try {
            List<Articulo> articulos = servicio.findByTitle(q);
            model.addAttribute("listaArticulos", articulos);


            return "views/busqueda";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }
    }

    /*Pagina Producto paginada*/
    @GetMapping("/lista")
    public String ListaArticulosPaginados(@RequestParam Map<String, Object> params, Model model) throws Exception {
        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
        PageRequest pageRequest = PageRequest.of(page, 8);
        Page<Articulo> pageArticulo = servicio.findAll(pageRequest);

        int totalPage = pageArticulo.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
        model.addAttribute("nombreVariable", pageArticulo.getContent());
        model.addAttribute("current", page + 1);
        model.addAttribute("next", page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        return "views/productosPaginado";
    }

    //comienzo funcion eliminar
    @GetMapping("/confirmarEliminar/{id}")
    public String eliminarProducto(@PathVariable long id, Model model) {
        try {
            model.addAttribute("articulo", servicio.findById(id));
            return "views/eliminar";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id) {
        try {
            servicio.delete(id);
            return "redirect:/api/v1/articulos/crud";
        } catch (Exception e) {
            return "error";
        }
    }
    //fin funcion eliminar

    //inicio funcion guardar un nuevo producto
    @GetMapping("/nuevo")
    public String crearNuevoProducto(Model model) {
        try {
            Articulo nuevoArticulo = new Articulo();
            model.addAttribute("nuevoArticulo", nuevoArticulo);
            model.addAttribute("categorias", categoriaService.findAll());

            return "views/formulario_nuevo";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/guardarArticulo")
    public String guardarArticulo(@ModelAttribute("nuevoArticulo") Articulo articulo) throws Exception {
        servicio.save(articulo);
        return "redirect:/api/v1/articulos/crud";
    }
    //fin funcion cargar nuevo producto

    //Comienzo funcion editar
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable long id, Model model) throws Exception {
        try {
            model.addAttribute("articulo", servicio.findById(id));
            model.addAttribute("categorias", categoriaService.findAll());
            return "views/formulario_editar";
        } catch (Exception e) {
            model.addAttribute("mensajeError", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/actualizarArticulo/{id}")
    public String ActualizarArticulo(@PathVariable long id, @ModelAttribute("articulo") Articulo articulo, Model modelo) throws Exception {
        Articulo articuloExistente = servicio.findById(id);
        articuloExistente.setNombre(articulo.getNombre());
        articuloExistente.setFoto(articulo.getFoto());
        articuloExistente.setPrecio(articulo.getPrecio());
        articuloExistente.setCategoria(articulo.getCategoria());
        articuloExistente.setDescripcion(articulo.getDescripcion());

        servicio.update(id, articuloExistente);
        return "redirect:/api/v1/articulos/crud";
    }
    //fin funcion editar

    /*Pagina Crud paginada*/
    @GetMapping("/crud")
    public String crudPaginados(@RequestParam Map<String, Object> params, Model model) throws Exception {
        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
        PageRequest pageRequest = PageRequest.of(page, 8);
        Page<Articulo> pageArticulo = servicio.findAll(pageRequest);

        int totalPage = pageArticulo.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
        model.addAttribute("nombreVariable", pageArticulo.getContent());
        model.addAttribute("current", page + 1);
        model.addAttribute("next", page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        return "views/crudPaginado";
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

    @GetMapping("/agregarProducto/{id}")
    public String agregarAlCarrito(Model model, @PathVariable("id") long id) {
        try {
            Articulo articulo = servicio.findById(id);
            DetalleCarrito detalleCarrito = new DetalleCarrito(1, articulo);
            detalleCarritoService.save(detalleCarrito);
            model.addAttribute("detalleArticulo", articulo);
            return "redirect:/api/v1/articulos/detalle/{id}";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }
}


//boolean a = true;
//if (a)
//throw new Exception("aaaaaa");