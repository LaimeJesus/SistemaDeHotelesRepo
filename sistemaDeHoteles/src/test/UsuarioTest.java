package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.joda.time.DateTime;
import org.junit.Test;

import modelo.Habitacion;
import modelo.Hotel;
import modelo.Periodo;
import modelo.Reserva;
import modelo.Usuario;

public class UsuarioTest {

	@Test
	public void test_verQueLePuedoHacerUnaReserva() {
		Reserva reserva = mock(Reserva.class);
		
		Usuario usuario = new Usuario();
		usuario.agregarReserva(reserva);
		
		assertEquals(reserva,usuario.getReservas().get(0));
	}

	@Test
	public void test_verQueLePuedoQuitarUnaReserva() {
		Reserva reserva = mock(Reserva.class);
		
		Usuario usuario = new Usuario();
		usuario.agregarReserva(reserva);
		usuario.quitarReserva(reserva);
		
		assertEquals(0,usuario.getReservas().size());
	}
	
	@Test
	public void test_verQuePuedoPedirLasReservasDeUnaCiudad() {
		Reserva reserva = mock(Reserva.class);
		Habitacion habitacion = mock(Habitacion.class);
		Hotel hotel = mock(Hotel.class);
		
		String ciudad = "Alta city man";
		
		when(reserva.getHabitacion()).thenReturn(habitacion);
		when(habitacion.getHotel()).thenReturn(hotel);
		when(hotel.getNombreDeCiudad()).thenReturn(ciudad);
		
		Usuario usuario = new Usuario();
		usuario.agregarReserva(reserva);
		
		assertEquals(1,usuario.getReservas(ciudad).size());
	}
	
	@Test
	public void test_verQuePuedoPedirLasReservasFuturas() {
		DateTime hoy = new DateTime(2000,1,1,1,1);
		
		Reserva reserva1 = mock(Reserva.class);
		Periodo periodo1 = mock(Periodo.class);
		DateTime fecha1 = new DateTime(2500,1,1,1,1);
		
		when(reserva1.getPeriodo()).thenReturn(periodo1);
		when(periodo1.getFechaInicio()).thenReturn(fecha1);
		
		Reserva reserva2 = mock(Reserva.class);
		Periodo periodo2 = mock(Periodo.class);
		DateTime fecha2 = new DateTime(1500,1,1,1,1);
		
		when(reserva2.getPeriodo()).thenReturn(periodo2);
		when(periodo2.getFechaInicio()).thenReturn(fecha2);
		
		Usuario usuario = new Usuario();
		usuario.agregarReserva(reserva1);
		usuario.agregarReserva(reserva2);
		
		assertEquals(1,usuario.getReservasPosterioresA(hoy).size());
	}
	
	@Test
	public void test_verQuePuedoObtenerLasCiudadesDondeReservo() {
		String ciudad1 = "alta city pa!";
		Reserva reserva1 = mock(Reserva.class);
		Habitacion habitacion1 = mock(Habitacion.class);
		Hotel hotel1 = mock(Hotel.class);
		
		when(reserva1.getHabitacion()).thenReturn(habitacion1);
		when(habitacion1.getHotel()).thenReturn(hotel1);
		when(hotel1.getNombreDeCiudad()).thenReturn(ciudad1);
		
		String ciudad2 = "la city piola!";
		Reserva reserva2 = mock(Reserva.class);;
		Habitacion habitacion2 = mock(Habitacion.class);
		Hotel hotel2 = mock(Hotel.class);
		
		when(reserva2.getHabitacion()).thenReturn(habitacion2);
		when(habitacion2.getHotel()).thenReturn(hotel2);
		when(hotel2.getNombreDeCiudad()).thenReturn(ciudad2);
		
		Usuario usuario = new Usuario();
		usuario.agregarReserva(reserva1);
		usuario.agregarReserva(reserva2);
		
		assertEquals(2,usuario.getCiudadesDondeReservo().size());
	}

}
