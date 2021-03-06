package com.empresariales.ufly.controllers;

import java.util.ArrayList;
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
	
	@GetMapping("/{fkaeropuertos}")
	public List<Salas> listarSalas(@PathVariable (value = "fkaeropuertos") Short fkaeropuertos)
	{
		List<Salas> salas = salasRepository.findAll();
		List<Salas> salasActuales = new ArrayList<>();
		
		for (Salas salaActual : salas) {
			if(salaActual.getFkaeropuertos().getId_aeropuerto() == fkaeropuertos)
			{
				salasActuales.add(salaActual);
			}
		}
		
		return salasActuales;
	}
	
	private boolean existeSalaPorNombre(Salas sala)
	{
		List<Salas> salas = listarSalas(sala.getFkaeropuertos().getId_aeropuerto());
		for (Salas salaActual : salas)
		{
			if(salaActual.getNombre_sala().equals(sala.getNombre_sala()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	@PostMapping("/agregar")
	public Salas crearSalas(@Valid @RequestBody Salas sala) throws Exception
	{
		if(existeSalaPorNombre(sala))
		{
			throw new Exception("Ya existe un sala con este nombre en el aeropuerto");
		}
		else
		{
			return salasRepository.save(sala);
		}
		
	}
	
	@PutMapping("/{id_sala}")
	public Salas modificarSala(@PathVariable (value = "id_sala") Short id_sala, @Valid @RequestBody Salas salaDetalle ) throws Exception
	{
		Salas sala = salasRepository.findById(id_sala)
	            .orElseThrow(() -> new ResourceNotFoundException("Salas", "id_sala", id_sala));
		
		sala.setFkestado_sala(salaDetalle.getFkestado_sala());
		
		Salas nuevo = salasRepository.save(sala);
		
		return nuevo;
		
	}
}
