package com.example.ApiEccommerce.services;

import com.example.ApiEccommerce.entities.Carrito;
import com.example.ApiEccommerce.repositories.CarritoRepository;
import com.example.ApiEccommerce.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl extends BaseServiceImpl<Carrito, Long> implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public CarritoServiceImpl(BaseRepository<Carrito, Long> baseRepository) {
        super(baseRepository);
    }
}
