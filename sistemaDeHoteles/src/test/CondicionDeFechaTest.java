package test;
import modelo.*;
import java.util.ArrayList;
import org.joda.time.DateTime;

import junit.framework.TestCase;


public class CondicionDeFechaTest extends TestCase {

	//esta condicion tiene como objetivo ver si una habitacion esta disponible entre un periodo
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeFecha(){
		//arrange
		CamaSimple camaSimple = new CamaSimple();
		CamaDoble camaCompleja = new CamaDoble();
		ArrayList<Cama> camas = new ArrayList<Cama>();
		camas.add(camaSimple);
		camas.add(camaCompleja);
		Habitacion habitacion = new Habitacion(camas);
		DateTime f1 = new DateTime(2010, 10, 15, 1 ,1);
		DateTime f2 = new DateTime(2011, 1, 1, 1, 1);
		Periodo periodo = new Periodo(f1,f2);
		CondicionDeFecha condicionDeFecha = new CondicionDeFecha(periodo);
		//verify
		assertTrue(condicionDeFecha.satisface(habitacion));
	}
}