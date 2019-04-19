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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_ciudad")
	private short idCiudad;
	
	@Column(name = "nombre_ciudad")
	private String nombreCiudad;
	
	@ManyToOne
    @JoinColumn(name = "fkpais", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Pais FKPais;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkciudades")
	@JsonIgnore
	private List<Aeropuerto> aeropuertos = new ArrayList<>();

	public Ciudad() {
		super();
	}

	public Ciudad(short idCiudad, String nombreCiudad, Pais fKPais) {
		super();
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
		FKPais = fKPais;
	}

	public short getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(short idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Pais getFKPais() {
		return FKPais;
	}

	public void setFKPais(Pais fKPais) {
		FKPais = fKPais;
	}
	
	public List<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public void setAeropuertos(List<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	@Override
	public String toString() {
		return "Ciudad [idCiudad=" + idCiudad + ", nombreCiudad=" + nombreCiudad + ", FKPais=" + FKPais + "]";
	}
	
}