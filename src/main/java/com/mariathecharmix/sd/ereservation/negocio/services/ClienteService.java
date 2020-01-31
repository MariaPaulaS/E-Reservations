/**
 * 
 */
package com.mariathecharmix.sd.ereservation.negocio.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mariathecharmix.sd.ereservation.model.Cliente;
import com.mariathecharmix.sd.ereservation.negocio.repository.ClienteRepository;

/**
 * Clase para definir los servicios de Cliente
 * 
 * @author maria
 *
 */

@Service
@Transactional(readOnly = true)
public class ClienteService {

	private final ClienteRepository clienteRepository;

	// ¿Similitud con Autowired? Inyeccion de dependencias por constructor
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	/**
	 * Método para realizar la operacion de crear un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Metodo para realizar la operacion de eliminar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Metodo para realizar la operacion de eliminar un cliente
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	/**
	 * Metodo que encuentra a un cliente por su identificacion
	 * 
	 * @param identificacionCli
	 * @return
	 
	*/
	public Cliente findbyIdentificacion(String identificacionCli) {
		return this.clienteRepository.findByIdentificacion(identificacionCli);

	}

}
