package modelo;

import java.util.List;

/**
 * @author Jesus Laime, Lucas Fedele
 *
 */
public class Resultado {
	
	
	private List<Habitacion> habitaciones;
	private Hotel hotel;

	/**
	 * @param habitaciones: una lista de Habitacion
	 * @param hotel: un Hotel
	 */
	public Resultado(List<Habitacion> habitaciones, Hotel hotel) {
		// TODO Auto-generated constructor stub
		this.setHotel(hotel);
		this.setHabitaciones(habitaciones);
	}

	/**
	 * @param habitaciones: una lista de habitacion
	 */
	private void setHabitaciones(List<Habitacion> habitaciones) {
		// TODO Auto-generated method stub
		this.habitaciones = habitaciones;
	}

	/**
	 * @param hotel: es un Hotel
	 */
	public void setHotel(Hotel hotel){
		this.hotel = hotel;
	}
	/**
	 * @return la lista de Habitacion de este resultado
	 */
	public List<Habitacion> getHabitaciones(){
		return this.habitaciones;
	}
	/**
	 * @return el hotel en el que se encuentran las habitaciones del resultado
	 */
	public Hotel getHotel(){
		return this.hotel;
	}
}
