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
@Table(name = "aviones")
public class Avion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_avion", length = 10)
	private int id_avion;

	@Column(name = "fabricante", nullable = false, length = 20)
	private String fabricante;

	@Column(name = "modelo", nullable = false, length = 20)
	private String modelo;

	@Column(name = "anio_fabricacion", nullable = false, length = 4)
	private int anio_fabricacion;

	@Column(name = "numero_sillas_business", nullable = false, length = 4)
	private short numero_sillas_business;

	@Column(name = "numero_sillas_primera", nullable = false, length = 4)
	private short numero_sillas_primera;

	@Column(name = "numero_sillas_economica", nullable = false, length = 4)
	private short numero_sillas_economica;

	@ManyToOne // (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkestados_avion", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EstadosAvion fkestados_avion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkaviones")
	@JsonIgnore
	private List<Vuelo> vuelos;

	public Avion() {
		super();
	}

	public Avion(int id_avion, String fabricante, String modelo, int año_fabricacion, short numero_sillas_business,
			short numero_sillas_primera, short numero_sillas_economica) {
		super();
		this.id_avion = id_avion;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anio_fabricacion = año_fabricacion;
		this.numero_sillas_business = numero_sillas_business;
		this.numero_sillas_primera = numero_sillas_primera;
		this.numero_sillas_economica = numero_sillas_economica;
	}

	public int getId_avion() {
		return id_avion;
	}

	public void setId_avion(int id_avion) {
		this.id_avion = id_avion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio_fabricacion() {
		return anio_fabricacion;
	}

	public void setAnio_fabricacion(int año_fabricacion) {
		this.anio_fabricacion = año_fabricacion;
	}

	public short getNumero_sillas_business() {
		return numero_sillas_business;
	}

	public void setNumero_sillas_business(short numero_sillas_business) {
		this.numero_sillas_business = numero_sillas_business;
	}

	public short getNumero_sillas_primera() {
		return numero_sillas_primera;
	}

	public void setNumero_sillas_primera(short numero_sillas_primera) {
		this.numero_sillas_primera = numero_sillas_primera;
	}

	public short getNumero_sillas_economica() {
		return numero_sillas_economica;
	}

	public void setNumero_sillas_economica(short numero_sillas_economica) {
		this.numero_sillas_economica = numero_sillas_economica;
	}

	public EstadosAvion getFkestados_avion() {
		return fkestados_avion;
	}

	public void setFkestados_avion(EstadosAvion fkestados_avion) {
		this.fkestados_avion = fkestados_avion;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	@Override
	public String toString() {
		return "Avion [id_avion=" + id_avion + ", fabricante=" + fabricante + ", modelo=" + modelo
				+ ", anio_fabricacion=" + anio_fabricacion + ", numero_sillas_business=" + numero_sillas_business
				+ ", numero_sillas_primera=" + numero_sillas_primera + ", numero_sillas_economica="
				+ numero_sillas_economica + ", fkestados_avion=" + fkestados_avion + "]";
	}
}