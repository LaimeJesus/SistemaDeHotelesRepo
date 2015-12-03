package test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import junit.framework.TestCase;
import modelo.*;
public class ArmadorDeResultadoTest extends TestCase{

	private Hotel mockHotel;
	private Condicion mockCondicion;
	private ArrayList<Hotel> mockHotelList;
	private ArrayList<Habitacion> mockHabitacionList;
	private Habitacion mockHabitacion;
	private ArmadorDeResultado sut;
	private int alternativas;
	private List<Resultado> resultados;
	
	
	public void setUp(){
		
		sut = new ArmadorDeResultado();
		
		mockHotelList = new ArrayList<Hotel>();
		mockHotel = Mockito.mock(Hotel.class);

		mockHabitacion = Mockito.mock(Habitacion.class);
		mockHabitacionList = new ArrayList<Habitacion>();
		
		mockCondicion = Mockito.mock(Condicion.class);
		
	
	}
	
	public void testVerSiBuscarAlternativasEncuentraUnaHabitacionQueCumplaUnaCondicion(){
		//lista de hoteles con un hotel
		//lista de habitacioens de ese hotel con una habitacion
		mockHotelList.add(mockHotel);
		mockHabitacionList.add(mockHabitacion);

		Mockito.when(mockHotel.filterHabitaciones(mockCondicion)).thenReturn(mockHabitacionList);
		
		resultados = sut.buscarAlternativas(mockHotelList, mockCondicion);
		alternativas = resultados.size();
		assertEquals(1, alternativas);
		
	}
	
	public void testVerSiBuscarAlternativasNoEncuentraUnaHabitacionQueCumplaUnaCondicion(){
		//lista de hoteles con un hotel
		//lista de habitacioens de ese hotel con una habitacion
		
		mockHotelList.add(mockHotel);
		Mockito.when(mockHotel.filterHabitaciones(mockCondicion)).thenReturn(mockHabitacionList);
		
		resultados = sut.buscarAlternativas(mockHotelList, mockCondicion);
		alternativas = resultados.size();
		assertEquals(0, alternativas);
	}

	public void testCasoBordeListDeHotelVacia(){
		//lista de hoteles vacia
		//lista de habitaciones no importa
		
		Mockito.when(mockHotel.filterHabitaciones(mockCondicion)).thenReturn(mockHabitacionList);
		alternativas = sut.buscarAlternativas(mockHotelList, mockCondicion).size();
		
		assertEquals(0,alternativas);
	}

}