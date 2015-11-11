package modelo;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Habitacion {
	
	private Hotel hotel;
	private Integer limiteHuespedes;
	private Integer precioBase;
	private ArrayList<IModificadorDePrecio> modificadores = new ArrayList<IModificadorDePrecio>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	public Habitacion(Hotel h, Integer limiteHuespedes){
		this.setHotel(h);
		this.setLimiteHuespedes(limiteHuespedes);
	}

	private void setLimiteHuespedes(Integer limiteHuespedes) {
		// TODO Auto-generated method stub
		this.limiteHuespedes = limiteHuespedes;
	}

	private void setHotel(Hotel h) {
		this.hotel = h;
	}

	public String getHotelName() {
		return this.getHotel().getName();
	}
	
	public String getHotelNombreDeCiudad(){
		return this.getHotel().getNombreDeCiudad();
	}

	public Hotel getHotel() {
		// TODO Auto-generated method stub
		return this.hotel;
	}
	
	/*
	 * dice si esta disponible en un periodo
	 */
	public Boolean estaDisponible(Periodo periodo) {
		Boolean d = true;
		
		for (Reserva r : reservas) {
			d = d && !r.getPeriodo().coincideCon(periodo);
		}
		
		return d;
	}
	
	public Integer getLimiteDeHuespedes() {
		// TODO Auto-generated method stub
		return this.limiteHuespedes;
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

}
