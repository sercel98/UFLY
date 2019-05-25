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

import com.empresariales.ufly.estructure.Vuelo;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.VueloRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/vuelos")
@Api(description = "Operaciones de vuelos")
public class VueloController 
{
	@Autowired
	private VueloRepository vueloRepository;
	
	
	@GetMapping
	public List<Vuelo> listarVuelos()
	{
		return vueloRepository.findAll();
	}
	
	
	@PostMapping("/agregar")
	public Vuelo crearVuelo(@RequestBody Vuelo vuelo) throws Exception
	{
		if(existeVuelo(vuelo))
		{
			throw new Exception("El vuelo ya existe");
		}
		
		return vueloRepository.save(vuelo);
	}
	
	private boolean existeVuelo(Vuelo vuelo)
	{
		List<Vuelo> vuelos = listarVuelos();
		for (Vuelo vueloActual : vuelos)
		{
			if(vueloActual.getId_vuelo() == vuelo.getId_vuelo())
			{
				return true;
			}
		}
		
		return false;
	}
	
	@GetMapping("/{id_vuelo}")
	public Vuelo darVueloPorId(@PathVariable(value = "id_vuelo") Integer id_vuelo)
	{
		return vueloRepository.findById(id_vuelo)
	            .orElseThrow(() -> new ResourceNotFoundException("Vuelo", "id_vuelo", id_vuelo));
	}
	
	@PutMapping("/{id_vuelo}")
	public Vuelo modificarVuelo(@PathVariable(value = "id_vuelo") Integer id_vuelo, @Valid @RequestBody Vuelo vueloNuevo)
	{
		Vuelo vuelo = vueloRepository.findById(id_vuelo)
	            .orElseThrow(() -> new ResourceNotFoundException("Vuelo", "id_vuelo", id_vuelo));
		
		vuelo.setEmbarque(vueloNuevo.getEmbarque());
		vuelo.setDesembarque(vueloNuevo.getDesembarque());
		vuelo.setSillas_disponibles_bussines(vueloNuevo.getSillas_disponibles_bussines());
		vuelo.setSillas_disponibles_economicos(vueloNuevo.getSillas_disponibles_economicos());
		vuelo.setSillas_disponibles_primera(vueloNuevo.getSillas_disponibles_primera());
		vuelo.setChequeo(vueloNuevo.getChequeo());
		vuelo.setFkaeropuertos_origen(vueloNuevo.getFkaeropuertos_origen());
		vuelo.setFkaeropuertos_destino(vueloNuevo.getFkaeropuertos_destino());
		vuelo.setFkestados_vuelo(vueloNuevo.getFkestados_vuelo());
		vuelo.setFksalas(vueloNuevo.getFksalas());
		
		return vueloRepository.save(vuelo);
	}
	

}
