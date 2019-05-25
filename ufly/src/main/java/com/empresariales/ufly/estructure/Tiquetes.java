package com.empresariales.ufly.estructure;

import java.io.Serializable;

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
@Table(name = "tiquetes")
public class Tiquetes implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tiquete", length = 10)
	private int id_tiquete;
	
	@Column(name = "precio_tiquete", nullable = false, length = 7)
	private int precio_tiquete;
	
	@Column(name = "numero_asientos", nullable = false, length = 2)
	private short numero_asientos;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkvuelos", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Vuelo fkvuelos;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fktipos_tiquete", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TipoTiquete fktipos_tiquete;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkestado_tiquete", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EstadosTiquete fkestado_tiquete;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkusuarios", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuarios fkusuarios;
	
	@ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fkpasajeros", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Pasajeros fkpasajeros;

	public Tiquetes() {
		super();
	}

	public Tiquetes(int id_tiquete, int precio_tiquete, short numero_asientos, Vuelo fkvuelos,
			TipoTiquete fktipos_tiquete, EstadosTiquete fkestado_tiquete, Usuarios fkusuarios, Pasajeros fkpasajeros) {
		super();
		this.id_tiquete = id_tiquete;
		this.precio_tiquete = precio_tiquete;
		this.numero_asientos = numero_asientos;
		this.fkvuelos = fkvuelos;
		this.fktipos_tiquete = fktipos_tiquete;
		this.fkestado_tiquete = fkestado_tiquete;
		this.fkusuarios = fkusuarios;
		this.fkpasajeros = fkpasajeros;
	}

	public int getId_tiquete() {
		return id_tiquete;
	}

	public void setId_tiquete(int id_tiquete) {
		this.id_tiquete = id_tiquete;
	}

	public int getPrecio_tiquete() {
		return precio_tiquete;
	}

	public void setPrecio_tiquete(int precio_tiquete) {
		this.precio_tiquete = precio_tiquete;
	}

	public short getNumero_asientos() {
		return numero_asientos;
	}

	public void setNumero_asientos(short numero_asientos) {
		this.numero_asientos = numero_asientos;
	}

	public Vuelo getFkvuelos() {
		return fkvuelos;
	}

	public void setFkvuelos(Vuelo fkvuelos) {
		this.fkvuelos = fkvuelos;
	}

	public TipoTiquete getFktipos_tiquete() {
		return fktipos_tiquete;
	}

	public void setFktipos_tiquete(TipoTiquete fktipos_tiquete) {
		this.fktipos_tiquete = fktipos_tiquete;
	}

	public EstadosTiquete getFkestado_tiquete() {
		return fkestado_tiquete;
	}

	public void setFkestado_tiquete(EstadosTiquete fkestado_tiquete) {
		this.fkestado_tiquete = fkestado_tiquete;
	}

	public Usuarios getFkusuarios() {
		return fkusuarios;
	}

	public void setFkusuarios(Usuarios fkusuarios) {
		this.fkusuarios = fkusuarios;
	}

	public Pasajeros getFkpasajeros() {
		return fkpasajeros;
	}

	public void setFkpasajeros(Pasajeros fkpasajeros) {
		this.fkpasajeros = fkpasajeros;
	}

	@Override
	public String toString() {
		return "Tiquetes [id_tiquete=" + id_tiquete + ", precio_tiquete=" + precio_tiquete + ", numero_asientos="
				+ numero_asientos + ", fkvuelos=" + fkvuelos + ", fktipos_tiquete=" + fktipos_tiquete
				+ ", fkestado_tiquete=" + fkestado_tiquete + ", fkusuarios=" + fkusuarios + ", fkpasajeros="
				+ fkpasajeros + "]";
	}
	
	
	
}
