package com.empresariales.ufly.estructure;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "paises")
public class Pais implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pais")
	private short id_pais;
	
	@Column(name = "nombre_pais")
	private String nombre_pais;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkpaises")
	@JsonIgnore
    private List<Ciudad> ciudades = new ArrayList<>();

	public Pais() {
		super();
	}

	public Pais(short id_pais, String nombre_pais) {
		super();
		this.id_pais = id_pais;
		this.nombre_pais = nombre_pais;
	}

	public short getId_pais() {
		return id_pais;
	}

	public void setId_pais(short id_pais) {
		this.id_pais = id_pais;
	}

	public String getNombre_pais() {
		return nombre_pais;
	}

	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	@Override
	public String toString() {
		return "Pais [id_pais=" + id_pais + ", nombre_pais=" + nombre_pais + ", ciudades=" + ciudades + "]";
	}

	
}
