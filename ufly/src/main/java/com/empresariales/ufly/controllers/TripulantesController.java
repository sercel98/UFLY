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

import com.empresariales.ufly.estructure.Tripulantes;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.TripulantesRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/tripulantes")
@Api(description = "Operaciones de tripulantes")
public class TripulantesController 
{
	@Autowired
	private TripulantesRepository tripulantesRepository;

	@GetMapping
	public List<Tripulantes> listarTripulantes()
	{
		return tripulantesRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public Tripulantes crearTripulantes(@Valid @RequestBody Tripulantes tripulante)
	{
		return tripulantesRepository.save(tripulante);
	}
	
	@GetMapping("/{id_tripulante}")
	public Tripulantes darTripulantePorId(@PathVariable(value = "id_tripulante") Integer id_tripulante)
	{
		return tripulantesRepository.findById(id_tripulante)
				.orElseThrow(() -> new ResourceNotFoundException("Tripulantes", "id_tripulante", id_tripulante));
	}

	@PutMapping("/{id_tripulante}")
	public Tripulantes modificarTripulante(@PathVariable(value = "id_tripulante") Integer id_tripulante, @Valid @RequestBody Tripulantes tripulanteDetalle)
	{
		Tripulantes tripulante = tripulantesRepository.findById(id_tripulante)
				.orElseThrow(() -> new ResourceNotFoundException("Tripulantes", "id_tripulante", id_tripulante));
		
		tripulante.setPrimer_nombre(tripulanteDetalle.getPrimer_nombre());
		tripulante.setSegundo_nombre(tripulanteDetalle.getSegundo_nombre());
		tripulante.setPrimer_apellido(tripulanteDetalle.getPrimer_apellido());
		tripulante.setSegundo_apellido(tripulanteDetalle.getSegundo_apellido());
		tripulante.setGenero(tripulanteDetalle.getGenero());
		tripulante.setDireccion(tripulanteDetalle.getDireccion());
		tripulante.setTelefono(tripulanteDetalle.getTelefono());
		tripulante.setFecha_nacimiento(tripulanteDetalle.getFecha_nacimiento());

		Tripulantes nuevo = tripulantesRepository.save(tripulante);
		
		return nuevo;
		
	}
	
	
	
	
}