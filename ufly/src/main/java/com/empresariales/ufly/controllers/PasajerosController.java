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

import com.empresariales.ufly.estructure.Pasajeros;
import com.empresariales.ufly.estructure.Salas;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.PasajerosRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/pasajeros")
@Api(description = "Operaciones de pasajeros")
public class PasajerosController 
{
	@Autowired
	private PasajerosRepository pasajeroRepository;
	
	@GetMapping
	public List<Pasajeros> listarPasajeros()
	{
		return pasajeroRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public Pasajeros crearPasajero(@Valid @RequestBody Pasajeros pasajero) throws Exception
	{
		if(existePasajeroPorCedula(pasajero))
		{
			throw new Exception("Ya existe un pasajero con esta cédula");
		}
		else
		{
			return pasajeroRepository.save(pasajero);
		}
		
	}
	
	private boolean existePasajeroPorCedula(Pasajeros pasajero)
	{
		List<Pasajeros> pasajeros = listarPasajeros();
		for (Pasajeros pasajeroActual : pasajeros)
		{
			if(pasajeroActual.getCedula().compareTo(pasajero.getCedula()) == 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	@GetMapping("/{id_pasajero}")
	public Pasajeros buscarPasajeroPorId(@PathVariable (value = "id_pasajero") Integer id_pasajero)
	{
		return pasajeroRepository.findById(id_pasajero)
	            .orElseThrow(() -> new ResourceNotFoundException("Pasajeros", "id_pasajero", id_pasajero)); 
	}

}
