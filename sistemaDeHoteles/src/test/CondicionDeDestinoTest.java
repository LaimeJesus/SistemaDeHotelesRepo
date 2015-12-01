package test;

import modelo.*;

import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class CondicionDeDestinoTest extends TestCase {

	//esta condicion tiene como objetivo ver si una habitacion pertenece a la ciudad indicada en la condicion	
	
	private Habitacion mock_habitacion;
	private CondicionDeDestino condicionDeDestino;

	public void setUp(){
		//
		mock_habitacion = Mockito.mock(Habitacion.class);
		//sut
		condicionDeDestino = new CondicionDeDestino("Berazategui");
	}


	public void testVeoQueUnaHabitacionSatisfaceUnaCondicionDeDestino(){
		//arrange
		String destino_expected = "Berazategui";
		
		//verify
		Mockito.when(mock_habitacion.getHotelNombreDeCiudad()).thenReturn(destino_expected);
		
		assertEquals(destino_expected, condicionDeDestino.getCondicion());
		assertTrue(condicionDeDestino.satisface(mock_habitacion));
	}
	
	public void testVeoQueUnaHabitacionNoSatisfaceUnaCondicionDeDestino(){
		//arrange
		String destino_not_expected = "not expected";
		Mockito.when(mock_habitacion.getHotelNombreDeCiudad()).thenReturn(destino_not_expected);
		//verify
		assertNotSame(destino_not_expected, condicionDeDestino.getCondicion());
		assertFalse(condicionDeDestino.satisface(mock_habitacion));
	}

	public void testCasoBordeNombreDeCiudadNull(){
		//arrange
		Mockito.when(mock_habitacion.getHotelNombreDeCiudad()).thenThrow(new NullPointerException());
		//verify
		try {
			condicionDeDestino.satisface(mock_habitacion);
		}catch(Throwable expected){
	        assertEquals(NullPointerException.class, expected.getClass());
			}
		}
	public void testCasoBordeCondicionNull(){
		//arrange
		condicionDeDestino = new CondicionDeDestino(null);
		//Mockito.when(mock_habitacion.getHotelNombreDeCiudad()).thenReturn("a name");
		try {
			condicionDeDestino.satisface(mock_habitacion);
		}catch(Throwable expected){
	        assertEquals(NullPointerException.class, expected.getClass());
			}
		Mockito.verify(mock_habitacion).getHotelNombreDeCiudad();
	}
}