package com.empresariales.ufly.estructure;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tripulantes")
public class Tripulantes implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tripulante", length = 5)
	private int id_tripulante;
	
	@Column(name = "cedula_tripulante", unique = true, length = 15)
	private BigInteger cedula_tripulante;
	
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
	
	@Column(name = "direccion", nullable = false, length = 50)
	private String direccion;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_nacimiento;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkestados_tripulante", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EstadosTripulante fkestados_tripulante;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fktripulantes")
	@JsonIgnore
	private List<CargosActuales> tripulantes;
	
	public Tripulantes() {
		super();
	}
	
	public Tripulantes(int id_tripulante, BigInteger cedula_tripulante, String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, String telefono, short genero,
			String direccion, Date fecha_nacimiento, EstadosTripulante fkestados_tripulante) {
		super();
		this.id_tripulante = id_tripulante;
		this.cedula_tripulante = cedula_tripulante;
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.telefono = telefono;
		this.genero = genero;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fkestados_tripulante = fkestados_tripulante;
	}

	public int getId_tripulante() {
		return id_tripulante;
	}

	public void setId_tripulante(int id_tripulante) {
		this.id_tripulante = id_tripulante;
	}

	public BigInteger getCedula_tripulante() {
		return cedula_tripulante;
	}

	public void setCedula_tripulante(BigInteger cedula_tripulante) {
		this.cedula_tripulante = cedula_tripulante;
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

	public EstadosTripulante getFkestados_tripulante() {
		return fkestados_tripulante;
	}

	public void setFkestados_tripulante(EstadosTripulante fkestados_tripulante) {
		this.fkestados_tripulante = fkestados_tripulante;
	}

	@Override
	public String toString() {
		return "Tripulantes [id_tripulante=" + id_tripulante + ", cedula_tripulante=" + cedula_tripulante
				+ ", primer_nombre=" + primer_nombre + ", segundo_nombre=" + segundo_nombre + ", primer_apellido="
				+ primer_apellido + ", segundo_apellido=" + segundo_apellido + ", telefono=" + telefono + ", genero="
				+ genero + ", direccion=" + direccion + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", fkestados_tripulante=" + fkestados_tripulante + "]";
	}

	
}
