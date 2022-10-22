package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.services.ArticuloServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulos")
public class ArticuloController extends BaseControllerImpl<Articulo, ArticuloServiceImpl>{

}
