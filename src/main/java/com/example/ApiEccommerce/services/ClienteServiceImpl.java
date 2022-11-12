package com.example.ApiEccommerce.services;

import com.example.ApiEccommerce.DTOs.RegistroDTO;
import com.example.ApiEccommerce.entities.Cliente;
import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.entities.Domicilio;
import com.example.ApiEccommerce.repositories.BaseRepository;
import com.example.ApiEccommerce.repositories.ClienteRepository;
import com.example.ApiEccommerce.repositories.CuentaRepository;
import com.example.ApiEccommerce.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;
    @Autowired
    private CuentaRepository cuentaRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    //Utilizamos un DTO para realizar el signup de usuario, por eso es que necesitamos los repositorios de 3 entidades distintas
    @Override
    @Transactional
    public RegistroDTO save(RegistroDTO entity) throws Exception {
        try {
            Cuenta cuenta = new Cuenta(entity.getUsuario(), entity.getContrasenia(), entity.getEmail());
            cuentaRepository.save(cuenta);
            Domicilio domicilio = new Domicilio(entity.getDireccion(), entity.getNroDireccion());
            domicilioRepository.save(domicilio);
            Cliente cliente = new Cliente(entity.getNombre(), entity.getApellido(), domicilio, cuenta);
            clienteRepository.save(cliente);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
