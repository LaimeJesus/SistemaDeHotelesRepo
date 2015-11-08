package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArmadorDeResultado {

	//esto se recontra podria mejorar para que no quede tan feamente implementado
	public List<Resultado> buscarAlternativas(List<Hotel> hotels, ICondicionable ic){
		ArrayList<Resultado> resultado = new ArrayList<Resultado>();
		for(Hotel h : hotels){
			ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
			for(Habitacion hab : h.getHabitaciones()){
				if(ic.satisface(hab)){
					habitaciones.add(hab);
				}
			}
			if(!habitaciones.isEmpty()){
				Resultado r = new Resultado(habitaciones);
				r.setHotel(habitaciones.get(0).getHotel());
				resultado.add(r);
			}
		}
	return resultado;
	}
}
