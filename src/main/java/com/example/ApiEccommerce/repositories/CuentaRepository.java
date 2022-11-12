package com.example.ApiEccommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ApiEccommerce.entities.Cuenta;



@Repository
public interface CuentaRepository extends BaseRepository<Cuenta, Long>,JpaRepository<Cuenta,Long>{
    public Cuenta findByEmail(String email);

}