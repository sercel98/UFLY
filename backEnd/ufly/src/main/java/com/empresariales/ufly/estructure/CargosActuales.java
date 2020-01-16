package com.empresariales.ufly.estructure;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cargosactuales")
public class CargosActuales implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargos_actuales", length = 1)
	private Short id_cargos_actuales;
	
	@ManyToOne
    @JoinColumn(name = "fkcargo_tripulante", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CargoTripulante fkcargo_tripulante;
	
	@ManyToOne
    @JoinColumn(name = "fktripulantes", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Tripulantes fktripulantes;

	public CargosActuales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargosActuales(Short id_cargos_actuales, CargoTripulante fkcargo_tripulante, Tripulantes fktripulantes) {
		super();
		this.id_cargos_actuales = id_cargos_actuales;
		this.fkcargo_tripulante = fkcargo_tripulante;
		this.fktripulantes = fktripulantes;
	}

	public Short getId_cargos_actuales() {
		return id_cargos_actuales;
	}

	public void setId_cargos_actuales(Short id_cargos_actuales) {
		this.id_cargos_actuales = id_cargos_actuales;
	}

	public CargoTripulante getFkcargo_tripulante() {
		return fkcargo_tripulante;
	}

	public void setFkcargo_tripulante(CargoTripulante fkcargo_tripulante) {
		this.fkcargo_tripulante = fkcargo_tripulante;
	}

	public Tripulantes getFktripulantes() {
		return fktripulantes;
	}

	public void setFktripulantes(Tripulantes fktripulantes) {
		this.fktripulantes = fktripulantes;
	}

	@Override
	public String toString() {
		return "CargosActuales [id_cargos_actuales=" + id_cargos_actuales + ", fkcargo_tripulante=" + fkcargo_tripulante
				+ ", fktripulantes=" + fktripulantes + "]";
	}
	
	
}
