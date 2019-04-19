package com.empresariales.ufly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.EstadosAeropuerto;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.EstadosAeropuertoRepository;

@RestController
@RequestMapping("/airportstatus")
public class EstadosAeropuertoController 
{
	@Autowired
	private EstadosAeropuertoRepository estadosAeroRepository;
	
	@GetMapping("/list")
	public List<EstadosAeropuerto> getAllAirportStatus()
	{
		return estadosAeroRepository.findAll();
	}
	
	@PostMapping("/add")
	public EstadosAeropuerto createAirportStatus(@Valid @RequestBody EstadosAeropuerto estadoAeropuerto)
	{
		return estadosAeroRepository.save(estadoAeropuerto);
	}
	
	@GetMapping("/estadoaero/{id_estado_aeropuerto}")
	public EstadosAeropuerto getAirportStatusById(@PathVariable(value = "id_estado_aeropuerto")Short id_estado_aeropuerto)
	{
		return estadosAeroRepository.findById(id_estado_aeropuerto)
	            .orElseThrow(() -> new ResourceNotFoundException("EstadosAeropuerto", "id_estado_aeropuerto", id_estado_aeropuerto));
	}
	
	@PutMapping("/estadoaero/{id_estado_aeropuerto}")
	public EstadosAeropuerto updateAirportStatusById(@PathVariable(value = "id_estado_aeropuerto")Short id_estado_aeropuerto, @Valid @RequestBody EstadosAeropuerto estadoAeroDetalle)
	{
		EstadosAeropuerto nuevo = estadosAeroRepository.findById(id_estado_aeropuerto)
        .orElseThrow(() -> new ResourceNotFoundException("EstadosAeropuerto", "id_estado_aeropuerto", id_estado_aeropuerto));

		nuevo.setNombre_estado(estadoAeroDetalle.getNombre_estado());
		
		EstadosAeropuerto estado = estadosAeroRepository.save(nuevo);
		return estado;
		
	}
	
	
	
	
	

}
