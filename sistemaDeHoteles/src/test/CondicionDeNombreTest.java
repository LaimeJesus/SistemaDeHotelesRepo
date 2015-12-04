package test;
import static org.mockito.Mockito.*;
import java.util.List;
import org.mockito.Mockito;
import junit.framework.TestCase;
import modelo.Condicion;
import modelo.CondicionDeNombreDeHotel;
import modelo.Habitacion;

public class CondicionDeNombreTest extends TestCase {


	//esta condicion tiene como objetivo ver si una habitacion pertenece a un hotel que tenga ese nombre.
	CondicionDeNombreDeHotel sut;
	Habitacion mockHabitacion;
	
	public void setUp(){
		sut = new CondicionDeNombreDeHotel("Pepe");
		mockHabitacion = mock(Habitacion.class);		

	}
	
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeNombre(){
		//arrange
		//im using this mock to check that mockHab get use getHotelName method and that it returns hotel_name
		String expected = "Pepe";
		when(mockHabitacion.getHotelName()).thenReturn(expected);
		
		//verify
		assertTrue(sut.satisface(mockHabitacion));
	}

	public void testVeoQueUnaHabitacionNoSatisfagaUnaCondicionDeNombre(){
		//arrange
		//Uso este mock para ver que una habitacion envie el metodo getHotelName y que devuelve hotel_name_not_expected
		String not_expected = "Not Pepe";
		when(mockHabitacion.getHotelName()).thenReturn(not_expected);
		
		//verify
		assertFalse(sut.satisface(mockHabitacion));
	}

	//veo que pasa cuando mi condicion de nombre es null
	public void testCasoBordeCondicionNull(){
		sut = new CondicionDeNombreDeHotel(null);
		String name_to_compare_with_null = "not null";
		when(mockHabitacion.getHotelName()).thenReturn(name_to_compare_with_null);
		assertFalse(sut.satisface(mockHabitacion));
		
	}
	
	//test fruta que hay que borrar
	public void testProbandoComposeConOtraCondicion(){
		CondicionDeNombreDeHotel condicionMock = Mockito.mock(CondicionDeNombreDeHotel.class);
		CondicionDeNombreDeHotel nombreHotel = new CondicionDeNombreDeHotel("aHotelName");
		List<Condicion> current = sut.crearGrupoDeCondicion(sut,condicionMock);
		assertEquals(2, current.size());
		//no puedo testear el compose de la clase condicion
		assertNotSame(sut,sut.composeToConjuncion(nombreHotel).composeToDisjuncion(condicionMock));
	
	}
	
} 