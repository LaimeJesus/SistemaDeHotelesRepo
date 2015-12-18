package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

/**
 * @author Lucas Fedele, Jesus Laime
 *
 */
public class Usuario {
	
	/**
	 * @see si hubiesemos hecho el codigo en java 1.8 podriamos haber usado un filter o algo parecido para las reservas y no haber
	 * repetido tanto codigo
	 */
	
	private List<Reserva> reservas = new ArrayList<Reserva>();

	/**
	 * @param reserva: es una reserva
	 */
	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	/**
	 * @return las reservas que tiene realizo
	 */
	public List<Reserva> getReservas() {
		return reservas;
	}

	/**
	 * @param reserva: es una reserva
	 */
	public void quitarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}
	
	/**
	 * @param reserva: es una Reserva
	 */
	public void cancelarReserva(Reserva reserva){
		this.quitarReserva(reserva);
		reserva.quitarReserva();
	}
	/**
	 * @param reserva: es una Reserva
	 */
	public void realizarReserva(Reserva reserva){
		this.agregarReserva(reserva);
		reserva.getHabitacion().agregarReserva(reserva);
	}

	/**
	 * @param ciudad: es el nombre de una ciudad
	 * @return las reservas que realizo en una ciudad
	 */
	public List<Reserva> getReservasDeUnaCiudad(String ciudad) {
		List<Reserva> rs = new ArrayList<Reserva>();
		
		for (Reserva r : reservas) {
			if (r.getHabitacion().getHotel().getNombreDeCiudad() == ciudad)
				rs.add(r);
		}
		
		return rs;
	}

	/**
	 * @param dia: es una DateTime
	 * @return las reservas que realizo desde un dia
	 */
	public List<Reserva> getReservasPosterioresA(DateTime dia) {
		List<Reserva> rs = new ArrayList<Reserva>();
		
		for (Reserva r : reservas) {
			if (r.getPeriodo().getFechaInicio().isAfter(dia))
				rs.add(r);
		}
		
		return rs;
	}

	/**
	 * @return un set con el nombre de las ciudades en las que realizo una reserva
	 */
	public Set<String> getCiudadesDondeReservo() {
		Set<String> ciudades = new HashSet<String>();
		
		for (Reserva r : reservas) {
			if (!ciudades.contains(r.getHabitacion().getHotel().getNombreDeCiudad()))
				ciudades.add(r.getHabitacion().getHotel().getNombreDeCiudad());
		}
		
		return ciudades;
	}
	
	/**
	 * @return una lista con las reservas que tiene en la actualidad
	 */
	public List<Reserva> getReservasActuales(){
		ArrayList<Reserva> result = new ArrayList<Reserva>();
		ReadableInstant actual = new DateTime();
		for(Reserva r : reservas){
			if(r.getPeriodo().perteneceAlPeriodo(actual)){
				result.add(r);
			}
		}
		return result;
	}

}
