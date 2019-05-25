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

import com.empresariales.ufly.estructure.EstadosTiquete;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.EstadosTiqueteRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/estadostiquete")
@Api(description = "Operaciones de los estados del tiquete")
public class EstadosTiqueteController 
{
	@Autowired
	private EstadosTiqueteRepository estadosRepository;
	
	@GetMapping
	public List<EstadosTiquete> listarEstadosTiquetes()
	{
		return estadosRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public EstadosTiquete crearEstadoTiquete(@Valid @RequestBody EstadosTiquete estado)
	{	
		return estadosRepository.save(estado);
	}
	
	@GetMapping("/{id_estado}")
	public EstadosTiquete buscarEstadoPorId(@PathVariable (value = "id_estado") Short id_estado)
	{
		return estadosRepository.findById(id_estado)
				.orElseThrow(() -> new ResourceNotFoundException("EstadosTiquete", "id_estado", id_estado));
	}
	
}
