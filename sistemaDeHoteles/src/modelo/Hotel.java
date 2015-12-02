package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hotel {

	public String ciudad;
	public Collection<Habitacion> habitaciones;
	public String name;
	
	public Hotel(String name, String ciudad, List<Habitacion> habitaciones){
		this.ciudad = ciudad;
		this.setHabitaciones(habitaciones);
		this.name = name;
	}
	
	//este metodo es para evitar el problema del conocimiento mutuo entre un hotel y sus habitaciones
	private void setHabitaciones(List<Habitacion> habitaciones) {
		for(Habitacion h : habitaciones){
			h.setHotel(this);
		}
		this.habitaciones = habitaciones;
	}

	public String getNombreDeCiudad(){
		return this.ciudad;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Collection<Habitacion> getHabitaciones(){
		return this.habitaciones;
	}

	//dada una condicion ic devuelve una lista de habitaciones que cumplan con esa condicion
	public List<Habitacion> filterHabitaciones(ICondicionable condicion) {
		ArrayList<Habitacion> habitacionesFiltradas = new ArrayList<Habitacion>();
		for(Habitacion habitacion : this.getHabitaciones()){
			if(condicion.satisface(habitacion)){
				habitacionesFiltradas.add(habitacion);
			}
		}
		return habitacionesFiltradas;
	}

}
