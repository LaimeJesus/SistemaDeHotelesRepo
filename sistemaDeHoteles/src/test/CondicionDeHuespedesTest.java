package test;

import java.util.ArrayList;

import junit.framework.TestCase;
import modelo.*;

public class CondicionDeHuespedesTest extends TestCase {

	//esta condicion tiene como objetivo ver si una habitacion pertenece a la ciudad indicada en la condicion
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeHuespedes(){
		//arrange
		CamaSimple camaSimple = new CamaSimple();
		CamaDoble camaCompleja = new CamaDoble();
		ArrayList<Cama> camas = new ArrayList<Cama>();
		camas.add(camaSimple);
		camas.add(camaCompleja);
		Habitacion habitacion = new Habitacion(camas);
		CondicionDeHuespedes condicionDeHuespedes = new CondicionDeHuespedes(3);

		//verify
		assertTrue(condicionDeHuespedes.satisface(habitacion));
	}
}