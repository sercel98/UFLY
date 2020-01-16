package com.empresariales.ufly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresariales.ufly.estructure.TiposUsuario;
@Repository
public interface TiposUsuariosRepository extends JpaRepository<TiposUsuario, Short>{

}
