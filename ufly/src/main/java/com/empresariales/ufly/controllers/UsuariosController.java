package com.empresariales.ufly.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresariales.ufly.estructure.Usuarios;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.UsuariosRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuariosController 
{
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	
	@GetMapping("/listar")
	public List<Usuarios> listarUsuarios()
	{
		return usuariosRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public Usuarios crearUsuarios(@Valid @RequestBody Usuarios usuario)
	{
		System.out.println(usuario);
		return usuariosRepository.save(usuario);
	}
	
	@GetMapping("/buscar/{id_usuarios}")
	public Usuarios darUsuarioPorId(@PathVariable(value = "id_usuario") Integer id_usuario)
	{
		return usuariosRepository.findById(id_usuario)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id_usuarios", id_usuario));
	}
	
	@PutMapping("/modificar/{id_usuarios}")
	public Usuarios modificarUsuario(@PathVariable(value = "id_usuario") Integer id_usuario, @Valid @RequestBody Usuarios usuarioDetalles)
	{
		Usuarios user = usuariosRepository.findById(id_usuario)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id_usuarios", id_usuario));
		
		user.setContrasenia(usuarioDetalles.getContrasenia());
		user.setPrimer_nombre(usuarioDetalles.getPrimer_nombre());
		user.setSegundo_nombre(usuarioDetalles.getSegundo_nombre());
		user.setPrimer_apellido(usuarioDetalles.getPrimer_apellido());
		user.setSegundo_apellido(usuarioDetalles.getSegundo_apellido());
		user.setTelefono(usuarioDetalles.getTelefono());

		Usuarios actualizado = usuariosRepository.save(user);
		
		return actualizado;
	}
	
}
