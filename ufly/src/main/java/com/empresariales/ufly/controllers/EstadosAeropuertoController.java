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

import com.empresariales.ufly.estructure.EstadosAeropuerto;
import com.empresariales.ufly.repository.EstadosAeropuertoRepository;

@CrossOrigin
@RestController
@RequestMapping("/estadoaeropuerto")
public class EstadosAeropuertoController 
{
	@Autowired
	private EstadosAeropuertoRepository estadosAeroRepository;
	
	@GetMapping("/listar")
	public List<EstadosAeropuerto> listarEstadosAeropuerto()
	{
		return estadosAeroRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public EstadosAeropuerto crearEstadoAeropuerto(@Valid @RequestBody EstadosAeropuerto estadoAeropuerto)
	{
		return estadosAeroRepository.save(estadoAeropuerto);
	}

}
