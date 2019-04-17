package com.empresariales.ufly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresariales.ufly.estructure.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>
{

}
