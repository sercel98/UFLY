package com.empresariales.ufly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.Aeropuerto;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.AeropuertoRepository;

@CrossOrigin
@RestController
@RequestMapping("/aeropuerto")
public class AeropuertoController 
{
	@Autowired
	private AeropuertoRepository aeropuertoRepository;
	
	@GetMapping("/listar")
	public List<Aeropuerto> listarAeropuertos()
	{
		return aeropuertoRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public Aeropuerto crearAeropuerto(@RequestBody Aeropuerto aeropuerto)
	{
		System.out.println(aeropuerto);
		return aeropuertoRepository.save(aeropuerto);
	}
	
	
	@GetMapping("/{id_usuarios}")
	public Aeropuerto darAeropuertoPorId(@PathVariable(value = "id_aeropuerto") Short id_aeropuerto)
	{
		return aeropuertoRepository.findById(id_aeropuerto)
	            .orElseThrow(() -> new ResourceNotFoundException("Aeropuerto", "id_aeropuerto", id_aeropuerto));
	}
	
	

}
