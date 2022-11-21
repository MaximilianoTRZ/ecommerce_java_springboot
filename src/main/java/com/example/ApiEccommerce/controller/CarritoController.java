package com.example.ApiEccommerce.controller;

import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.entities.Cliente;
import com.example.ApiEccommerce.entities.DetalleFactura;
import com.example.ApiEccommerce.entities.Factura;
import com.example.ApiEccommerce.entities.DetalleCarrito;
import com.example.ApiEccommerce.entities.Carrito;
import com.example.ApiEccommerce.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "api/v1/carrito")
public class CarritoController extends BaseControllerImpl<Articulo, ArticuloServiceImpl> {

    @Autowired
    DetalleCarritoService detalleCarritoService;
    @Autowired
    DetalleFacturaService detalleFacturaService;
    @Autowired
    FacturaService facturaService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("/detalle")
    public String carritoArticulos(Model model) {
        try {

            List<DetalleCarrito> listDetalleCarrito = detalleCarritoService.findAll();
            model.addAttribute("detalleProducto", listDetalleCarrito);

            return "views/carrito";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }

    @GetMapping("/realizarCompra")
    public String realizarCompra(Model model) {
        try {

            // borramos el carrito y creamos una factura
            List<DetalleCarrito> listDetalleCarrito = detalleCarritoService.findAll();

            for (DetalleCarrito detalleCarrito: listDetalleCarrito) {

                Articulo articulo = detalleCarrito.getArticulo();
                int cantidad = detalleCarrito.getCantidad();

                //creamos el detalle factura para ese articulo y lo guardamos
                DetalleFactura newDetalleFact = new DetalleFactura(cantidad,articulo);
                detalleFacturaService.save(newDetalleFact);

                //borramos el articulo del carrito
                detalleCarritoService.delete(detalleCarrito.getId());

            }

            List<Factura> listFactura = facturaService.findAll();
            int nroFactura = listFactura.size() > 1 ? listFactura.size() + 1 : 1;

            Cliente cliente = clienteService.findById(1l);
            List<DetalleFactura> listDetalleFactura = detalleFacturaService.findAll();

            Factura factura = new Factura(nroFactura, listDetalleFactura, cliente);
            facturaService.save(factura);

            return "redirect:/api/v1/inicio";

        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }

    }

    //inicio funcion editar
    @GetMapping("/editar/{id}")
    public String editarCarrito(@PathVariable long id, Model model) {
        try {
            model.addAttribute("detalleProducto", detalleCarritoService.findById(id));
            return "views/formulario_editar_carrito";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", mensaje);
            return "error";
        }
    }
    @PostMapping("/actualizarDetalleProducto/{id}")
    public String ActualizarDetalleProducto(@PathVariable long id, @ModelAttribute("detalleProducto") DetalleCarrito detalleProducto, Model model) throws Exception {
        DetalleCarrito detalleCarritoExistente = detalleCarritoService.findById(id);
        detalleCarritoExistente.setCantidad(detalleProducto.getCantidad());

        detalleCarritoService.update(id, detalleCarritoExistente);
        return "redirect:/api/v1/carrito/detalle";
    }
    //fin funcion editar


    //inicio funcion eliminar
    @GetMapping("/confirmarEliminar/{id}")
    public String confirmarEliminar(@PathVariable long id, Model model) {
        try {
            model.addAttribute("detalleFactura", detalleCarritoService.findById(id));
            return "views/eliminarDelCarrito";
        } catch (Exception e) {
            String mensaje = "hubo un error";
            model.addAttribute("mensajeError", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id) {
        try {
            detalleCarritoService.delete(id);
            return "redirect:/api/v1/carrito/detalle";
        } catch (Exception e) {
            return "error";
        }
    }
    //fin funcion eliminar


}
