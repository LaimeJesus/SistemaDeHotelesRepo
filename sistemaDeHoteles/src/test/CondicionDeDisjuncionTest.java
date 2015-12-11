package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.Condicion;
import modelo.CondicionDeConjuncion;
import modelo.CondicionDeDisjuncion;
import modelo.CondicionDeHuespedes;
import modelo.CondicionDeNombreDeHotel;
import modelo.Habitacion;
import org.junit.Before;
import org.mockito.Mockito;

public class CondicionDeDisjuncionTest extends TestCase{
	//necesito cambiar los test pero no llego a ver como asi que dsp lo veo
	Habitacion mock_habitacion;
	CondicionDeHuespedes mockCondicionDeHuespedes;
	CondicionDeNombreDeHotel mockCondicionDeNombre;

	List<Condicion> mockList;
	CondicionDeDisjuncion sut;
	
	CondicionDeNombreDeHotel hoja;


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
		sut = new CondicionDeDisjuncion(mockList);
		
		//mock behavior 
		Mockito.when(mockCondicionDeHuespedes.satisface(mock_habitacion)).thenReturn(false);
		Mockito.when(mockCondicionDeNombre.satisface(mock_habitacion)).thenReturn(false);
	}
	public void testVeoQueCadaCondicionEnvioElMensajeSatisface(){

		sut.satisface(mock_habitacion);
		Mockito.verify(mockCondicionDeHuespedes, Mockito.atLeastOnce()).satisface(mock_habitacion);
		Mockito.verify(mockCondicionDeNombre, Mockito.atLeastOnce()).satisface(mock_habitacion);

	}
	public void testVeoQueUnaHabitacionNoSatisfaceLaCondicion(){
		assertFalse(sut.satisface(mock_habitacion));
	}
	public void testVeoQueUnaHabitacionSatisfaceLaCondicion(){
		Mockito.when(mockCondicionDeHuespedes.satisface(mock_habitacion)).thenReturn(true);
		assertTrue(sut.satisface(mock_habitacion));
	}
	
	public void testVerQueSeInicializoCorrectamente(){

		int current = sut.condiciones.size();
		assertEquals(2, current);
	}
	public void testVerQueComponerUnaCondicionDeDisjuncionConUnaCondicionHojaFormaOtraCondicionDeConjuncion(){
		assertEquals(CondicionDeDisjuncion.class, sut.composeToDisjuncion(hoja).getClass());
	}
	
	public void testVerQueComponerUnaCondicionDeConjuncionConUnaHojaFormaUnaCondicionDeConjuncion(){
		assertEquals(CondicionDeConjuncion.class, sut.composeToConjuncion(hoja).getClass());
	}

}
