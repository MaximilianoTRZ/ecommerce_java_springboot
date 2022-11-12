package com.example.ApiEccommerce.services;


import com.example.ApiEccommerce.entities.Cuenta;
import com.example.ApiEccommerce.entities.Rol;
import com.example.ApiEccommerce.repositories.BaseRepository;
import com.example.ApiEccommerce.repositories.CuentaRepository;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class CuentaServiceImpl extends BaseServiceImpl<Cuenta, Long> implements CuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository,BaseRepository<Cuenta, Long> baseRepository) {
        super(cuentaRepository);
        this.cuentaRepository = cuentaRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cuenta cuenta = cuentaRepository.findByEmail(email);
        if(cuenta == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        System.out.println(new User(cuenta.getEmail(),cuenta.getPassword(), mapearAutoridadesRoles(cuenta.getRoles())));
        return new User(cuenta.getEmail(),cuenta.getPassword(), mapearAutoridadesRoles(cuenta.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }


}