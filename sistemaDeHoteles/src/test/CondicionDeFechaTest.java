package test;
import modelo.*;
import org.mockito.Mockito;

import junit.framework.TestCase;


public class CondicionDeFechaTest extends TestCase {

	//esta condicion tiene como objetivo ver si una habitacion esta disponible entre un periodo
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeFecha(){
		//arrange
		Periodo condicion_de_periodo = null;
		CondicionDeFecha condicionDeFecha = new CondicionDeFecha(condicion_de_periodo);

		//este mock es para ver que una habitacion envie el mensaje estadisponible con periodoo como argumento
		Habitacion mockHabitacion = Mockito.mock(Habitacion.class);

		//verify
		condicionDeFecha.satisface(mockHabitacion);
		Mockito.verify(mockHabitacion).estaDisponible(condicion_de_periodo);
	}
}