/**
 * 
 */
package com.mariathecharmix.sd.ereservation.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mariathecharmix.sd.ereservation.model.Cliente;
import com.mariathecharmix.sd.ereservation.model.Reserva;
/**
 * @author maria
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, String>{
	
	/**
	 * Encontrar reservas de un cliente
	 * @param cliente
	 * @return
	 */
	@Query("Select r from Reserva r where r.cliente =: cliente")
	public List<Reserva> findByCliente(Cliente cliente); 
	
	
	/**
	 * Encontrar reserva por medio de la fecha de inicio y de salida
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	@Query("Select r from Reserva r where r.fechaIngresoRes =:fechaInicio and r.fechaSalidaRes =:fechaSalida")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);

	
	/**
	 * Definición de método para buscar una reserva por su código
	 * @param codigoReserva
	 * @return
	 */
	public Reserva findByCodigoRes(String codigoReserva);
	
}
