package com.empresariales.ufly.estructure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tiposusuario")
public class TiposUsuario
{
	private short id_tipo_usuario;
	
	private String tipo_usuario;
	
	public TiposUsuario() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public short getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}
	
	@OneToMany
	@NotNull
	@JoinColumn(name = "FKTipoUsuario")
	private List<Usuarios> usuarios = new ArrayList<>();
	
	public void setId_tipo_usuario(short id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	
	
}
