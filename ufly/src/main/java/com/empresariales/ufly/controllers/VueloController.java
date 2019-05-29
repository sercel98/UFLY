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

import com.empresariales.ufly.estructure.EstadosTiquete;
import com.empresariales.ufly.estructure.TiposTiquete;
import com.empresariales.ufly.estructure.Tiquetes;
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
	
	@Autowired
	private TiquetesController tiqueteController;
	
	@GetMapping
	public List<Vuelo> listarVuelos()
	{	
		return vueloRepository.findAll();
	}
	
	
	@PostMapping("/agregar/{precio_business}/{precio_primera_clase}/{precio_economica}")
	public Vuelo crearVuelo(@RequestBody Vuelo vuelo, @PathVariable(value = "precio_business") Integer precio_business,
								@PathVariable(value = "precio_primera_clase") Integer precio_primera_clase, 
								@PathVariable(value = "precio_economica") Integer precio_economica) throws Exception
	{
		if(existeVuelo(vuelo))
		{
			throw new Exception("El vuelo ya existe");
		}
		System.out.println(vuelo);

		vueloRepository.save(vuelo);
		
		short numero = 1;
		
		TiposTiquete tipoBusiness = new TiposTiquete(Short.parseShort("1"));
		TiposTiquete tipoPrimeraClase = new TiposTiquete(Short.parseShort("2"));
		TiposTiquete tipoEconomica = new TiposTiquete(Short.parseShort("3"));
		
		EstadosTiquete estadoDisponible = new EstadosTiquete(Short.parseShort("1"));
		
		for(int i = 0; i < vuelo.getSillas_disponibles_business(); i++)
		{
			
			Tiquetes tiquete = new Tiquetes(precio_business, numero, vuelo, tipoBusiness, estadoDisponible);
			tiqueteController.crearTiquetes(tiquete);
			numero++;
		}
		
		for(int i = 0; i < vuelo.getSillas_disponibles_primera(); i++)
		{
			
			Tiquetes tiquete = new Tiquetes(precio_primera_clase, numero, vuelo, tipoPrimeraClase, estadoDisponible);
			tiqueteController.crearTiquetes(tiquete);
			numero++;
		}
		
		for(int i = 0; i < vuelo.getSillas_disponibles_economicos(); i++)
		{
			
			Tiquetes tiquete = new Tiquetes(precio_economica, numero, vuelo, tipoEconomica, estadoDisponible);
			tiqueteController.crearTiquetes(tiquete);
			numero++;
		}
		System.out.println(vuelo);

		return vuelo;
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
		vuelo.setSillas_disponibles_business(vueloNuevo.getSillas_disponibles_business());
		vuelo.setSillas_disponibles_economicos(vueloNuevo.getSillas_disponibles_economicos());
		vuelo.setSillas_disponibles_primera(vueloNuevo.getSillas_disponibles_primera());
		vuelo.setCheck_in(vueloNuevo.getCheck_in());
		vuelo.setFkaeropuertos_origen(vueloNuevo.getFkaeropuertos_origen());
		vuelo.setFkaeropuertos_destino(vueloNuevo.getFkaeropuertos_destino());
		vuelo.setFkestados_vuelo(vueloNuevo.getFkestados_vuelo());
		vuelo.setFkaviones(vueloNuevo.getFkaviones());
		vuelo.setFksalas(vueloNuevo.getFksalas());
		
		return vueloRepository.save(vuelo);
	}
}
