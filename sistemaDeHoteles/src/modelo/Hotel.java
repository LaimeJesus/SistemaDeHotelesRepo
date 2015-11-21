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
	
	private void setHabitaciones(List<Habitacion> habitaciones) {
		// TODO Auto-generated method stub
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

	public List<Habitacion> filterHabitaciones(ICondicionable ic) {
		ArrayList<Habitacion> habs = new ArrayList<Habitacion>();
		for(Habitacion h : this.getHabitaciones()){
			if(ic.satisface(h)){
				habs.add(h);
			}
		}
		return habs;
	}

}
