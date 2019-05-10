package com.empresariales.ufly.estructure;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cargotripulante")
public class CargoTripulante implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargo_tripulante", length = 1)
	private Short id_cargo_tripulante;
	
	@Column(name = "cargo_tripulante", unique = true, length = 20)
	private String cargo_tripulante; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcargo_tripulante")
	@JsonIgnore
	private List<CargosActuales> cargos;

	public CargoTripulante(Short id_cargo_tripulante, String cargo_tripulante) {
		super();
		this.id_cargo_tripulante = id_cargo_tripulante;
		this.cargo_tripulante = cargo_tripulante;
	}

	public Short getId_cargo_tripulante() {
		return id_cargo_tripulante;
	}

	public void setId_cargo_tripulante(Short id_cargo_tripulante) {
		this.id_cargo_tripulante = id_cargo_tripulante;
	}

	public String getCargo_tripulante() {
		return cargo_tripulante;
	}

	public void setCargo_tripulante(String cargo_tripulante) {
		this.cargo_tripulante = cargo_tripulante;
	}

	public List<CargosActuales> getCargos() {
		return cargos;
	}

	public void setCargos(List<CargosActuales> cargos) {
		this.cargos = cargos;
	}

	
}
