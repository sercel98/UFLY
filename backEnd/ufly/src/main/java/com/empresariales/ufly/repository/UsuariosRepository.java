package com.empresariales.ufly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresariales.ufly.estructure.Usuarios;
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>
{

}
