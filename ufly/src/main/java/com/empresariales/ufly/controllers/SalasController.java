package com.empresariales.ufly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.Salas;
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
	

}
