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

import com.empresariales.ufly.estructure.EstadosSala;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.EstadosSalaRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/estadossala")
@Api(description = "Operaciones de los estados de la sala")
public class EstadosSalaController 
{
	@Autowired
	private EstadosSalaRepository estadosSRepository;
	
	@GetMapping
	public List<EstadosSala> listarEstadosSala()
	{
		return estadosSRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public EstadosSala crearEstadoSala(@Valid @RequestBody EstadosSala estado)
	{
		return estadosSRepository.save(estado);
	}
	
	@GetMapping("/{id_estado_sala}")
	public EstadosSala buscarSalaPorId(@PathVariable (value = "id_estado_sala") Short id_estado_sala)
	{
		return estadosSRepository.findById(id_estado_sala)
	            .orElseThrow(() -> new ResourceNotFoundException("EstadosSala", "id_estado_sala", id_estado_sala)); 
	}

}
