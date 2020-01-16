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
@Table(name = "tipostiquete")
public class TiposTiquete implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo", length = 1)
	private Short id_tipo;
	
	@Column(name = "nombre_tipo", unique = true, length = 15)
	private String nombre_tipo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fktipos_tiquete")
	@JsonIgnore
	private List<Tiquetes> tiquetes;

	public TiposTiquete() {
		super();
	}

	public TiposTiquete(Short id_tipo) {
		super();
		this.id_tipo = id_tipo;
	}

	public TiposTiquete(Short id_tipo, String nombre_tipo) {
		super();
		this.id_tipo = id_tipo;
		this.nombre_tipo = nombre_tipo;
	}

	public Short getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Short id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNombre_tipo() {
		return nombre_tipo;
	}

	public void setNombre_tipo(String nombre_tipo) {
		this.nombre_tipo = nombre_tipo;
	}

	public List<Tiquetes> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(List<Tiquetes> tiquetes) {
		this.tiquetes = tiquetes;
	}

	@Override
	public String toString() {
		return "TipoTiquete [id_tipo=" + id_tipo + ", nombre_tipo=" + nombre_tipo + "]";
	}
	
	

}
