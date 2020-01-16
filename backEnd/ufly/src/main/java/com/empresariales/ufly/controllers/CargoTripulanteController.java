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

import com.empresariales.ufly.estructure.CargoTripulante;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.CargoTripulanteRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/cargostripulantes")
@Api(description = "Operaciones de los cargos de los tripulantes")
public class CargoTripulanteController 
{
	@Autowired
	private CargoTripulanteRepository cargoTRepository;
	
	@GetMapping
	public List<CargoTripulante> listarCargosTripulantes()
	{
		return cargoTRepository.findAll();
	}
	
	@PostMapping("/agregar")
	public CargoTripulante crearCargoTripulante(@Valid @RequestBody CargoTripulante cargo) throws Exception
	{
		if(existeCargo(cargo))
		{
			throw new Exception("El nombre del cargo ya existe");
		}
		
		return cargoTRepository.save(cargo);
	}
	
	private boolean existeCargo(CargoTripulante cargo)
	{
		List<CargoTripulante> cargosTripulante = listarCargosTripulantes();
		for (CargoTripulante cargoActual : cargosTripulante)
		{
			if(cargoActual.getCargo_tripulante().equals(cargo.getCargo_tripulante()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	@GetMapping("/{id_cargo}")
	public CargoTripulante buscarCargoPorId(@PathVariable (value = "id_cargo") Short id_cargo)
	{
		return cargoTRepository.findById(id_cargo)
	            .orElseThrow(() -> new ResourceNotFoundException("CargoTripulante", "id_cargo_tripulante", id_cargo));
	}
	
}
