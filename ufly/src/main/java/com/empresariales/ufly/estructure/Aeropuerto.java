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
@Table (name = "aeropuertos")
public class Aeropuerto implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_aeropuerto")
	private short id_aeropuerto;
	
	@Column(name = "nombre_aeropuerto", unique = true, length = 50)
	private String nombre_aeropuerto;

	@Column(name = "direccion_aeropuerto", nullable = false, length = 25)
	private String direccion_aeropuerto;

	@Column(name = "telefono", nullable = false, length = 14)
	private String telefono;
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkestados_aeropuerto", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EstadosAeropuerto fkestados_aeropuerto;
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkciudades", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Ciudad fkciudades;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkaeropuertos")
	@JsonIgnore
	private List<Salas> salas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkaeropuertos_origen")
	@JsonIgnore
	private List<Vuelo> aeropuertos_origen;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkaeropuertos_destino")
	@JsonIgnore
	private List<Vuelo> aeropuertos_destino;
	
	public Aeropuerto() {
		super();
	}

	public Aeropuerto(short id_aeropuerto, String nombre_aeropuerto, String direccion_aeropuerto, String telefono) {
		super();
		this.id_aeropuerto = id_aeropuerto;
		this.nombre_aeropuerto = nombre_aeropuerto;
		this.direccion_aeropuerto = direccion_aeropuerto;
		this.telefono = telefono;
	}

	public short getId_aeropuerto() {
		return id_aeropuerto;
	}

	public void setId_aeropuerto(short id_aeropuerto) {
		this.id_aeropuerto = id_aeropuerto;
	}

	public String getNombre_aeropuerto() {
		return nombre_aeropuerto;
	}

	public void setNombre_aeropuerto(String nombre_aeropuerto) {
		this.nombre_aeropuerto = nombre_aeropuerto;
	}

	public String getDireccion_aeropuerto() {
		return direccion_aeropuerto;
	}

	public void setDireccion_aeropuerto(String direccion_aeropuerto) {
		this.direccion_aeropuerto = direccion_aeropuerto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public EstadosAeropuerto getFkestados_aeropuerto() {
		return fkestados_aeropuerto;
	}

	public void setFkestados_aeropuerto(EstadosAeropuerto fkestados_aeropuerto) {
		this.fkestados_aeropuerto = fkestados_aeropuerto;
	}

	public Ciudad getFkciudades() {
		return fkciudades;
	}

	public void setFkciudades(Ciudad fkciudades) {
		System.out.println(fkciudades);
		this.fkciudades = fkciudades;
	}
	
	public List<Salas> getSalas() {
		return salas;
	}

	public void setSalas(List<Salas> salas) {
		this.salas = salas;
	}

	public List<Vuelo> getAeropuertos_origen() {
		return aeropuertos_origen;
	}

	public void setAeropuertos_origen(List<Vuelo> aeropuertos_origen) {
		this.aeropuertos_origen = aeropuertos_origen;
	}

	public List<Vuelo> getAeropuertos_destino() {
		return aeropuertos_destino;
	}

	public void setAeropuertos_destino(List<Vuelo> aeropuertos_destino) {
		this.aeropuertos_destino = aeropuertos_destino;
	}

	@Override
	public String toString() {
		return "Aeropuerto [id_aeropuerto=" + id_aeropuerto + ", nombre_aeropuerto=" + nombre_aeropuerto
				+ ", direccion_aeropuerto=" + direccion_aeropuerto + ", telefono=" + telefono + ", estados" + this.fkestados_aeropuerto +", ciudades =" + this.fkciudades + "]";
	}

}
