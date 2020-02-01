package com.mariathecharmix.sd.ereservation.vista.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mariathecharmix.sd.ereservation.negocio.services.ReservaService;
import com.mariathecharmix.sd.ereservation.vista.resources.vo.ReservaVO;
import com.mariathecharmix.sd.ereservation.model.Cliente;
import com.mariathecharmix.sd.ereservation.model.Reserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/reserva")
@Api(tags = "reserva")
public class ReservaResource {

	private ReservaService reservaService;

	// ¿Similitud con Autowired? Inyeccion de dependencias por constructor
	public ReservaResource(ReservaService reservaService) {
		this.reservaService = reservaService;
	}

	@PostMapping
	@ApiOperation(value = "Crear reserva", notes = "Servicio para crear una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public ResponseEntity<Reserva> createReserva(@RequestBody ReservaVO reservaVO) {

		Reserva reserva = new Reserva();
		reserva.setCodigoRes(reservaVO.getCodigoRes());
		reserva.setDescripcionRes(reservaVO.getCodigoRes());
		reserva.setCantidadPersonaRes(reservaVO.getCantidadPersonaRes());
		reserva.setFechaIngresoRes(reservaVO.getFechaIngresoRes());
		reserva.setFechaSalidaRes(reservaVO.getFechaSalidaRes());

		return new ResponseEntity<Reserva>(this.reservaService.create(reserva), HttpStatus.CREATED);

	}

	@PutMapping("/{codigoReserva}")
	@ApiOperation(value = "Actualizar reserva", notes = "Servicio para actualizar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva actualizada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public ResponseEntity<Reserva> updateReserva(@PathVariable("codigoReserva") String codigoReserva,
			ReservaVO reservaVO) {
		
		Reserva reserva = this.reservaService.findByCodigoRes(codigoReserva);
		
		if(reserva != null) {
			reserva.setCodigoRes(reservaVO.getCodigoRes());
			reserva.setDescripcionRes(reservaVO.getCodigoRes());
			reserva.setCantidadPersonaRes(reservaVO.getCantidadPersonaRes());
			reserva.setFechaIngresoRes(reservaVO.getFechaIngresoRes());
			reserva.setFechaSalidaRes(reservaVO.getFechaSalidaRes());
			
			return new ResponseEntity<Reserva>(this.reservaService.update(reserva), HttpStatus.CREATED);

		}
		
		else {
			
			return new ResponseEntity<Reserva>(HttpStatus.NOT_FOUND);
			
		}

	}
	
	
	@DeleteMapping("/{codigoReserva}")
	@ApiOperation(value = "Eliminar reserva", notes = "Servicio para eliminar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva eliminada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public void removeReserva(@PathVariable("codigoReserva") String codigoReserva,
			ReservaVO reservaVO) {
		
		Reserva reserva = this.reservaService.findByCodigoRes(codigoReserva);
		
		if(reserva != null) {
			
			this.reservaService.delete(reserva);
		}
		
	}
	
	
	
	

}
