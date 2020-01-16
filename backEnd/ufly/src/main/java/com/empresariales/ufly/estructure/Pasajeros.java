package com.empresariales.ufly.estructure;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pasajeros")
public class Pasajeros implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pasajero", length = 10)
	private int id_pasajero;
	
	@Column(name = "cedula", unique = true, length = 15)
	private BigInteger cedula;
		
	@Column(name = "primer_nombre", nullable = false, length = 20)
	private String primer_nombre;
	
	@Column(name = "segundo_nombre", nullable = true, length = 20)
	private String segundo_nombre;
	
	@Column(name = "primer_apellido", nullable = false, length = 20)
	private String primer_apellido;
	
	@Column(name = "segundo_apellido", nullable = false, length = 20)
	private String segundo_apellido;
	
	@Column(name = "telefono", nullable = false, length = 14)
	private String telefono;
	
	@Column(name = "genero", nullable = false, length = 1)
	private short genero;
	
	@Column(name = "direccion", nullable = false, length = 30)
	private String direccion;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_nacimiento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkpasajeros")
	@JsonIgnore
	private List<Tiquetes> tiquetes;
	
	public Pasajeros() {
		super();
	}
	
	public Pasajeros(int id_pasajero, BigInteger cedula, String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, String telefono, short genero, String direccion,
			Date fecha_nacimiento) {
		super();
		this.id_pasajero = id_pasajero;
		this.cedula = cedula;
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.telefono = telefono;
		this.genero = genero;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getId_pasajero() {
		return id_pasajero;
	}

	public void setId_pasajero(int id_pasajero) {
		this.id_pasajero = id_pasajero;
	}

	public BigInteger getCedula() {
		return cedula;
	}

	public void setCedula(BigInteger cedula) {
		this.cedula = cedula;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public short getGenero() {
		return genero;
	}

	public void setGenero(short genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public List<Tiquetes> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(List<Tiquetes> tiquetes) {
		this.tiquetes = tiquetes;
	}

	@Override
	public String toString() {
		return "Pasajeros [id_pasajero=" + id_pasajero + ", cedula=" + cedula + ", primer_nombre=" + primer_nombre
				+ ", segundo_nombre=" + segundo_nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido="
				+ segundo_apellido + ", telefono=" + telefono + ", genero=" + genero + ", direccion=" + direccion
				+ ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}
	
}
