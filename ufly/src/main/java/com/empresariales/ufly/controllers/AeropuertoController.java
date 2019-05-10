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
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.AeropuertoRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/aeropuertos")
@Api(description = "Operaciones de aeropuertos")
public class AeropuertoController 
{
	@Autowired
	private AeropuertoRepository aeropuertoRepository;
	
	@GetMapping
	public List<Aeropuerto> listarAeropuertos()
	{
		return aeropuertoRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public Aeropuerto crearAeropuerto(@RequestBody Aeropuerto aeropuerto)
	{
		System.out.println(aeropuerto);
		return aeropuertoRepository.save(aeropuerto);
	}
	
	
	@GetMapping("/{id_aeropuerto}")
	public Aeropuerto darAeropuertoPorId(@PathVariable(value = "id_aeropuerto") Short id_aeropuerto)
	{
		return aeropuertoRepository.findById(id_aeropuerto)
	            .orElseThrow(() -> new ResourceNotFoundException("Aeropuerto", "id_aeropuerto", id_aeropuerto));
	}
	
	@PutMapping("/{id_aeropuerto}")
	public Aeropuerto modificarAeropuerto(@PathVariable(value = "id_aeropuerto") Short id_aeropuerto, @Valid @RequestBody Aeropuerto aeropuertoDetalle)
	{
		Aeropuerto aero=  aeropuertoRepository.findById(id_aeropuerto)
	            .orElseThrow(() -> new ResourceNotFoundException("Aeropuerto", "id_aeropuerto", id_aeropuerto));

		aero.setNombre_aeropuerto(aeropuertoDetalle.getNombre_aeropuerto());
		aero.setDireccion_aeropuerto(aeropuertoDetalle.getDireccion_aeropuerto());
		aero.setTelefono(aeropuertoDetalle.getTelefono());
		aero.setFkestados_aeropuerto(aeropuertoDetalle.getFkestados_aeropuerto());
		aero.setFkciudades(aeropuertoDetalle.getFkciudades());
		
		
		Aeropuerto actualizado = aeropuertoRepository.save(aero);
		
		return actualizado;
	}
	
}
