package com.example.ApiEccommerce.services;

import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.repositories.BaseRepository;
import com.example.ApiEccommerce.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CuentaServiceImpl extends BaseServiceImpl<Cuenta, Long> implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public CuentaServiceImpl(BaseRepository<Cuenta, Long> baseRepository) {
        super(baseRepository);
    }

}
