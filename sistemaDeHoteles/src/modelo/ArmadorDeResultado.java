package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArmadorDeResultado {

	//esto se recontra podria mejorar para que no quede tan feamente implementado
	public List<Resultado> buscarAlternativas(List<Hotel> hotels, Condicion condicion){

		List<Habitacion> habitaciones;
		ArrayList<Resultado> resultados = new ArrayList<Resultado>();

		for(Hotel hotel : hotels){

			habitaciones = hotel.filterHabitaciones(condicion);
			
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
