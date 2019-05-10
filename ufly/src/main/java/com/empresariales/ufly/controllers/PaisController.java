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

import com.empresariales.ufly.estructure.Pais;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.PaisRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/paises")
@Api(description = "Operaciones de país")
public class PaisController
{
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping
	public List<Pais> listarPaises()
	{
		System.out.println(paisRepository.findAll());
		return paisRepository.findAll();
	}

	@PostMapping("/agregar")
	public Pais crearPais(@Valid @RequestBody Pais pais)
	{
		System.out.println(pais);
		return paisRepository.save(pais);	
	}
	
	@GetMapping("/{id_pais}")
	public Pais buscarPaisPorId(@PathVariable (value = "id_pais")  Short id_pais) {
		return paisRepository.findById(id_pais)
	            .orElseThrow(() -> new ResourceNotFoundException("Pais", "id_pais", id_pais));
	}
	
}
