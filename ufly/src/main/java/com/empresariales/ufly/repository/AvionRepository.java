package com.empresariales.ufly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresariales.ufly.estructure.Avion;

public interface AvionRepository extends JpaRepository<Avion, Integer> {

}