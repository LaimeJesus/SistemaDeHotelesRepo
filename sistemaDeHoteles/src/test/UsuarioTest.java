package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import modelo.Habitacion;
import modelo.Hotel;
import modelo.Periodo;
import modelo.Reserva;
import modelo.Usuario;

public class UsuarioTest {

	private Reserva reserva;
	private Usuario sut;
	@Before
	public void setUp(){
		reserva = mock(Reserva.class);
		sut = new Usuario();
		sut.agregarReserva(reserva);

	
	}
	
	@Test
	public void test_verQueLePuedoAgregarUnaReserva() {
		
		assertEquals(reserva, sut.getReservas().get(0));
	}

	@Test
	public void test_verQueLePuedoQuitarUnaReserva() {

		sut.quitarReserva(reserva);
		
		assertEquals(0, sut.getReservas().size());
	}
	
	@Test
	public void test_verQuePuedoPedirLasReservasDeUnaCiudad() {
		
		Habitacion habitacion = mock(Habitacion.class);
		Hotel hotel = mock(Hotel.class);
		
		String ciudad = "Alta city man";
		
		when(reserva.getHabitacion()).thenReturn(habitacion);
		when(habitacion.getHotel()).thenReturn(hotel);
		when(hotel.getNombreDeCiudad()).thenReturn(ciudad);
				
		assertEquals(1, sut.getReservasDeUnaCiudad(ciudad).size());
	}
	
	@Test
	public void test_verQuePuedoPedirLasReservasFuturas() {
		
		sut = new Usuario();
		
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
		
		sut.agregarReserva(reserva1);
		sut.agregarReserva(reserva2);
		
		assertEquals(1, sut.getReservasPosterioresA(hoy).size());
	}
	
	@Test
	public void test_verQuePuedoObtenerLasCiudadesDondeReservo() {
		
		sut = new Usuario();
		
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
		
		sut.agregarReserva(reserva1);
		sut.agregarReserva(reserva2);
		
		assertEquals(2, sut.getCiudadesDondeReservo().size());
	}
	
	@Test
	public void test_verQuePuedoObtenerLasReservasActuales(){
		
		DateTime unaHoraAntes = new DateTime().minus(60);
		DateTime unaHoraDespues = new DateTime().plus(60);
		
		Periodo hoy = new Periodo(unaHoraAntes, unaHoraDespues);
		when(reserva.getPeriodo()).thenReturn(hoy);
		assertEquals(1, sut.getReservasActuales().size());
	}

	@Test
	public void test_verQuePuedoCancelarUnaReserva(){
		sut.cancelarReserva(reserva);
		verify(reserva).quitarReserva();
		assertEquals(0, sut.getReservas().size());
	}
	
	@Test
	public void test_verQuePuedoRealizarUnaReserva(){
		sut = new Usuario();
		
		Habitacion habitacionMock = mock(Habitacion.class);
		when(reserva.getHabitacion()).thenReturn(habitacionMock);
		
		sut.realizarReserva(reserva);
		
		verify(reserva).getHabitacion();
		verify(habitacionMock).agregarReserva(reserva);
		assertEquals(1, sut.getReservas().size());
	}
	
}
