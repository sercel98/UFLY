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
@Table(name = "estadosvuelo")
public class EstadosVuelo implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_vuelo", length = 1)
	private Short id_estado_vuelo;
	
	@Column(name = "nombre_estado", unique = true, length = 12)
	private String nombre_estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkestados_vuelo")
	@JsonIgnore
	private List<Vuelo> vuelos;

	public EstadosVuelo() {
		super();
	}

	public EstadosVuelo(Short id_estado_vuelo, String nombre_estado) {
		super();
		this.id_estado_vuelo = id_estado_vuelo;
		this.nombre_estado = nombre_estado;
	}

	public Short getId_estado_vuelo() {
		return id_estado_vuelo;
	}

	public void setId_estado_vuelo(Short id_estado_vuelo) {
		this.id_estado_vuelo = id_estado_vuelo;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}
	
	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	@Override
	public String toString() {
		return "EstadosVuelo [id_estado_vuelo=" + id_estado_vuelo + ", nombre_estado=" + nombre_estado + "]";
	}
	
	
}
