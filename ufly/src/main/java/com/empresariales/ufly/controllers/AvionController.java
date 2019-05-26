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
import com.empresariales.ufly.estructure.Avion;
import com.empresariales.ufly.exception.ResourceNotFoundException;
import com.empresariales.ufly.repository.AvionRepository;
import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/rest/aviones")
@Api(description = "Operaciones de aviones")
public class AvionController {
	@Autowired
	private AvionRepository avionRepository;

	@GetMapping
	public List<Avion> listarAviones() {
		return avionRepository.findAll();
	}

	@PostMapping("/agregar")
	public Avion crearAvion(@RequestBody Avion avion) throws Exception {
		if (existeAvion(avion)) {
			throw new Exception("El avion ya existe");
		}

		return avionRepository.save(avion);
	}

	private boolean existeAvion(Avion avion) {
		List<Avion> aviones = listarAviones();
		for (Avion avionActual : aviones) {
			if (avionActual.getId_avion() == avion.getId_avion()) {
				return true;
			}
		}
		return false;
	}

	@GetMapping("/{id_avion}")
	public Avion darAvionPorId(@PathVariable(value = "id_avion") Integer id_avion) {
		return avionRepository.findById(id_avion)
				.orElseThrow(() -> new ResourceNotFoundException("Avion", "id_avion", id_avion));
	}

	@PutMapping("/{id_avion}")
	public Avion modificarAvion(@PathVariable(value = "id_avion") Integer id_avion,
			@Valid @RequestBody Avion avionNuevo) {
		Avion avion = avionRepository.findById(id_avion)
				.orElseThrow(() -> new ResourceNotFoundException("Avion", "id_avion", id_avion));

		avion.setFabricante(avionNuevo.getFabricante());
		avion.setModelo(avionNuevo.getModelo());
		avion.setAnio_fabricacion(avionNuevo.getAnio_fabricacion());
		avion.setNumero_sillas_business(avionNuevo.getNumero_sillas_business());
		avion.setNumero_sillas_primera(avionNuevo.getNumero_sillas_primera());
		avion.setNumero_sillas_economica(avionNuevo.getNumero_sillas_economica());
		avion.setFkestados_avion(avionNuevo.getFkestados_avion());

		return avionRepository.save(avion);
	}
}