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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de cliente, que expone las operaciones
 * de la clase service
 * 
 * @author maria
 *
 */
@RestController
@RequestMapping("/api/cliente")
@Api(tags="cliente")
public class ClienteResource {

	private final ClienteService clienteService;

	// ¿Similitud con Autowired? Inyeccion de dependencias por constructor
	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;

	}

	@PostMapping
	@ApiOperation(value="Crear cliente", notes="Servicio para crear un cliente")
	@ApiResponses(value= {@ApiResponse(code=201, message="Cliente creado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")})
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
	@ApiOperation(value="Actualizar cliente", notes="Servicio para actualizar un cliente")
	@ApiResponses(value= {@ApiResponse(code=201, message="Cliente actualizado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")})
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
	@ApiOperation(value="Eliminar cliente", notes="Servicio para eliminar un cliente")
	@ApiResponses(value= {@ApiResponse(code=201, message="Cliente eliminado correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")})
	public void removeCliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = this.clienteService.findbyIdentificacion(identificacion);

		if (cliente != null) {

			this.clienteService.delete(cliente);
		}
	}
	
	
	@GetMapping
	@ApiOperation(value="Consultar clientes", notes="Servicio para consultar todos los clientes")
	@ApiResponses(value= {@ApiResponse(code=201, message="Clientes consultados correctamente"),
			@ApiResponse(code=400, message="Solicitud inválida")})
	public ResponseEntity<List<Cliente>> findAll(){
		
		return ResponseEntity.ok(this.clienteService.findAll());
	}

}
