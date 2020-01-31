/**
 * 
 */
package com.mariathecharmix.sd.ereservation.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariathecharmix.sd.ereservation.model.Cliente;

/**
 * Interface para definir las operaciones de la base de datos relacionadas con el cliente.
 * @author maria
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{


	/**
	 * Definicion de metodo para buscar los clientes por su apellido
	 * Con la clase JpaRepository
	 * @param apellidoCli
	 * @return
	 */
	public List<Cliente> findByApellidoCli(String apellidoCli);
	
	/**
	 * Definicion de metodo para buscar un cliente por su identificacion
	 * Con NamedQuery
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCli);
}
