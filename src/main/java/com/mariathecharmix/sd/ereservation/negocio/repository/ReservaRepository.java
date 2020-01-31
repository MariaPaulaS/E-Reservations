/**
 * 
 */
package com.mariathecharmix.sd.ereservation.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mariathecharmix.sd.ereservation.model.Reserva;
/**
 * @author maria
 *
 */
public interface ReservaRepository extends JpaRepository<Reserva, String>{
	
	@Query("Select r from Reserva r where r.fechaIngresoR =:fechaInicio and r.fechaSalidaR =:fechaSalidaS")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida") Date fechaSalida);

}
