package test;

import modelo.*;

import java.util.ArrayList;

import junit.framework.TestCase;

public class CondicionDeDestinoTest extends TestCase {


	//esta condicion tiene como objetivo ver si una habitacion pertenece a la ciudad indicada en la condicion
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeDestino(){
		//arrange
		CamaSimple camaSimple = new CamaSimple();
		CamaDoble camaCompleja = new CamaDoble();
		ArrayList<Cama> camas = new ArrayList<Cama>();
		camas.add(camaSimple);
		camas.add(camaCompleja);
		Habitacion habitacion = new Habitacion(camas);
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones.add(habitacion);
		Hotel hotel = new Hotel("Pepe", "Berazategui", habitaciones);
		CondicionDeDestino condicionDeDestino = new CondicionDeDestino("Berazategui");

		//verify
		assertTrue(condicionDeDestino.satisface(habitacion));
	}
}