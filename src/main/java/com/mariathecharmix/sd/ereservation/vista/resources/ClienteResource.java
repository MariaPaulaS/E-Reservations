/**
 * 
 */
package com.mariathecharmix.sd.ereservation.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mariathecharmix.sd.ereservation.model.Cliente;
import com.mariathecharmix.sd.ereservation.negocio.services.ClienteService;
import com.mariathecharmix.sd.ereservation.vista.resources.vo.ClienteVO;

/**
 * Clase que representa el servicio web de cliente, que expone las operaciones
 * de la clase service
 * 
 * @author maria
 *
 */
@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

	private final ClienteService clienteService;

	// ¿Similitud con Autowired? Inyeccion de dependencias por constructor
	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;

	}

	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVO) {
		Cliente cliente = new Cliente();
		cliente.setNombreCli(clienteVO.getNombreCli());
		cliente.setApellidoCli(clienteVO.getApellidoCli());
		cliente.setDireccionCli(clienteVO.getDireccionCli());
		cliente.setEmailCli(clienteVO.getEmailCli());
		cliente.setIdentificacionCli(clienteVO.getIdentificacionCli());
		cliente.setTelefonoCli(clienteVO.getTelefonoCli());

		return new ResponseEntity<Cliente>(this.clienteService.create(cliente), HttpStatus.CREATED);

	}

	@PutMapping("/{identificacion}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion,
			ClienteVO clienteVO) {
		Cliente cliente = this.clienteService.findbyIdentificacion(identificacion);

		if (cliente == null) {

			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {

			cliente.setNombreCli(clienteVO.getNombreCli());
			cliente.setApellidoCli(clienteVO.getApellidoCli());
			cliente.setDireccionCli(clienteVO.getDireccionCli());
			cliente.setEmailCli(clienteVO.getEmailCli());
			cliente.setIdentificacionCli(clienteVO.getIdentificacionCli());
			cliente.setTelefonoCli(clienteVO.getTelefonoCli());

			return new ResponseEntity<Cliente>(this.clienteService.update(cliente), HttpStatus.OK);

		}

	}

	@DeleteMapping("/{identificacion}")
	public void removeCliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = this.clienteService.findbyIdentificacion(identificacion);

		if (cliente != null) {

			this.clienteService.delete(cliente);
		}
	}
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		
		return ResponseEntity.ok(this.clienteService.findAll());
	}

}
