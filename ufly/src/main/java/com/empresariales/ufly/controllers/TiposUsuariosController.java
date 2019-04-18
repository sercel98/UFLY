package com.empresariales.ufly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.TiposUsuario;
import com.empresariales.ufly.estructure.Usuarios;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.TiposUsuariosRepository;

@RestController
@RequestMapping("/typeusers")
public class TiposUsuariosController 
{
	@Autowired
	private TiposUsuariosRepository tiposRepository;

	@GetMapping("/list")
	public List<TiposUsuario> getAllTypesUsers()
	{
		System.out.println(tiposRepository.findAll());

		return tiposRepository.findAll();
	}

	@PostMapping("/add")
	public TiposUsuario createTypeUser(@Valid @RequestBody TiposUsuario tipoUsuario)
	{
		System.out.println(tipoUsuario);
		return tiposRepository.save(tipoUsuario);	
	}
	
	@GetMapping("/tipousuario/{id_tipo_usuario}")
	public TiposUsuario getTypeUserById(@PathVariable( value = "id_tipo_usuario")Short id_tipo_usuario)
	{
		return tiposRepository.findById(id_tipo_usuario)
	            .orElseThrow(() -> new ResourceNotFoundException("TiposUsuarios", "id_tipo_usuario", id_tipo_usuario));
	}
	
	@PutMapping("/tipousuario/{id_tipo_usuario}")
	public TiposUsuario updateTypeUser(@PathVariable(value = "id_tipo_usuario") Short id_tipo_usuario, @Valid @RequestBody TiposUsuario tipoUsuarioDetalles)
	{
		TiposUsuario typeUser = tiposRepository.findById(id_tipo_usuario)
	            .orElseThrow(() -> new ResourceNotFoundException("TiposUsuarios", "id_tipo_usuario", id_tipo_usuario));
	
		typeUser.setTipo_usuario(tipoUsuarioDetalles.getTipo_usuario());
		
		TiposUsuario tipo = tiposRepository.save(typeUser);
		
		return tipo;
	}
	
	
	
	
	
	
	
	
	
	
	

}
