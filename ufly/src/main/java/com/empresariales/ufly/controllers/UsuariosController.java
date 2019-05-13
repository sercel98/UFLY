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

import com.empresariales.ufly.estructure.Aeropuerto;
import com.empresariales.ufly.estructure.Usuarios;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.UsuariosRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/usuarios")
@Api(description = "Operaciones de usuarios")
public class UsuariosController 
{
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	
	@GetMapping
	public List<Usuarios> listarUsuarios()
	{
		return usuariosRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public Usuarios crearUsuarios(@Valid @RequestBody Usuarios usuario) throws Exception
	{
		if(existeUsuarioPorCedula(usuario))
		{
			throw new Exception("La cédula de este usuario ya existe");
		}
		else
		{
			return usuariosRepository.save(usuario);
		}
		
	}
	
	private boolean existeUsuarioPorCedula(Usuarios usuario)
	{
		List<Usuarios> usuarios = listarUsuarios();
		for (Usuarios usuarioActual : usuarios)
		{
			if(usuario.getCedula().compareTo(usuarioActual.getCedula()) == 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	@GetMapping("/{id_usuario}")
	public Usuarios darUsuarioPorId(@PathVariable(value = "id_usuario") Integer id_usuario)
	{
		return usuariosRepository.findById(id_usuario)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id_usuarios", id_usuario));
	}
	
	@PutMapping("/{id_usuario}")
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
		user.setGenero(usuarioDetalles.getGenero());
		user.setDireccion(usuarioDetalles.getDireccion());
		user.setFecha_nacimiento(usuarioDetalles.getFecha_nacimiento());

		Usuarios actualizado = usuariosRepository.save(user);
		
		return actualizado;
	
}
