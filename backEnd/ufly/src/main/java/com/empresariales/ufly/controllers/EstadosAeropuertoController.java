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

import com.empresariales.ufly.estructure.EstadosAeropuerto;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.EstadosAeropuertoRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/estadosaeropuerto")
@Api(description = "Operaciones de los estados de aeropuerto")
public class EstadosAeropuertoController 
{
	@Autowired
	private EstadosAeropuertoRepository estadosAeroRepository;
	
	@GetMapping
	public List<EstadosAeropuerto> listarEstadosAeropuerto()
	{
		return estadosAeroRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public EstadosAeropuerto crearEstadoAeropuerto(@Valid @RequestBody EstadosAeropuerto estadoAeropuerto)
	{
		return estadosAeroRepository.save(estadoAeropuerto);
	}
	
	@GetMapping("/{id_estado}")
	public EstadosAeropuerto buscarEstadoPorId(@PathVariable (value = "id_estado")  Short id_estado) {
		return estadosAeroRepository.findById(id_estado)
	            .orElseThrow(() -> new ResourceNotFoundException("EstadosAeropuerto", "id_estados_aeropuerto", id_estado));
	}

}
