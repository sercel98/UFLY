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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", length = 10)
	private int id_usuario;
	
	@Column(name = "cedula", unique = true, length = 15)
	private BigInteger cedula;
	
	@Column(name = "contrasenia", nullable = false, length = 15)
	private String contrasenia;
	
	@Column(name = "primer_nombre", nullable = false, length = 20)
	private String primer_nombre;
	
	@Column(name = "segundo_nombre", nullable = true, length = 20)
	private String segundo_nombre;
	
	@Column(name = "primer_apellido", nullable = false, length = 20)
	private String primer_apellido;
	
	@Column(name = "segundo_apellido", nullable = false, length = 20)
	private String segundo_apellido;
	
	@Column(name = "correo_electronico", unique = true, length = 50)
	private String correo_electronico;
	
	@Column(name = "telefono", nullable = false, length = 14)
	private String telefono;
	
	@Column(name = "genero", nullable = false, length = 2)
	private short genero;
	
	@Column(name = "direccion", nullable = false, length = 50)
	private String direccion;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_nacimiento;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fktipo_usuario", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TiposUsuario fktipo_usuario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkusuarios")
	@JsonIgnore
	private List<Tiquetes> tiquetes;

	public Usuarios() {
		super();
	}
	
	public Usuarios(int id_usuario, BigInteger cedula, String contrasenia, String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, String correo_electronico, String telefono, short genero,
			String direccion, Date fecha_nacimiento, TiposUsuario fktipo_usuario) {
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
		this.genero = genero;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
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