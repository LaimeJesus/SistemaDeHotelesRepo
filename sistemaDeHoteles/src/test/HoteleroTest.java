package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import modelo.Habitacion;
import modelo.Hotel;
import modelo.Hotelero;
import modelo.Periodo;
import modelo.Reserva;

public class HoteleroTest {
	
	Hotel hotel1;
	Hotel hotel2;
	
	Habitacion habitacion1;
	Habitacion habitacion2;
	
	Reserva reserva1;
	Reserva reserva2;
	
	private Hotelero sut;
	private List<Reserva> reservashotel1;
	private List<Reserva> reservashotel2;
	
	@Before
	public void setup() {
		
		hotel1 = mock(Hotel.class);
		hotel2 = mock(Hotel.class);
		
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		
		reservashotel1 = new ArrayList<Reserva>(); reservashotel1.add(reserva1);
		reservashotel2 = new ArrayList<Reserva>(); reservashotel2.add(reserva2);

		sut = new Hotelero();
		
		sut.addHotel(hotel1);	
	
		when(hotel1.getReservas()).thenReturn(reservashotel1);
		when(hotel2.getReservas()).thenReturn(reservashotel2);		
	
	}

	@Test
	public void test_verQueLePuedoAgregarUnHotelAUnHotelero() {
		assertEquals(1,sut.getHoteles().size());
	}
	
	@Test
	public void test_verQuePuedoObtenerTodasLasReservasDeTodosLosHoteles() {

		sut.addHotel(hotel2);
		
		assertEquals(2, sut.getReservasActuales().size());
		verify(hotel1).getReservas();
		verify(hotel2).getReservas();
	}
	
	@Test
	public void test_verQuePuedoObtenerTodasLasReservasDeTodosLosHotelesDentroDeLosProximosNDias() {
		
		Periodo p1 = mock(Periodo.class);
		Periodo p2 = mock(Periodo.class);
		
		when(reserva1.getPeriodo()).thenReturn(p1);
		when(reserva2.getPeriodo()).thenReturn(p2);
		
		DateTime dt1 = new DateTime(2500,1,1,1,1);
		DateTime dt2 = new DateTime(2015,1,1,1,1);
		
		when(p1.getFechaInicio()).thenReturn(dt1);
		when(p2.getFechaInicio()).thenReturn(dt2);
		
		assertEquals(1,sut.getReservasDentroDeNDias(3000).size());
	}

}
