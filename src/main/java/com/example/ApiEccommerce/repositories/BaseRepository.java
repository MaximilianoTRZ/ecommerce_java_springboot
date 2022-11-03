package com.example.ApiEccommerce.repositories;

import java.io.Serializable;

import com.example.ApiEccommerce.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID>{


}