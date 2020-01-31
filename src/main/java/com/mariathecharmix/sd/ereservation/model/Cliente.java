/**
 * 
 */
package com.mariathecharmix.sd.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla cliente
 * La anotacion Data de Lombok genera los getters y setters por inercia.
 * @author maria
 *
 */
@Data
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findbyIdentificacion", query="Select c from Cliente where c.identificacionCli = ?1")
public class Cliente {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	
	@OneToMany(mappedBy="cliente")
	private Set<Reserva> reservas;
	
	public Cliente() {
	
	}
	
	

}
