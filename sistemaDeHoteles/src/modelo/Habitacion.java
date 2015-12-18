package modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Habitacion {
	
	private Hotel hotel;
	private Integer precioBase;
	private ArrayList<IModificadorDePrecio> modificadores;
	private ArrayList<Reserva> reservas;
	private List<Cama> camas;
	
	public Habitacion(List<Cama> camas) {
		// TODO Auto-generated constructor stub
		this.setCamas(camas);
		this.modificadores = new ArrayList<IModificadorDePrecio>();
		this.reservas = new ArrayList<Reserva>();
	}

	private void setCamas(List<Cama> camas) {
		// TODO Auto-generated method stub
		this.camas = camas;
	}

	public void setHotel(Hotel h) {
		this.hotel = h;
	}

	public String getHotelName() {
		return this.getHotel().getName();
	}
	
	public String getHotelNombreDeCiudad(){
		return this.getHotel().getNombreDeCiudad();
	}

	public Hotel getHotel() {
		return this.hotel;
	}
	
	/*
	 * dice si esta disponible en un periodo
	 */
	public Boolean estaDisponible(Periodo periodo) {
		Boolean d = true;
		
		for (Reserva r : this.reservas) {
			d = d && !(r.getPeriodo().coincideCon(periodo));
		}
		
		return d;
	}
	
	public Integer getLimiteDeHuespedes() {
		int res = 0;
		for(Cama c : this.getCamas()){
			res += c.cantidadOcupantes();
		}
		return res;
	}

	private List<Cama> getCamas() {
		// TODO Auto-generated method stub
		return this.camas;
	}

	/*
	 * dice el precio en una fecha d
	 */
	public Integer getPrecioEn(DateTime d) {
		Integer precio = precioBase;
		
		for (IModificadorDePrecio m : modificadores) {
			precio = precio + m.getModificacion(d);
		}
		
		return precio;
	}

	/*
	 * setea el precioBase por noche de la habitacion
	 */
	public void setPrecioBase(Integer precioBase) {
		this.precioBase = precioBase;
	}

	/*
	 * agrega una modificacion a las modificaciones de precio
	 */
	public void agregarModificacion(IModificadorDePrecio modificacion) {
		modificadores.add(modificacion);
	}

	/*
	 * agrega una reserva
	 */
	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	/*
	 * quita una reserva de la habitacion
	 */
	public void quitarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}

	public List<Reserva> getReservas() {
		// TODO Auto-generated method stub
		return this.reservas;
	}

}
