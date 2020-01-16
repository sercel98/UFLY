package com.empresariales.ufly.controllers;

import java.util.ArrayList;
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
import com.empresariales.ufly.estructure.CargosActuales;
import com.empresariales.ufly.repository.CargosActualesRepository;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/cargosactuales")
@Api(description = "Operaciones de cargos actuales de tripulantes")
public class CargosActualesController 
{
	@Autowired
	private CargosActualesRepository cargosARepository;

	@GetMapping("/{fktripulantes}")
	public List<CargoTripulante> listarCargosTripulante(@PathVariable (value = "fktripulantes") int fktripulantes)
	{
		List<CargosActuales> cargosActuales = cargosARepository.findAll();
		List<CargoTripulante> cargosTripulante = new ArrayList<>();
		
		for (CargosActuales cargoActual : cargosActuales) {
			if(cargoActual.getFktripulantes().getId_tripulante() == fktripulantes)
			{
				cargosTripulante.add(cargoActual.getFkcargo_tripulante());
			}
		}
		
		return cargosTripulante;
	}
	
	@GetMapping
	public List<CargosActuales> listarCargosActuales()
	{
		return cargosARepository.findAll();
	}

	@PostMapping("/agregar")
	public CargosActuales crearCargosActuales(@Valid @RequestBody CargosActuales cargoActual) throws Exception
	{
		List<CargoTripulante> cargosTripulante = listarCargosTripulante(cargoActual.getFktripulantes().getId_tripulante());
		
		for (CargoTripulante cargoTripulante : cargosTripulante) {
			if(cargoActual.getFkcargo_tripulante().getCargo_tripulante().equals(cargoTripulante.getCargo_tripulante()))
			{
				throw new Exception("Ya existe este cargo para este tripulante");
			}
		}
		
		return cargosARepository.save(cargoActual);
	}
	
	/**
	@GetMapping("/{id_cargosactuales}")
	public CargosActuales darCargosActualesPorId(@PathVariable (value = "id_cargos_actuales")  Short id_estado)
	{
		return cargosARepository.findById(id_estado)
	            .orElseThrow(() -> new ResourceNotFoundException("CargosActuales", "id_cargos_actuales", id_estado));
	}**/
	
}