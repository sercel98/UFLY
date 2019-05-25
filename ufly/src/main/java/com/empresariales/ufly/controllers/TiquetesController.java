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

import com.empresariales.ufly.estructure.Tiquetes;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.TiquetesRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/tiquetes")
@Api(description = "Operaciones de Tiquetes")
public class TiquetesController 
{
	@Autowired
	private TiquetesRepository tiquetesrepository;
	
	@GetMapping
	public List<Tiquetes> listarTiquetes()
	{
		return tiquetesrepository.findAll();
	}

	@PostMapping("/agregar")
	public Tiquetes crearTiquetes(@Valid @RequestBody Tiquetes tiquete) throws Exception
	{
		if(existeTiquete(tiquete))
		{
			throw new Exception("El tiquete ya existe");

		}
		return tiquetesrepository.save(tiquete);	
	}
	
	private boolean existeTiquete(Tiquetes nuevo)
	{
		List<Tiquetes> tiquetes = listarTiquetes();
		for (Tiquetes tiqueteActual : tiquetes) 
		{
			if(nuevo.getId_tiquete() == tiqueteActual.getId_tiquete())
			{
				return true;
			}
		}
		return false;
	}
	
	@GetMapping("/{id_tiquete}")
	public Tiquetes buscarTiquetesPorId(@PathVariable (value = "id_tiquete")  Integer id_tiquete) {
		return tiquetesrepository.findById(id_tiquete)
	            .orElseThrow(() -> new ResourceNotFoundException("Tiquetes", "id_tiquete", id_tiquete));
	}
	
	@PutMapping("/{id_tiquete}")
	public Tiquetes modificarTiquete(@PathVariable(value = "id_tiquete") Integer id_tiquete, @Valid @RequestBody Tiquetes tiqueteDetalles)
	{
		Tiquetes tiquete = tiquetesrepository.findById(id_tiquete)
	            .orElseThrow(() -> new ResourceNotFoundException("Tiquetes", "id_tiquete", id_tiquete));
		
		tiquete.setNumero_asiento(tiqueteDetalles.getNumero_asiento());
		tiquete.setPrecio_tiquete(tiqueteDetalles.getPrecio_tiquete());
		tiquete.setFkestado_tiquete(tiqueteDetalles.getFkestado_tiquete());
		tiquete.setFkpasajeros(tiqueteDetalles.getFkpasajeros());
		tiquete.setFktipos_tiquete(tiqueteDetalles.getFktipos_tiquete());
		tiquete.setFkusuarios(tiqueteDetalles.getFkusuarios());
		tiquete.setFkvuelos(tiqueteDetalles.getFkvuelos());
		
		return tiquetesrepository.save(tiquete);
		
	}
	
	
}
