/**
 * 
 */
package com.mariathecharmix.sd.ereservation.model;

import lombok.Data;

/**
 * Clase que representa la tabla cliente
 * La anotacion Data de Lombok genera los getters y setters por inercia.
 * @author maria
 *
 */
@Data
public class Cliente {
	
	private String nombreCli;
	private String apellidoCli;
	
	public Cliente() {
	
	}
	
	

}
