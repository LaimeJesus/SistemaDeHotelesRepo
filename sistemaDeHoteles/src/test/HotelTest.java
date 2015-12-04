package test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import modelo.Condicion;
import modelo.Habitacion;
import modelo.Hotel;
import junit.framework.TestCase;

public class HotelTest extends TestCase{
	
	private Hotel sut;
	private String nombreMock;
	private String ciudadMock;
	private List<Habitacion> listaHabitacionesMock;
	private Habitacion habitacionMock;
	private Condicion condicionMock;

	public void setUp(){

		condicionMock = Mockito.mock(Condicion.class);
		nombreMock = "aName";
		ciudadMock = "aCity";
		habitacionMock = Mockito.mock(Habitacion.class);
		listaHabitacionesMock = new ArrayList<Habitacion>();
		listaHabitacionesMock.add(habitacionMock);
		sut = new Hotel(nombreMock, ciudadMock, listaHabitacionesMock);
	}
	
	public void testVerQueHotelSeSeteoEnCadaHabitacion(){
		Mockito.verify(habitacionMock).setHotel(sut);
	}
	
	public void testVerQueFiltrarHabitacionesFiltreUnaHabitacion(){
		Mockito.when(condicionMock.satisface(habitacionMock)).thenReturn(true);
		int current = sut.filterHabitaciones(condicionMock).size();
		assertEquals(1, current);
	}
	public void testVerQueFiltrarHabitacionesNoFiltreHabitaciones(){
		Mockito.when(condicionMock.satisface(habitacionMock)).thenReturn(false);
		int current = sut.filterHabitaciones(condicionMock).size();
		assertEquals(0, current);
	}
	public void testVerQueSeSetearonBienLosConstructores(){
		assertEquals(nombreMock, sut.getName());
		assertEquals(ciudadMock, sut.getNombreDeCiudad());
		assertEquals(listaHabitacionesMock, sut.getHabitaciones());
	}
	
}
