package com.empresariales.ufly.estructure;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios
{
	
	private int id_usuario;
	
	private BigInteger cedula;
	
	private String contrasenia;
	
	private String primer_nombre;
	
	private String segundo_nombre;
	
	private String primer_apellido;
	
	private String segundo_apellido;
	
	private String correo_electronico;
	
	private String telefono;
	
	private TiposUsuario FKTipoUsuario;

	public Usuarios() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Column(name = "cedula")
	public BigInteger getCedula() {
		return cedula;
	}

	public void setCedula(BigInteger cedula) {
		this.cedula = cedula;
	}
	
	@Column(name = "contrasenia")
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Column(name = "primer_nombre")
	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	@Column(name = "segundo_nombre")
	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	@Column(name = "primer_apellido")
	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	@Column(name = "segundo_apellido")
	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	@Column(name = "correo_electronico")
	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@ManyToOne
	public TiposUsuario getFKTipoUsuario() {
		return FKTipoUsuario;
	}

	public void setFKTipoUsuario(TiposUsuario fKTipoUsuario) {
		FKTipoUsuario = fKTipoUsuario;
	}

	
	
	
}
