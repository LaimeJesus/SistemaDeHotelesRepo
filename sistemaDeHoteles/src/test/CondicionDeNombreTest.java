package test;
import static org.mockito.Mockito.*;

import junit.framework.TestCase;
import modelo.CondicionDeNombreDeHotel;
import modelo.Habitacion;

public class CondicionDeNombreTest extends TestCase {


	//esta condicion tiene como objetivo ver si una habitacion pertenece a un hotel que tenga ese nombre.
	CondicionDeNombreDeHotel condicionDeNombre;
	Habitacion mockHabitacion;
	
	public void setUp(){
		condicionDeNombre = new CondicionDeNombreDeHotel("Pepe");
		mockHabitacion = mock(Habitacion.class);		

	}
	
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeNombre(){
		//arrange
		//im using this mock to check that mockHab get use getHotelName method and that it returns hotel_name
		String hotel_name_expected = "Pepe";
		when(mockHabitacion.getHotelName()).thenReturn(hotel_name_expected);
		
		//verify
		assertTrue(condicionDeNombre.satisface(mockHabitacion));
	}

	public void testVeoQueUnaHabitacionNoSatisfagaUnaCondicionDeNombre(){
		//arrange
		//Uso este mock para ver que una habitacion envie el metodo getHotelName y que devuelve hotel_name_not_expected
		String hotel_name_not_expected = "Not Pepe";
		when(mockHabitacion.getHotelName()).thenReturn(hotel_name_not_expected);
		
		//verify
		assertFalse(condicionDeNombre.satisface(mockHabitacion));
	}

	//veo que pasa cuando mi condicion de nombre es null
	public void testCasoBordeCondicionNull(){
		condicionDeNombre = new CondicionDeNombreDeHotel(null);
		String name_to_compare_with_null = "not null";
		when(mockHabitacion.getHotelName()).thenReturn(name_to_compare_with_null);
		assertFalse(condicionDeNombre.satisface(mockHabitacion));
		
	}
} 