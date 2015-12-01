package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import modelo.Reserva;

public class Usuario {
	
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void quitarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}

	public List<Reserva> getReservas(String ciudad) {
		List<Reserva> rs = new ArrayList<Reserva>();
		
		for (Reserva r : reservas) {
			if (r.getHabitacion().getHotel().getNombreDeCiudad() == ciudad)
				rs.add(r);
		}
		
		return rs;
	}

	public List<Reserva> getReservasPosterioresA(DateTime dia) {
		List<Reserva> rs = new ArrayList<Reserva>();
		
		for (Reserva r : reservas) {
			if (r.getPeriodo().getFechaInicio().isAfter(dia))
				rs.add(r);
		}
		
		return rs;
	}

	public Set<String> getCiudadesDondeReservo() {
		Set<String> ciudades = new HashSet<String>();
		
		for (Reserva r : reservas) {
			if (!ciudades.contains(r.getHabitacion().getHotel().getNombreDeCiudad()))
				ciudades.add(r.getHabitacion().getHotel().getNombreDeCiudad());
		}
		
		return ciudades;
	}

}
