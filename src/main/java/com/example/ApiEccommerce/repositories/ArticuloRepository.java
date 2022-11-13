package com.example.ApiEccommerce.repositories;

import com.example.ApiEccommerce.entities.Articulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticuloRepository extends BaseRepository<Articulo, Long>{

    @Query(
            value = "SELECT * FROM articulo WHERE articulo.nombre LIKE %:q%",
            nativeQuery = true)
    List<Articulo> findByTitle(@Param("q")String q);
}
