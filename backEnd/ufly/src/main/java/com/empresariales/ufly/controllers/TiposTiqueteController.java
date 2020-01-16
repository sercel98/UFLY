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

import com.empresariales.ufly.estructure.TiposTiquete;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.TiposTiqueteRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/tipostiquete")
@Api(description = "Operaciones de tipos de tiquete")
public class TiposTiqueteController 
{
	@Autowired
	private TiposTiqueteRepository tiposRepository;

	@GetMapping
	public List<TiposTiquete> listarTiquetes()
	{
		return tiposRepository.findAll();
	}

	@PostMapping("/agregar")
	public TiposTiquete crearTipoTiquete(@Valid @RequestBody TiposTiquete tipoTiquete)
	{
		return tiposRepository.save(tipoTiquete);	
	}
	
	@GetMapping("/{id_tipo}")
	public TiposTiquete buscarTipoTiquetePorId(@PathVariable (value = "id_tipo")  Short id_tipo) {
		return tiposRepository.findById(id_tipo)
	            .orElseThrow(() -> new ResourceNotFoundException("TiposTiquete", "id_tipo", id_tipo));
	}

}
