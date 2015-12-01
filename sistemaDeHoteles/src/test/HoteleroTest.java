package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

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
	
	@Before
	public void setup() {
		
		hotel1 = mock(Hotel.class);
		hotel2 = mock(Hotel.class);
		
		habitacion1 = mock(Habitacion.class);
		habitacion2 = mock(Habitacion.class);
		
		ArrayList<Habitacion> l1 = new ArrayList<Habitacion>(); l1.add(habitacion1);
		ArrayList<Habitacion> l2 = new ArrayList<Habitacion>(); l2.add(habitacion2);
		
		when(hotel1.getHabitaciones()).thenReturn(new ArrayList<Habitacion>(l1));
		when(hotel2.getHabitaciones()).thenReturn(new ArrayList<Habitacion>(l2));
		
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		
		ArrayList<Reserva> h1 = new ArrayList<Reserva>(); h1.add(reserva1);
		ArrayList<Reserva> h2 = new ArrayList<Reserva>(); h2.add(reserva2);
		
		when(habitacion1.getReservas()).thenReturn(new ArrayList<Reserva>(h1));
		when(habitacion2.getReservas()).thenReturn(new ArrayList<Reserva>(h2));
	}

	@Test
	public void test_verQueLePuedoAgregarUnHotelAUnHotelero() {
		Hotelero hotelero = new Hotelero();
		Hotel hotel = mock(Hotel.class);
		hotelero.addHotel(hotel);
		assertEquals(1,hotelero.getHoteles().size());
	}
	
	@Test
	public void test_verQuePuedoObtenerTodasLasReservasDeTodosLosHoteles() {
		Hotelero hotelero = new Hotelero();
		
		hotelero.addHotel(hotel1);
		hotelero.addHotel(hotel2);
		
		assertEquals(2,hotelero.getReservasActuales().size());
	}
	
	@Test
	public void test_verQuePuedoObtenerTodasLasReservasDeTodosLosHotelesDentroDeLosProximosNDias() {
		Hotelero hotelero = new Hotelero();
		
		hotelero.addHotel(hotel1);
		hotelero.addHotel(hotel2);
		
		Periodo p1 = mock(Periodo.class);
		Periodo p2 = mock(Periodo.class);
		
		when(reserva1.getPeriodo()).thenReturn(p1);
		when(reserva2.getPeriodo()).thenReturn(p2);
		
		DateTime dt1 = new DateTime(2500,1,1,1,1);
		DateTime dt2 = new DateTime(2015,1,1,1,1);
		
		when(p1.getFechaInicio()).thenReturn(dt1);
		when(p2.getFechaInicio()).thenReturn(dt2);
		
		assertEquals(1,hotelero.getReservasDentroDeNDias(3000).size());
	}

}
