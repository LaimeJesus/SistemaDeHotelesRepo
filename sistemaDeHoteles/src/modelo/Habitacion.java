package modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

/**
 * @author Jesus Laime, Lucas Fedele
 *
 */
public class Habitacion {
	
	private Hotel hotel;
	private Integer precioBase;
	private List<IModificadorDePrecio> modificadores;
	private List<Reserva> reservas;
	private List<Cama> camas;
	private List<Servicio> servicios;
	
	/**
	 * @param camas: es una lista de Cama
	 */
	public Habitacion(List<Cama> camas) {
		// TODO Auto-generated constructor stub
		this.setCamas(camas);
		this.modificadores = new ArrayList<IModificadorDePrecio>();
		this.reservas = new ArrayList<Reserva>();
		this.servicios = new ArrayList<Servicio>();
	}

	/**
	 * @param camas: es una Lista de Cama
	 */
	private void setCamas(List<Cama> camas) {
		// TODO Auto-generated method stub
		this.camas = camas;
	}

	/**
	 * @param hotel: es un Hotel
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return el nombre del hotel al que pertenece esta habitacion
	 */
	public String getHotelName() {
		return this.getHotel().getName();
	}
	
	/**
	 * @return el nombre del hotel al que pertenece esta habitacion
	 */
	public String getHotelNombreDeCiudad(){
		return this.getHotel().getNombreDeCiudad();
	}

	/**
	 * @return el hotel al que pertenece esta habitacion
	 */
	public Hotel getHotel(){
		return this.hotel;
	}

	/**
	 * @param periodo: es un Periodo
	 * @return dice si esta disponible en un periodo
	 */
	public Boolean estaDisponible(Periodo periodo) {
		Boolean d = true;
		
		for (Reserva r : this.reservas) {
			d = d && !(r.getPeriodo().coincideCon(periodo));
		}
		
		return d;
	}
	
	/**
	 * @return el numero maximo de huespedes que pueden entrar en esta habitacion
	 */
	public Integer getLimiteDeHuespedes() {
		int res = 0;
		for(Cama c : this.getCamas()){
			res += c.cantidadOcupantes();
		}
		return res;
	}

	/**
	 * @return las camas en esta habitacion
	 */
	private List<Cama> getCamas() {
		// TODO Auto-generated method stub
		return this.camas;
	}

	/*
	 * dice el precio en una fecha d
	 */
	/**
	 * @param d: es una DateTime
	 * @return el precio que cuesta esta habitacion en la fecha d
	 */
	public Integer getPrecioEn(DateTime d) {
		Integer precio = precioBase;
		
		for (IModificadorDePrecio m : modificadores) {
			precio = precio + m.getModificacion(d);
		}
		
		return precio;
	}

	/**
	 * @param precioBase: precioBase por noche de la habitacion, es un integer
	 */
	public void setPrecioBase(Integer precioBase) {
		this.precioBase = precioBase;
	}


	/**
	 * agrega una modificacion a las modificaciones de precio
	 * @param modificacion: es un IModificadorDePrecio
	 */
	public void agregarModificacion(IModificadorDePrecio modificacion) {
		modificadores.add(modificacion);
	}

	/**
	 * agrega una reserva
	 * @param reserva: es una Reserva
	 */
	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	/**
	 * quita una reserva de la habitacion
	 * @param reserva: es una Reserva
	 */
	public void quitarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}

	/**
	 * @return las reservas en esta habitacion
	 */
	public List<Reserva> getReservas() {
		// TODO Auto-generated method stub
		return this.reservas;
	}

	public void agregarServicio(Servicio s){
		this.servicios.add(s);
	}
	public void quitarServicio(Servicio s){
		this.servicios.remove(s);
	}
	
	public List<Servicio> getServicios(){
		return this.servicios;
	}
	
	public Integer costoDeServicios(){
		Integer res = 0;
		for(Servicio s: this.getServicios()){
			res += s.getPrecio();
		}
		return res;
	}

	public boolean verHotelTieneServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return this.hotel.tieneServicio(servicio);
	}
	
}
