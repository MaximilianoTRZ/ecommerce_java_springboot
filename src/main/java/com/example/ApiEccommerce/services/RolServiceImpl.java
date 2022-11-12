package com.example.ApiEccommerce.services;

import com.example.ApiEccommerce.entities.Rol;
import com.example.ApiEccommerce.repositories.BaseRepository;
import com.example.ApiEccommerce.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl extends BaseServiceImpl<Rol, Long> implements RolService {

    @Autowired
    private RolRepository rolRepository;

    public RolServiceImpl(BaseRepository<Rol, Long> baseRepository) {
        super(baseRepository);
    }

}