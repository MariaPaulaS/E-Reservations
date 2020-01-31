package com.mariathecharmix.sd.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class Reserva {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	private String idRe;
	private Date fechaIngresoRes;
	private Date fechaSalidaRes;
	private int cantidadPersonaRes;
	private String descripcionRes;
	
	@ManyToOne
	@JoinColumn(name="idCli") //Llave foranea
	private Cliente cliente;
	
	
}
