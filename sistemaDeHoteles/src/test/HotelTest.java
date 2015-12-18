package test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import junit.framework.TestCase;
import modelo.Condicion;
import modelo.Habitacion;
import modelo.Hotel;

public class HotelTest extends TestCase{
	
	private Hotel sut;
	private String nombreMock;
	private String ciudadMock;
	private List<Habitacion> listaHabitacionesMock;
	private Habitacion habitacionMock;
	private Condicion condicionMock;

	public void setUp(){

		condicionMock = mock(Condicion.class);
		nombreMock = "aName";
		ciudadMock = "aCity";
		habitacionMock = mock(Habitacion.class);
		listaHabitacionesMock = new ArrayList<Habitacion>();
		listaHabitacionesMock.add(habitacionMock);
		sut = new Hotel(nombreMock, ciudadMock, listaHabitacionesMock);
	}
	
	public void testVerQueHotelSeSeteoEnCadaHabitacion(){
		verify(habitacionMock).setHotel(sut);
	}
	
	public void testVerQueFiltrarHabitacionesFiltreUnaHabitacion(){
		when(condicionMock.satisface(habitacionMock)).thenReturn(true);
		int current = sut.filterHabitaciones(condicionMock).size();
		assertEquals(1, current);
	}
	public void testVerQueFiltrarHabitacionesNoFiltreHabitaciones(){
		when(condicionMock.satisface(habitacionMock)).thenReturn(false);
		int current = sut.filterHabitaciones(condicionMock).size();
		assertEquals(0, current);
	}
	public void testVerQueSeSetearonBienLosConstructores(){
		assertEquals(nombreMock, sut.getName());
		assertEquals(ciudadMock, sut.getNombreDeCiudad());
		assertEquals(listaHabitacionesMock, sut.getHabitaciones());
	}
	
	public void testVerQueFuncionaGetReservas(){
		sut.getReservas();
		verify(habitacionMock).getReservas();
		
		
		
	}
	
}
