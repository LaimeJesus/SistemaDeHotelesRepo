package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hotel {

	public String ciudad;
	public Collection<Habitacion> habitaciones;
	public String name;
	public Integer cantidadDeHuespedes;
	
	public Hotel(String name, String ciudad, List<Habitacion> list){
		this.ciudad = ciudad;
		this.habitaciones = list;
		this.name = name;
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

	public void agregarHabitacion(Habitacion hab) {
		// TODO Auto-generated method stub
		this.getHabitaciones().add(hab);
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
