package com.empresariales.ufly.estructure;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "ciudades")
public class Ciudad implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ciudad")
	private short id_ciudad;
	
	@Column(name = "nombre_ciudad")
	private String nombre_ciudad;
	
	@ManyToOne
    @JoinColumn(name = "fkpaises", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pais fkpaises;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkciudades")
	@JsonIgnore
	private List<Aeropuerto> aeropuertos;

	public Ciudad() {
		super();
	}

	public Ciudad(short id_ciudad, String nombre_ciudad) {
		super();
		this.id_ciudad = id_ciudad;
		this.nombre_ciudad = nombre_ciudad;
	}

	public short getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(short id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre_ciudad() {
		return nombre_ciudad;
	}

	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}

	public Pais getFKPais() {
		return fkpaises;
	}

	public void setFKPais(Pais fKPais) {
		fkpaises = fKPais;
	}

	public List<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public void setAeropuertos(List<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	
}