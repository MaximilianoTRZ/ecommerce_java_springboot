package com.example.ApiEccommerce.controller;


import com.example.ApiEccommerce.entities.Rol;
import com.example.ApiEccommerce.services.RolServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/roles")
public class RolController extends BaseControllerImpl<Rol, RolServiceImpl>{

}
