package com.empresariales.ufly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresariales.ufly.estructure.EstadosAvion;

public interface EstadosAvionRepository extends JpaRepository<EstadosAvion, Short> {

}