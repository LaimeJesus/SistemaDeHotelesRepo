package modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

/**
 * @author Lucas Fedele, Jesus Laime
 *
 */
public class Hotelero {
	
	private ArrayList<Hotel> hoteles = new ArrayList<Hotel>();

	/**
	 * @param hotel: es un hotel
	 */
	public void addHotel(Hotel hotel) {
		hoteles.add(hotel);
	}

	/**
	 * @return mis hoteles
	 */
	public List<Hotel> getHoteles() {
		return hoteles;
	}

	/**
	 * @return las reservas que tienen sus hoteles
	 */
	public List<Reserva> getReservasActuales() {
		ArrayList<Reserva> rs = new ArrayList<Reserva>();
		
		for (Hotel h : hoteles) {
			rs.addAll(h.getReservas());
		}
		
		return rs;
	}

	/**
	 * @param dias: es un numero
	 * @return las reservas que estan entre el dia de actual y los siguientes N dias
	 */
	public List<Reserva> getReservasDentroDeNDias(Integer dias) {
		ArrayList<Reserva> rs = new ArrayList<Reserva>();
		
		for (Reserva r : this.getReservasActuales()) {
			if (r.getPeriodo().getFechaInicio().isAfter(hoyMasNDias(dias)))
				rs.add(r);
		}
		
		return rs;
	}

	/**
	 * @param dias: es un numero
	 * @return la fecha actual sumado N dias
	 */
	private ReadableInstant hoyMasNDias(Integer dias) {
		DateTime dt = new DateTime();
		return dt.now().plusDays(dias);
	}

}
