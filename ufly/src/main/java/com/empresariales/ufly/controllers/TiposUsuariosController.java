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
import com.empresariales.ufly.estructure.TiposUsuario;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.TiposUsuariosRepository;

@CrossOrigin
@RestController
@RequestMapping("/tipousuario")
public class TiposUsuariosController 
{
	@Autowired
	private TiposUsuariosRepository tiposRepository;

	@GetMapping("/listar")
	public List<TiposUsuario> listarUsuarios()
	{
		System.out.println(tiposRepository.findAll());
		return tiposRepository.findAll();
	}

	@PostMapping("/agregar")
	public TiposUsuario crearTipoUsuario(@Valid @RequestBody TiposUsuario tipoUsuario)
	{
		System.out.println(tipoUsuario);
		return tiposRepository.save(tipoUsuario);	
	}
	
	@GetMapping("/{id_tipo_usuario}")
	public TiposUsuario buscarTipoUsuarioPorId(@PathVariable (value = "id_tipo_usuario")  Short id_tipo_usuario) {
		return tiposRepository.findById(id_tipo_usuario)
	            .orElseThrow(() -> new ResourceNotFoundException("TiposUsuario", "id_tipo_usuario", id_tipo_usuario));
	}

}
