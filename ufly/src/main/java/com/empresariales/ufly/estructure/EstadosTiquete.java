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
@Table(name = "estadotiquete")
public class EstadosTiquete implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado", length = 1)
	private Short id_estado;
	
	@Column(name = "nombre_estado", unique = true, length = 10)
	private String nombre_estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkestado_tiquete")
	@JsonIgnore
	private List<Tiquetes> tiquetes;

	public EstadosTiquete() {
		super();
	}

	public EstadosTiquete(Short id_estado, String nombre_estado) {
		super();
		this.id_estado = id_estado;
		this.nombre_estado = nombre_estado;
	}

	public Short getId_estado() {
		return id_estado;
	}

	public void setId_estado(Short id_estado) {
		this.id_estado = id_estado;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	public List<Tiquetes> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(List<Tiquetes> tiquetes) {
		this.tiquetes = tiquetes;
	}

	@Override
	public String toString() {
		return "EstadosTiquete [id_estado=" + id_estado + ", nombre_estado=" + nombre_estado + "]";
	}
	
	

}
