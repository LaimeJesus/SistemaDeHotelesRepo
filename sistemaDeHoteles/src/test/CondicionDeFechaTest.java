package test;
import modelo.*;
import org.mockito.Mockito;

import junit.framework.TestCase;


public class CondicionDeFechaTest extends TestCase {

	//esta condicion tiene como objetivo ver si una habitacion esta disponible entre un periodo
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeFecha(){
		//arrange
		Periodo periodo = null;
		CondicionDeFecha sut = new CondicionDeFecha(periodo);

		//este mock es para ver que una habitacion envie el mensaje estadisponible con periodo como argumento
		Habitacion mockHabitacion = Mockito.mock(Habitacion.class);

		//verify
		sut.satisface(mockHabitacion);
		Mockito.verify(mockHabitacion).estaDisponible(periodo);
	}
}