package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArmadorDeResultado {

	//esto se recontra podria mejorar para que no quede tan feamente implementado
	public List<Resultado> buscarAlternativas(List<Hotel> hotels, ICondicionable ic){
		ArrayList<Resultado> resultados = new ArrayList<Resultado>();
		for(Hotel h : hotels){
			List<Habitacion> habitaciones = new ArrayList<Habitacion>();
			habitaciones = h.filterHabitaciones(ic);
			//se podria separar
			if(!habitaciones.isEmpty()){
				Resultado r = new Resultado(habitaciones, habitaciones.get(0).getHotel());
				resultados.add(r);
			}
		}
	return resultados;
	}
}
