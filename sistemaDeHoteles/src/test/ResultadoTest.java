package test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import junit.framework.TestCase;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Resultado;

public class ResultadoTest extends TestCase{
	
	List<Habitacion> habitaciones;
	Hotel hotel;
	Resultado sut;
	String expected;
	String current;

	public void testVerQueSeInicializaBienUnResultado(){
		//arrange
		habitaciones = new ArrayList<Habitacion>();
		hotel = Mockito.mock(Hotel.class);
		sut = new Resultado(habitaciones, hotel);
		
		//working
		expected = "pepe";
		Mockito.when(hotel.getName()).thenReturn(expected);
		current = sut.getHotel().getName();
		
		//assertion
		assertEquals(0, sut.getHabitaciones().size());
		assertEquals(expected, current);
	}

}
