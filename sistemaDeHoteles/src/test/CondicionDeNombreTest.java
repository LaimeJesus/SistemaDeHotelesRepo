package test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

import junit.framework.TestCase;
import modelo.Cama;
import modelo.CamaDoble;
import modelo.CamaSimple;
import modelo.CondicionDeNombre;
import modelo.Habitacion;
import modelo.Hotel;

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
		
		Habitacion mockHab = mock(Habitacion.class);
		
		//verify(mockHab).getHotelName();
		String hotel_name = "Pepe";
		when(mockHab.getHotelName()).thenReturn(hotel_name);
		

		//verify
		assertTrue(condicionDeNombre.satisface(mockHab));
	}
}