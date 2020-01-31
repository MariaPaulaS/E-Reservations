/**
 * 
 */
package com.mariathecharmix.sd.ereservation.vista.resources.vo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla cliente
 * La anotacion Data de Lombok genera los getters y setters por inercia.
 * @author maria
 *
 */
@Data
public class ClienteVO{
	
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	
	

}
