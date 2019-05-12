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
@Table(name = "estadossala")
public class EstadosSala implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_sala", length = 1)
	private Short id_estado_sala;
	
	@Column(name = "nombre_estado", unique = true, length = 15)
	private String nombre_estado;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkestado_sala")
	@JsonIgnore
    private List<Salas> salas;
	
	public EstadosSala() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadosSala(Short id_estado_sala, String nombre_estado) {
		super();
		this.id_estado_sala = id_estado_sala;
		this.nombre_estado = nombre_estado;
	}

	public Short getId_estado_sala() {
		return id_estado_sala;
	}

	public void setId_estado_sala(Short id_estado_sala) {
		this.id_estado_sala = id_estado_sala;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	public List<Salas> getSalas() {
		return salas;
	}

	public void setSalas(List<Salas> salas) {
		this.salas = salas;
	}

	@Override
	public String toString() {
		return "EstadosSala [id_estado_sala=" + id_estado_sala + ", nombre_estado=" + nombre_estado + "]";
	}

}
