package com.example.ApiEccommerce.services;

import com.example.ApiEccommerce.entities.Articulo;
import com.example.ApiEccommerce.repositories.ArticuloRepository;
import com.example.ApiEccommerce.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ArticuloServiceImpl extends BaseServiceImpl<Articulo, Long> implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    public ArticuloServiceImpl(BaseRepository<Articulo, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Articulo> findByTitle(String q) throws Exception{
        try {
            List<Articulo> entities= articuloRepository.findByTitle(q);
            return entities;
        }catch (Exception e){
            return null;
        }
    }
}
