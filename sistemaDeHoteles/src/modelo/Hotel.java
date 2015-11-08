package modelo;

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
		this.cantidadDeHuespedes = 0;
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

}
