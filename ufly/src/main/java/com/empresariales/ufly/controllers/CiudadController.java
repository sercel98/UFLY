package com.empresariales.ufly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.Ciudad;
import com.empresariales.ufly.repository.CiudadRepository;

@CrossOrigin
@RestController
@RequestMapping("/ciudades")
public class CiudadController
{
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@GetMapping("/listar")
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
}
