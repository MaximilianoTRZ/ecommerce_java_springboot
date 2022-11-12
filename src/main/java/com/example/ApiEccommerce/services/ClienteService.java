package com.example.ApiEccommerce.services;

import com.example.ApiEccommerce.DTOs.RegistroDTO;
import com.example.ApiEccommerce.entities.Cliente;

public interface ClienteService extends BaseService <Cliente, Long>{

    public RegistroDTO save(RegistroDTO entity) throws Exception;

}
