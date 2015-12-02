package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArmadorDeResultado {

	//esto se recontra podria mejorar para que no quede tan feamente implementado
	public List<Resultado> buscarAlternativas(List<Hotel> hotels, ICondicionable ic){

		List<Habitacion> habitaciones;
		ArrayList<Resultado> resultados = new ArrayList<Resultado>();

		for(Hotel hotel : hotels){
			habitaciones = new ArrayList<Habitacion>();
			habitaciones = hotel.filterHabitaciones(ic);
			if(!habitaciones.isEmpty()){
				resultados.add(this.armarResultado(habitaciones));
			}
		}
	return resultados;
	}

	private Resultado armarResultado(List<Habitacion> habitaciones) {
		// TODO Auto-generated method stub
		return new Resultado(habitaciones, habitaciones.get(0).getHotel());
	}
}
