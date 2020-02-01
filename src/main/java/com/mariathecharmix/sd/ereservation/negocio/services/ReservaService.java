package com.mariathecharmix.sd.ereservation.negocio.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mariathecharmix.sd.ereservation.model.Cliente;
import com.mariathecharmix.sd.ereservation.model.Reserva;
import com.mariathecharmix.sd.ereservation.negocio.repository.ReservaRepository;

@Service
@Transactional(readOnly = true)
public class ReservaService {

	
	private ReservaRepository reservaRepository;
	
	// ¿Similitud con Autowired? Inyeccion de dependencias por constructor
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	@Transactional
	public Reserva create(Reserva reserva) {
		
		return this.reservaRepository.save(reserva);
		
	}
	
	@Transactional
	public Reserva update(Reserva reserva) {
		return this.reservaRepository.save(reserva);

	}
	
	@Transactional
	public void delete(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}
	
	/**
	 * Método que encuentra una reserva por su código
	 * @param codigoReserva
	 * @return
	 */
	public Reserva findByCodigoRes(String codigoReserva) {
		return this.reservaRepository.findByCodigoRes(codigoReserva);
	}
	

	/**
	 * Método para consultar las reservas por la fecha de ingreso en
	 * base a un rango de fechas
	 * 
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	public List<Reserva> find(Date fechaInicio, Date fechaSalida){
		return this.reservaRepository.find(fechaInicio, fechaSalida);
	}
	
	/**
	 * Método para consultar las reservas por un cliente en específico
	 * 
	 * @param cliente
	 * @return
	 */
	public List<Reserva> findByCliente(Cliente cliente){
		return this.reservaRepository.findByCliente(cliente);
	}
	
}
