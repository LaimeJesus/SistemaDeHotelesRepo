package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hotel: representa la abstraccion de un hotel en nuestro sistema de reservas y busqueda de hoteles.
 * Para eso esta sabe su nombre, la ciudad en la que se encuentra, y las habitaciones que tiene
 * @author Jesus Laime 
 *
 */
public class Hotel {

	private String ciudad;
	private List<Habitacion> habitaciones;
	private String name;
	private List<Servicio> servicios;
	
	
	/**
	 * @param name: es un string
	 * @param ciudad: es un string
	 * @param habitaciones: es una lista de habitaciones
	 */
	public Hotel(String name, String ciudad, List<Habitacion> habitaciones){
		this.ciudad = ciudad;
		this.setHabitaciones(habitaciones);
		this.name = name;
		this.servicios = new ArrayList<Servicio>();
	}
	
	/**
	 * @param habitaciones: es una lista de habitaciones
	 * Objetivo: evitar el problema del conocimiento mutuo entre un hotel y sus habitaciones
	 */
	private void setHabitaciones(List<Habitacion> habitaciones) {
		for(Habitacion habitacion : habitaciones){
			habitacion.setHotel(this);
		}
		this.habitaciones = habitaciones;
	}

	/**
	 * @return: el nombre de la ciudad en la cual esta el hotel
	 */
	public String getNombreDeCiudad(){
		return this.ciudad;
	}
	
	/**
	 * @return: el nombre del hotel
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * @return: las habitaciones del hotel
	 */
	public List<Habitacion> getHabitaciones(){
		return this.habitaciones;
	}

	//dada una condicion ic devuelve una lista de habitaciones que cumplan con esa condicion
	/**
	 * @param condicion: puede ser una condicion simple o compuesta
	 * @return una lista de habitaciones que cumplen con una condicion
	 */
	public List<Habitacion> filterHabitaciones(Condicion condicion) {
		ArrayList<Habitacion> habitacionesFiltradas = new ArrayList<Habitacion>();
		
		for(Habitacion habitacion : this.getHabitaciones()){
			
			if(condicion.satisface(habitacion)){
				habitacionesFiltradas.add(habitacion);
			}
		}
		return habitacionesFiltradas;
	}

	/**
	 * @return las reservas actuales en este hotel
	 */
	public List<Reserva> getReservas() {
		ArrayList<Reserva> result = new ArrayList<Reserva>();
		for (Habitacion hab : this.getHabitaciones()) {
			result.addAll(hab.getReservas());
		}
		return result;
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

	public boolean tieneServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return this.getServicios().contains(servicio);
	}

}
