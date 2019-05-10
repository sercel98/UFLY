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
@Table(name = "estadostripulante")
public class EstadosTripulante implements Serializable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_tripulante", length = 1)
	private Short id_estado_tripulante;

	@Column(name = "nombre_estado", unique = true, length = 15)
	private String nombre_estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkestados_tripulante")
	@JsonIgnore
	private List<Tripulantes> tripulantes;

		
	public EstadosTripulante(Short id_estado_tripulante, String nombre_estado) {
		super();
		this.id_estado_tripulante = id_estado_tripulante;
		this.nombre_estado = nombre_estado;
	}

	public Short getId_estado_tripulante() {
		return id_estado_tripulante;
	}

	public void setId_estado_tripulante(Short id_estado_tripulante) {
		this.id_estado_tripulante = id_estado_tripulante;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	public List<Tripulantes> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulantes> tripulantes) {
		this.tripulantes = tripulantes;
	}

	@Override
	public String toString() {
		return "EstadosTripulante [id_estado_tripulante=" + id_estado_tripulante + ", nombre_estado=" + nombre_estado
				+ "]";
	}
	
}
