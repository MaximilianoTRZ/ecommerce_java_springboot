package com.example.ApiEccommerce.services;

import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.repositories.BaseRepository;
import com.example.ApiEccommerce.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

import javax.transaction.Transactional;
@Service
public class CuentaServiceImpl extends BaseServiceImpl<Cuenta, Long> implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public CuentaServiceImpl(BaseRepository<Cuenta, Long> baseRepository) {
        super(baseRepository);
    }
    
    @Transactional
    public Cuenta verifyByUserPass(String user, String password) throws Exception{
        try {
            Cuenta cuenta= cuentaRepository.verifyByUserPass(user, password);
            return cuenta;
        }catch (Exception e){
            return null;
        }
}
}
