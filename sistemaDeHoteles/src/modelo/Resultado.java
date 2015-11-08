package modelo;

import java.util.List;

public class Resultado {
	
	private List<Habitacion> habitaciones;
	private Hotel hotel;

	public Resultado(List<Habitacion> habitaciones){
		this.habitaciones = habitaciones;
		this.hotel = null;
	}
	
	public void setHotel(Hotel h){
		this.hotel = h;
	}
	public Hotel getHotel(){
		return this.hotel;
	}
	public List<Habitacion> getHabitaciones(){
		return this.habitaciones;
	}
	public void addHabitacion(Habitacion h){
		this.getHabitaciones().add(h);
	}

}
