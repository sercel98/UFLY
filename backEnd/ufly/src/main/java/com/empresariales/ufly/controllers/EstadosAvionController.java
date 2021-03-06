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
import com.empresariales.ufly.estructure.EstadosAvion;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.EstadosAvionRepository;
import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/estadosavion")
@Api(description = "Operaciones de los estados del avion")
public class EstadosAvionController 
{
	@Autowired
	private EstadosAvionRepository estadosRepository;

	@GetMapping
	public List<EstadosAvion> listarEstadosAvion() {
		return estadosRepository.findAll();
	}

	@PostMapping("/agregar")
	public EstadosAvion crearEstado(@Valid @RequestBody EstadosAvion estado) {
		return estadosRepository.save(estado);
	}

	@GetMapping("/{id_estado_avion}")
	public EstadosAvion buscarEstadoPorId(@PathVariable(value = "id_estado_avion") Short id_estado_avion) {
		return estadosRepository.findById(id_estado_avion)
				.orElseThrow(() -> new ResourceNotFoundException("EstadosAvion", "id_estado_avion", id_estado_avion));
	}
}