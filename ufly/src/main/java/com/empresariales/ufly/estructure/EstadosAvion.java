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
@Table(name = "estadosavion")
public class EstadosAvion implements Serializable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_avion", length = 1)
	private Short id_estado_avion;

	@Column(name = "nombre_estado", unique = true, length = 15)
	private String nombre_estado;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkestados_avion")
	@JsonIgnore
	private List<Avion> aviones;

	public EstadosAvion() {
		super();
	}

	public EstadosAvion(Short id_estado_avion, String nombre_estado) {
		super();
		this.id_estado_avion = id_estado_avion;
		this.nombre_estado = nombre_estado;
	}

	public Short getId_estado_avion() {
		return id_estado_avion;
	}

	public void setId_estado_avion(Short id_estado_avion) {
		this.id_estado_avion = id_estado_avion;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	public List<Avion> getAviones() {
		return aviones;
	}

	public void setAviones(List<Avion> aviones) {
		this.aviones = aviones;
	}

	@Override
	public String toString() {
		return "EstadosAvion [id_estado_avion=" + id_estado_avion + ", nombre_estado=" + nombre_estado + ", aviones="
				+ aviones + "]";
	}
}