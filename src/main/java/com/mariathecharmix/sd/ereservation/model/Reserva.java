package com.mariathecharmix.sd.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla reserva
 * @author maria
 *
 */
@Data
@Entity
@Table(name="reserva")
@NamedQuery(name="Reserva.findByCodigoReserva", query="Select r from Reserva r where r.codigoRes = ?1")
public class Reserva {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	private String idRes;
	private String codigoRes;
	
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	private int cantidadPersonaRes;
	private String descripcionRes;
	
	@ManyToOne
	@JoinColumn(name="idCli") //Llave foranea
	private Cliente cliente;
	
	
}
