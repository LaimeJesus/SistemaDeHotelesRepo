package test;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import junit.framework.TestCase;
import modelo.*;

public class CondicionDeHuespedesTest extends TestCase {

	CondicionDeHuespedes condicionDeHuespedes;
	Habitacion mockHabitacion;
	
	//La condicion de huespedes tiene como objetivo ver si una habitacion tiene una cantidad de huespedes especifica
	public void setUp(){
		condicionDeHuespedes = new CondicionDeHuespedes(3);
		mockHabitacion = Mockito.mock(Habitacion.class);
	}
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeHuespedes(){
		//arrange
		//esto mock es para ver que una habitacion use el metodo getCantidadDeHuespedes y que su valor sea expected
		Integer expected = 3;
		Mockito.when(mockHabitacion.getLimiteDeHuespedes()).thenReturn(expected);
		
		//verify
		assertTrue(condicionDeHuespedes.satisface(mockHabitacion));
	}
	
	public void testVeoQueUnaHabitacionNoSatisfaceUnaCondicionDeHuespedes(){
		//arrange
		//esto mock es para ver que una habitacion use el metodo getCantidadDeHuespedes y que su valor sea not_expected
		Integer not_expected = 2;
		Mockito.when(mockHabitacion.getLimiteDeHuespedes()).thenReturn(not_expected);
		//verify
		assertFalse(condicionDeHuespedes.satisface(mockHabitacion));
	}
	//veo que pasa cuando mi condicion de nombre es null, deberia darme falso el test
	public void testCasoBordeCondicionNull(){
		condicionDeHuespedes = new CondicionDeHuespedes(null);
		Integer count_to_compare_with_null = 0;
		when(mockHabitacion.getLimiteDeHuespedes()).thenReturn(count_to_compare_with_null);
		assertFalse(condicionDeHuespedes.satisface(mockHabitacion));
	}
}