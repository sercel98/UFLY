package com.empresariales.ufly.estructure;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tiposusuario")
public class TiposUsuario implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Short id_tipo_usuario;
	
	@Column(name = "tipo_usuario")
	private String tipo_usuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fktipo_usuario")
	@JsonIgnore
	private List<Usuarios> usuarios;

	public TiposUsuario() {
		super();
	}

	public TiposUsuario(Short id_tipo_usuario, String tipo_usuario, List<Usuarios> usuarios) {
		super();
		this.id_tipo_usuario = id_tipo_usuario;
		this.tipo_usuario = tipo_usuario;
		this.usuarios = usuarios;
	}
	
	public Short getId_tipo_usuario() {
		return id_tipo_usuario;
	}
	
	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setId_tipo_usuario(short id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "TiposUsuario [id_tipo_usuario=" + id_tipo_usuario + ", tipo_usuario=" + tipo_usuario + ", usuarios="
				+ usuarios + "]";
	}
}