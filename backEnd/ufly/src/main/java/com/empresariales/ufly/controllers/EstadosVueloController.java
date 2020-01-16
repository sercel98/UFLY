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

import com.empresariales.ufly.estructure.EstadosVuelo;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.EstadosVueloRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/estadosvuelo")
@Api(description = "Operaciones de los estados del vuelo")
public class EstadosVueloController 
{
	@Autowired
	private EstadosVueloRepository estadosRepository;
	
	@GetMapping
	public List<EstadosVuelo> listarEstadosVuelo()
	{
		return estadosRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public EstadosVuelo crearEstadoVuelo(@Valid @RequestBody EstadosVuelo estado)
	{	
		return estadosRepository.save(estado);
	}
	
	@GetMapping("/{id_estado_vuelo}")
	public EstadosVuelo buscarEstadoPorId(@PathVariable (value = "id_estado_vuelo") Short id_estado_vuelo)
	{
		return estadosRepository.findById(id_estado_vuelo)
				.orElseThrow(() -> new ResourceNotFoundException("EstadosVuelo", "id_estado_vuelo", id_estado_vuelo));
	}

}
