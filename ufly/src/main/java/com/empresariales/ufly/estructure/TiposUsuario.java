package com.empresariales.ufly.estructure;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity
@Table(name = "tiposusuario")
public class TiposUsuario
{
	private short id_tipo_usuario;
	
	private String tipo_usuario;

	@OneToMany(mappedBy = "FKTipoUsuario", cascade = CascadeType.ALL)
	private Set<Usuarios> usuarios;

	public TiposUsuario() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	public short getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	@Column(name = "tipo_usuario")
	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setId_tipo_usuario(short id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	
	
	
}