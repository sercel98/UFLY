package com.empresariales.ufly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.Salas;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.SalasRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/salas")
@Api(description = "Operaciones de salas")
public class SalasController 
{
	@Autowired
	private SalasRepository salasRepository;
	
	@GetMapping
	public List<Salas> listarSalas()
	{
		return salasRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public Salas crearSalas(@Valid @RequestBody Salas sala)
	{
		return salasRepository.save(sala);
	}
	
	@GetMapping("/{id_sala}")
	public Salas darSalaPorId(@PathVariable (value = "id_sala") Short id_sala)
	{
		return salasRepository.findById(id_sala)
	            .orElseThrow(() -> new ResourceNotFoundException("Salas", "id_sala", id_sala));
	}
	
	@PutMapping("/{id_sala}")
	public Salas modificarSala(@PathVariable (value = "id_sala") Short id_sala, @Valid @RequestBody Salas salaDetalle )
	{
		Salas sala = salasRepository.findById(id_sala)
	            .orElseThrow(() -> new ResourceNotFoundException("Salas", "id_sala", id_sala));
		
		sala.setNombre_sala(salaDetalle.getNombre_sala());
		sala.setFkaeropuertos(salaDetalle.getFkaeropuertos());
		sala.setFkestado_sala(salaDetalle.getFkestado_sala());
		
		Salas nuevo = salasRepository.save(sala);
		
		return nuevo;
	}
	
	
	
	
	
	
	

}
