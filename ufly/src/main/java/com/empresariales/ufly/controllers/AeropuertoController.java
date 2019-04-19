package com.empresariales.ufly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.Aeropuerto;
import com.empresariales.ufly.repository.AeropuertoRepository;

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
	public Aeropuerto crearAeropuerto(@Valid @RequestBody Aeropuerto aeropuerto)
	{
		System.out.println(aeropuerto);
		return aeropuertoRepository.save(aeropuerto);
	}

}
