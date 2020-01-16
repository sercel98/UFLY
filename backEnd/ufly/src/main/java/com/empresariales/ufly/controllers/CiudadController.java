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

import com.empresariales.ufly.estructure.Ciudad;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.CiudadRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/ciudades")
@Api(description = "Operaciones de Ciudades")
public class CiudadController
{
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@GetMapping
	public List<Ciudad> listarCiudades()
	{
		System.out.println(ciudadRepository.findAll());
		return ciudadRepository.findAll();
	}

	@PostMapping("/agregar")
	public Ciudad crearCiudad(@Valid @RequestBody Ciudad ciudad)
	{
		System.out.println(ciudad);
		return ciudadRepository.save(ciudad);	
	}
	
	@GetMapping("/{id_ciudad}")
	public Ciudad buscarCiudadPorId(@PathVariable (value = "id_ciudad")  Short id_ciudad) {
		return ciudadRepository.findById(id_ciudad)
	            .orElseThrow(() -> new ResourceNotFoundException("Ciudad", "id_ciudad", id_ciudad));
	}
	
}
