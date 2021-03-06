package test;

import modelo.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class CondicionDeDestinoTest extends TestCase {

	//esta condicion tiene como objetivo ver si una habitacion pertenece a la ciudad indicada en la condicion	
	
	private Habitacion mock_habitacion;
	private CondicionDeDestino sut;

	@Before
	public void setUp(){
		//
		mock_habitacion = Mockito.mock(Habitacion.class);
		//sut
		sut = new CondicionDeDestino("Berazategui");
	}


	public void testVeoQueUnaHabitacionSatisfaceUnaCondicionDeDestino(){
		//arrange
		String destino_expected = "Berazategui";
		
		//verify
		Mockito.when(mock_habitacion.getHotelNombreDeCiudad()).thenReturn(destino_expected);
		
		assertEquals(destino_expected, sut.getCondicion());
		assertTrue(sut.satisface(mock_habitacion));
	}
	
	public void testVeoQueUnaHabitacionNoSatisfaceUnaCondicionDeDestino(){
		//arrange
		String destino_not_expected = "not expected";
		Mockito.when(mock_habitacion.getHotelNombreDeCiudad()).thenReturn(destino_not_expected);
		//verify
		assertNotSame(destino_not_expected, sut.getCondicion());
		assertFalse(sut.satisface(mock_habitacion));
	}
}