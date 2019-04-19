package com.empresariales.ufly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.Pais;
import com.empresariales.ufly.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController
{
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("/listar")
	public List<Pais> getAllPaises()
	{
		System.out.println(paisRepository.findAll());
		return paisRepository.findAll();
	}

	@PostMapping("/agregar")
	public Pais createPais(@Valid @RequestBody Pais pais)
	{
		System.out.println(pais);
		return paisRepository.save(pais);	
	}
}
