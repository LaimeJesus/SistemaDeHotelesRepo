package test;
import modelo.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

public class CondicionDeNombreTest extends TestCase {


	//esta condicion tiene como objetivo ver si una habitacion pertenece a la ciudad indicada en la condicion
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeNombre(){
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
		CondicionDeNombre condicionDeNombre = new CondicionDeNombre("Pepe");

		//verify
		assertTrue(condicionDeNombre.satisface(habitacion));
	}
}