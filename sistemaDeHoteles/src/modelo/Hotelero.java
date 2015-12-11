package modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

public class Hotelero {

	private ArrayList<Hotel> hoteles = new ArrayList<Hotel>();

	public void addHotel(Hotel hotel) {
		hoteles.add(hotel);
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public List<Reserva> getReservasActuales() {
		ArrayList<Reserva> rs = new ArrayList<Reserva>();
		
		for (Hotel h : hoteles) {
			for (Habitacion hab : h.getHabitaciones()) {
				rs.addAll(hab.getReservas());
			}
		}
		
		return rs;
	}

	public List<Reserva> getReservasDentroDeNDias(Integer dias) {
		ArrayList<Reserva> rs = new ArrayList<Reserva>();
		
		for (Reserva r : this.getReservasActuales()) {
			if (r.getPeriodo().getFechaInicio().isAfter(hoyMasNDias(dias)))
				rs.add(r);
		}
		
		return rs;
	}

	private ReadableInstant hoyMasNDias(Integer dias) {
		DateTime dt = new DateTime();
		return dt.now().plusDays(dias);
	}

}
