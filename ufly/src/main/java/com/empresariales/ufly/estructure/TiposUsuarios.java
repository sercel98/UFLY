package com.empresariales.ufly.estructure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

@Entity
@Table(name = "tiposusuarios")
public class TiposUsuarios 
{
	private short id_tipo_usuario;
	
	private String tipo_usuario;
	
	private Usuarios usuario;

	
	public TiposUsuarios() {
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

	@OneToOne(mappedBy = "FKTipoUsuario")
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setId_tipo_usuario(short id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	
	
}
