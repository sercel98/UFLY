package com.empresariales.ufly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresariales.ufly.estructure.EstadosAeropuerto;

@Repository
public interface EstadosAeropuertoRepository extends JpaRepository<EstadosAeropuerto, Short>
{

}
