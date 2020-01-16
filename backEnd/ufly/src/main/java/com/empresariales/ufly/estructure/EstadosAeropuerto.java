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
@Table(name = "estadosaeropuerto")
public class EstadosAeropuerto implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_aeropuerto", length = 1)
	private Short id_estado_aeropuerto;
	
	@Column(name = "nombre_estado", unique = true, length = 12)
	private String nombre_estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkestados_aeropuerto")
	@JsonIgnore
    private List<Aeropuerto> aeropuertos;
	
	public EstadosAeropuerto() {
		super();
	}
	
	public EstadosAeropuerto(Short id_estado_aeropuerto, String nombre_estado) {
		super();
		this.id_estado_aeropuerto = id_estado_aeropuerto;
		this.nombre_estado = nombre_estado;
	}

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

	public List<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public void setAeropuertos(List<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	@Override
	public String toString() {
		return "EstadosAeropuerto [id_estado_aeropuerto=" + id_estado_aeropuerto + ", nombre_estado=" + nombre_estado
				+ "]";
	}
	
	

}
