package com.empresariales.ufly.estructure;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	
	@Column(name = "cedula")
	private BigInteger cedula;
	
	@Column(name = "contrasenia")
	private String contrasenia;
	
	@Column(name = "primer_nombre")
	private String primer_nombre;
	
	@Column(name = "segundo_nombre")
	private String segundo_nombre;
	
	@Column(name = "primer_apellido")
	private String primer_apellido;
	
	@Column(name = "segundo_apellido")
	private String segundo_apellido;
	
	@Column(name = "correo_electronico")
	private String correo_electronico;
	
	@Column(name = "telefono")
	private String telefono;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fktipo_usuario", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TiposUsuario fktipo_usuario;

	public Usuarios() {
		super();
	}
	
	public Usuarios(int id_usuario, BigInteger cedula, String contrasenia, String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, String correo_electronico, String telefono,
			TiposUsuario fktipo_usuario) {
		super();
		this.id_usuario = id_usuario;
		this.cedula = cedula;
		this.contrasenia = contrasenia;
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.correo_electronico = correo_electronico;
		this.telefono = telefono;
		this.fktipo_usuario = fktipo_usuario;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public BigInteger getCedula() {
		return cedula;
	}

	public void setCedula(BigInteger cedula) {
		this.cedula = cedula;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TiposUsuario getFktipo_usuario() {
		return fktipo_usuario;
	}

	public void setFktipo_usuario(TiposUsuario fktipo_usuario) {
		this.fktipo_usuario = fktipo_usuario;
	}

	@Override
	public String toString() {
		return "Usuarios [id_usuario=" + id_usuario + ", cedula=" + cedula + ", contrasenia=" + contrasenia
				+ ", primer_nombre=" + primer_nombre + ", segundo_nombre=" + segundo_nombre + ", primer_apellido="
				+ primer_apellido + ", segundo_apellido=" + segundo_apellido + ", correo_electronico="
				+ correo_electronico + ", telefono=" + telefono + ", fktipo_usuario=" + fktipo_usuario + "]";
	}
}