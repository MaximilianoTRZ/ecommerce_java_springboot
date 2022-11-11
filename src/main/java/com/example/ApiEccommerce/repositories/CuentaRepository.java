package com.example.ApiEccommerce.repositories;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.ApiEccommerce.entities.Cuenta;




public interface CuentaRepository extends BaseRepository<Cuenta, Long>,JpaRepositoryImplementation<Cuenta,Long>{
	public Cuenta findByEmail(String email);
	
}
