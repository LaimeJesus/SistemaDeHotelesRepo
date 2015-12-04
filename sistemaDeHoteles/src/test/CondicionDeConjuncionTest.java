package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Condicion;
import modelo.CondicionDeConjuncion;
import modelo.CondicionDeHuespedes;
import modelo.CondicionDeNombreDeHotel;
import modelo.Habitacion;

import org.junit.Before;
import org.mockito.Mockito;

public class CondicionDeConjuncionTest extends TestCase{
	Habitacion mock_habitacion;
	CondicionDeHuespedes mockCondicionDeHuespedes;
	CondicionDeNombreDeHotel mockCondicionDeNombre;

	List<Condicion> mockList;
	CondicionDeConjuncion sut;


	@Before
	public void setUp(){
		//las condiciones
		mockCondicionDeHuespedes = Mockito.mock(CondicionDeHuespedes.class);
		mockCondicionDeNombre = Mockito.mock(CondicionDeNombreDeHotel.class);
		
		//la habitacion
		mock_habitacion = Mockito.mock(Habitacion.class);
		
		//la lista de condiciones
		mockList = new ArrayList<Condicion>();
		mockList.add(mockCondicionDeHuespedes);
		mockList.add(mockCondicionDeNombre);
		
		//los sistemas a testear
		sut = new CondicionDeConjuncion(mockList);
		
		//mock behavior
		Mockito.when(mockCondicionDeHuespedes.satisface(mock_habitacion)).thenReturn(true);
		Mockito.when(mockCondicionDeNombre.satisface(mock_habitacion)).thenReturn(true);
		
	}
	public void testVeoQueCadaCondicionEnvioElMensajeSatisface(){

		sut.satisface(mock_habitacion);
		Mockito.verify(mockCondicionDeHuespedes, Mockito.atLeastOnce()).satisface(mock_habitacion);
		Mockito.verify(mockCondicionDeNombre, Mockito.atLeastOnce()).satisface(mock_habitacion);

	}
	public void testVeoQueUnaHabitacionNoSatisfaceLaCondicion(){
		Mockito.when(mockCondicionDeHuespedes.satisface(mock_habitacion)).thenReturn(false);
		Mockito.when(mockCondicionDeNombre.satisface(mock_habitacion)).thenReturn(true);
		assertFalse(sut.satisface(mock_habitacion));
	}
	public void testVeoQueUnaHabitacionSatisfaceLaCondicion(){
		assertTrue(sut.satisface(mock_habitacion));
	}
	
	public void testVerQueSeInicializoCorrectamente(){

		int current = sut.condiciones.size();
		assertEquals(2, current);
	}

}
