package com.empresariales.ufly.estructure;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name = "vuelos")
public class Vuelo implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vuelo", length = 8)
	private int id_vuelo;
	
	@JsonFormat(timezone = "GMT-5")
	@Column(name = "embarque", nullable = false, length = 25)
	private Date embarque;
	
	@JsonFormat(timezone = "GMT-5")
	@Column(name = "desembarque", nullable = false, length = 25)
	private Date desembarque;
	
	@JsonFormat(timezone = "GMT-5")
	@Column(name = "check_in", nullable = false, length = 25)
	private Date check_in;
	
	@Column(name = "sillas_disponibles_business", nullable = false, length = 4)
	private short sillas_disponibles_business;

	@Column(name = "sillas_disponibles_primera", nullable = false, length = 4)
	private short sillas_disponibles_primera;

	@Column(name = "sillas_disponibles_economicos", nullable = false, length = 4)
	private short sillas_disponibles_economicos;	
	
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

	@ManyToOne // (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkaviones", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Avion fkaviones;
	
	@ManyToOne // (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fksalas", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Salas fksalas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkvuelos")
	@JsonIgnore
	private List<Tiquetes> tiquetes;

	public Vuelo() {
		super();
	}

	public Vuelo(int id_vuelo, Date embarque, Date desembarque, short sillas_disponibles_business,
			short sillas_disponibles_primera, short sillas_disponibles_economicos, Date chequeo,
			Aeropuerto fkaeropuertos_origen, Aeropuerto fkaeropuertos_destino, EstadosVuelo fkestados_vuelo,
			Salas fksalas) {
		super();
		this.id_vuelo = id_vuelo;
		this.embarque = embarque;
		this.desembarque = desembarque;
		this.sillas_disponibles_business = sillas_disponibles_business;
		this.sillas_disponibles_primera = sillas_disponibles_primera;
		this.sillas_disponibles_economicos = sillas_disponibles_economicos;
		this.check_in = chequeo;
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

	public Date getEmbarque() {
		return embarque;
	}

	public void setEmbarque(Date embarque) {
		this.embarque = embarque;
	}

	public Date getDesembarque() {
		return desembarque;
	}

	public void setDesembarque(Date desembarque) {
		this.desembarque = desembarque;
	}

	public short getSillas_disponibles_business() {
		return sillas_disponibles_business;
	}

	public void setSillas_disponibles_business(short sillas_disponibles_business) {
		this.sillas_disponibles_business = sillas_disponibles_business;
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

	public Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Date chequeo) {
		this.check_in = chequeo;
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

	public Avion getFkaviones() {
		return fkaviones;
	}

	public void setFkaviones(Avion fkaviones) {
		this.fkaviones = fkaviones;
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
				+ ", sillas_disponibles_business=" + sillas_disponibles_business + ", sillas_disponibles_primera="
				+ sillas_disponibles_primera + ", sillas_disponibles_economicos=" + sillas_disponibles_economicos
				+ ", check_in=" + check_in + "]";
	}
	
	
}
