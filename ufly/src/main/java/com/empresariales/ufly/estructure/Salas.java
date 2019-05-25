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
@Table(name = "salas")
public class Salas implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_salas", length = 3)
	private Short id_sala;
	
	@Column(name = "nombre_sala", length = 10)
	private String nombre_sala;
	
	@ManyToOne
    @JoinColumn(name = "fkestado_sala", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EstadosSala fkestado_sala;

	@ManyToOne
    @JoinColumn(name = "fkaeropuertos", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)	
	private Aeropuerto fkaeropuertos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fksalas")
	@JsonIgnore
	private List<Vuelo> salas;
	
	public Salas() {
		super();
	}

	public Salas(Short id_sala, String nombre_sala) {
		super();
		this.id_sala = id_sala;
		this.nombre_sala = nombre_sala;
	}

	public Short getId_sala() {
		return id_sala;
	}

	public void setId_sala(Short id_sala) {
		this.id_sala = id_sala;
	}

	public String getNombre_sala() {
		return nombre_sala;
	}

	public void setNombre_sala(String nombre_sala) {
		this.nombre_sala = nombre_sala;
	}

	public EstadosSala getFkestado_sala() {
		return fkestado_sala;
	}

	public void setFkestado_sala(EstadosSala fkestado_sala) {
		this.fkestado_sala = fkestado_sala;
	}

	public Aeropuerto getFkaeropuertos() {
		return fkaeropuertos;
	}

	public void setFkaeropuertos(Aeropuerto fkaeropuertos) {
		this.fkaeropuertos = fkaeropuertos;
	}

	@Override
	public String toString() {
		return "Salas [id_sala=" + id_sala + ", nombre_sala=" + nombre_sala + "]";
	}
}
