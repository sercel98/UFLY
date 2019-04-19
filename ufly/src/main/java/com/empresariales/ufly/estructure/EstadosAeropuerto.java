package com.empresariales.ufly.estructure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadosaeropuerto")
public class EstadosAeropuerto 
{
	private Short id_estado_aeropuerto;
	
	private String nombre_estado;
	
	public EstadosAeropuerto() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Short getId_estado_aeropuerto() {
		return id_estado_aeropuerto;
	}

	public void setId_estado_aeropuerto(Short id_estado_aeropuerto) {
		this.id_estado_aeropuerto = id_estado_aeropuerto;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}
	
	

}
