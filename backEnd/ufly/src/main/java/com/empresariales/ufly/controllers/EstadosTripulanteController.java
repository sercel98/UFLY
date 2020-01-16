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

import com.empresariales.ufly.estructure.EstadosTripulante;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.EstadosTripulanteRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/estadostripulantes")
@Api(description = "Operaciones de los estados del tripulante")
public class EstadosTripulanteController 
{
	@Autowired
	private EstadosTripulanteRepository estadosTRepository;

	@GetMapping
	public List<EstadosTripulante> listarEstadosTripulantes()
	{
		return estadosTRepository.findAll();
	}

	@PostMapping("/agregar")
	public EstadosTripulante crearEstadoTripulante(@Valid @RequestBody EstadosTripulante estadoTripulante)
	{
		return estadosTRepository.save(estadoTripulante);
	}
	
	@GetMapping("/{id_estado_tripulante}")
	public EstadosTripulante buscarEstadoPorId(@PathVariable (value = "id_estado_tripulante") Short id_estado_tripulante)
	{
		return estadosTRepository.findById(id_estado_tripulante)
				.orElseThrow(() -> new ResourceNotFoundException("EstadosTripulante", "id_estado_tripulante", id_estado_tripulante));
	}




}
