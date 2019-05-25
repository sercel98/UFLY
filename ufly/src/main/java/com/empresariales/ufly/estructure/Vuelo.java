package com.empresariales.ufly.estructure;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name = "vuelos")
public class Vuelo implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vuelo", length = 8)
	private int id_vuelo;
	
	@Column(name = "embarque", nullable = false, length = 25)
	private Timestamp embarque;
	
	@Column(name = "desembarque", nullable = false, length = 25)
	private Timestamp desembarque;	
	
	@Column(name = "sillas_disponibles_bussines", nullable = false, length = 4)
	private short sillas_disponibles_bussines;

	@Column(name = "sillas_disponibles_primera", nullable = false, length = 4)
	private short sillas_disponibles_primera;

	@Column(name = "sillas_disponibles_economicos", nullable = false, length = 4)
	private short sillas_disponibles_economicos;
	
	@Column(name = "chequeo", nullable = false, length = 25)
	private Timestamp chequeo;	
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkaeropuertos_origen", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Aeropuerto fkaeropuertos_origen;
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkaeropuertos_destino", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Aeropuerto fkaeropuertos_destino;
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkestados_vuelo", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EstadosVuelo fkestados_vuelo;
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fksalas", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Salas fksalas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkvuelos")
	@JsonIgnore
	private List<Tiquetes> tiquetes;

	public Vuelo() {
		super();
	}

	public Vuelo(int id_vuelo, Timestamp embarque, Timestamp desembarque, short sillas_disponibles_bussines,
			short sillas_disponibles_primera, short sillas_disponibles_economicos, Timestamp chequeo,
			Aeropuerto fkaeropuertos_origen, Aeropuerto fkaeropuertos_destino, EstadosVuelo fkestados_vuelo,
			Salas fksalas) {
		super();
		this.id_vuelo = id_vuelo;
		this.embarque = embarque;
		this.desembarque = desembarque;
		this.sillas_disponibles_bussines = sillas_disponibles_bussines;
		this.sillas_disponibles_primera = sillas_disponibles_primera;
		this.sillas_disponibles_economicos = sillas_disponibles_economicos;
		this.chequeo = chequeo;
		this.fkaeropuertos_origen = fkaeropuertos_origen;
		this.fkaeropuertos_destino = fkaeropuertos_destino;
		this.fkestados_vuelo = fkestados_vuelo;
		this.fksalas = fksalas;
	}

	public int getId_vuelo() {
		return id_vuelo;
	}

	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}

	public Timestamp getEmbarque() {
		return embarque;
	}

	public void setEmbarque(Timestamp embarque) {
		this.embarque = embarque;
	}

	public Timestamp getDesembarque() {
		return desembarque;
	}

	public void setDesembarque(Timestamp desembarque) {
		this.desembarque = desembarque;
	}

	public short getSillas_disponibles_bussines() {
		return sillas_disponibles_bussines;
	}

	public void setSillas_disponibles_bussines(short sillas_disponibles_bussines) {
		this.sillas_disponibles_bussines = sillas_disponibles_bussines;
	}

	public short getSillas_disponibles_primera() {
		return sillas_disponibles_primera;
	}

	public void setSillas_disponibles_primera(short sillas_disponibles_primera) {
		this.sillas_disponibles_primera = sillas_disponibles_primera;
	}

	public short getSillas_disponibles_economicos() {
		return sillas_disponibles_economicos;
	}

	public void setSillas_disponibles_economicos(short sillas_disponibles_economicos) {
		this.sillas_disponibles_economicos = sillas_disponibles_economicos;
	}

	public Timestamp getChequeo() {
		return chequeo;
	}

	public void setChequeo(Timestamp chequeo) {
		this.chequeo = chequeo;
	}

	public Aeropuerto getFkaeropuertos_origen() {
		return fkaeropuertos_origen;
	}

	public void setFkaeropuertos_origen(Aeropuerto fkaeropuertos_origen) {
		this.fkaeropuertos_origen = fkaeropuertos_origen;
	}

	public Aeropuerto getFkaeropuertos_destino() {
		return fkaeropuertos_destino;
	}

	public void setFkaeropuertos_destino(Aeropuerto fkaeropuertos_destino) {
		this.fkaeropuertos_destino = fkaeropuertos_destino;
	}

	public EstadosVuelo getFkestados_vuelo() {
		return fkestados_vuelo;
	}

	public void setFkestados_vuelo(EstadosVuelo fkestados_vuelo) {
		this.fkestados_vuelo = fkestados_vuelo;
	}

	public Salas getFksalas() {
		return fksalas;
	}

	public void setFksalas(Salas fksalas) {
		this.fksalas = fksalas;
	}

	public List<Tiquetes> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(List<Tiquetes> tiquetes) {
		this.tiquetes = tiquetes;
	}

	@Override
	public String toString() {
		return "Vuelo [id_vuelo=" + id_vuelo + ", embarque=" + embarque + ", desembarque=" + desembarque
				+ ", sillas_disponibles_bussines=" + sillas_disponibles_bussines + ", sillas_disponibles_primera="
				+ sillas_disponibles_primera + ", sillas_disponibles_economicos=" + sillas_disponibles_economicos
				+ ", chequeo=" + chequeo + "]";
	}
	
	
}
