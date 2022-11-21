package com.example.ApiEccommerce.services;

import com.example.ApiEccommerce.entities.DetalleCarrito;
import com.example.ApiEccommerce.repositories.BaseRepository;
import com.example.ApiEccommerce.repositories.DetalleCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleCarritoServiceImpl extends BaseServiceImpl<DetalleCarrito, Long> implements DetalleCarritoService {

    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;

    public DetalleCarritoServiceImpl(BaseRepository<DetalleCarrito, Long> baseRepository) {
        super(baseRepository);
    }

}
