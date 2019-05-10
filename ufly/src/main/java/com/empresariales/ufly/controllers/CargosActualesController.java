package com.empresariales.ufly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.CargosActuales;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.CargosActualesRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/cargosactuales")
@Api(description = "Operaciones de cargos actuales de tripulantes")
public class CargosActualesController 
{
	@Autowired
	private CargosActualesRepository cargosARepository;

	@GetMapping
	public List<CargosActuales> listarCargosActuales()
	{
		return cargosARepository.findAll();
	}

	@PostMapping("/agregar")
	public CargosActuales crearCargosActuales(@Valid @RequestBody CargosActuales cargoActual)
	{
		return cargosARepository.save(cargoActual);
	}
	@GetMapping("/{id_cargosactuales}")
	public CargosActuales darCargosActualesPorId(@PathVariable (value = "id_cargos_actuales")  Short id_estado)
	{
		return cargosARepository.findById(id_estado)
	            .orElseThrow(() -> new ResourceNotFoundException("CargosActuales", "id_cargos_actuales", id_estado));
	}
	
}