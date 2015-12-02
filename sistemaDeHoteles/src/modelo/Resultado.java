package modelo;

import java.util.List;

public class Resultado {
	
	private List<Habitacion> habitaciones;
	private Hotel hotel;

	public Resultado(List<Habitacion> habitaciones, Hotel hotel) {
		// TODO Auto-generated constructor stub
		this.setHotel(hotel);
		this.setHabitaciones(habitaciones);
	}

	private void setHabitaciones(List<Habitacion> habitaciones) {
		// TODO Auto-generated method stub
		this.habitaciones = habitaciones;
	}

	public void setHotel(Hotel h){
		this.hotel = h;
	}
	public List<Habitacion> getHabitaciones(){
		return this.habitaciones;
	}
	public Hotel getHotel(){
		return this.hotel;
	}
}
