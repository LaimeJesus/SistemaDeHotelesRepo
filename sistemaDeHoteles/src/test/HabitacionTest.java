package test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.Cama;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Periodo;
import modelo.Reserva;

public class HabitacionTest extends TestCase{
	
	private Hotel mockHotel;
	private ArrayList<Cama> dummyCamas;
	private Habitacion sut;
	private ArrayList<Reserva> mockList;
	private Reserva mockReserva;
	
	public void setUp(){
		dummyCamas = new ArrayList<Cama>();
		sut = new Habitacion(dummyCamas);
		mockHotel = Mockito.mock(Hotel.class);
		
		sut.setHotel(mockHotel);
	}
	
	public void testVeoQueDevuelveElNombreDelHotelAlQuePertence(){

		sut.getHotelName();
		
		Mockito.verify(mockHotel).getName();
	}
	
	public void testVeoQueDevuelveElNombreDeLaCiudadDelHotelAlQuePertence(){
		
		sut.getHotelNombreDeCiudad();
		
		Mockito.verify(mockHotel).getNombreDeCiudad();
	}
	
	//este no anda como esperaba per igual funciona estoy medio dormido dsp sigo
	public void testVeoSiUnaHabitacionEstaDisponible(){
		
		mockList = new ArrayList<Reserva>();
		mockReserva = Mockito.mock(Reserva.class);
		mockList.add(mockReserva);
		
		Periodo expected = Mockito.mock(Periodo.class);
		Periodo toCompare = Mockito.mock(Periodo.class);
		
		Mockito.when(mockReserva.getPeriodo()).thenReturn(expected);
		Mockito.when(expected.coincideCon(toCompare)).thenReturn(true);
		
		assertTrue(sut.estaDisponible(toCompare));
	}
	
	
	
	@Test
	public void test_verQuePuedoSetearReservas() {
		Habitacion h = new Habitacion(null);
		Reserva r = mock(Reserva.class);
		h.agregarReserva(r);
		assertEquals(1,h.getReservas().size());
	}
	
	/* test viejos sin mock hechos antes que se de la clase de test doubles */

	private Habitacion habitacion = new Habitacion(null);
	private Periodo periodoReserva = new Periodo(new DateTime(1999,1,1,1,1),new DateTime(2555,1,1,1,1));
	private Reserva reserva = new Reserva(habitacion, periodoReserva, "pepe");

	/*
	 * creo una habitacion y veo que este siempre disponible
	 */
	@Test
	public void test_veoQueUnaHabitacionRecienCreadaEsteSiempreDisponible() {
		assertTrue(habitacion.estaDisponible(new Periodo(new DateTime(2000,1,1,1,1), new DateTime(2000,1,1,2,1))));
	}
	
	/*
	 * creo una habitacion, le hago una reserva, pregunto si esta disponible en un periodo que este reservada
	 * y veo que me diga que no.
	 * tambien, le pregunto si esta reservada en otro periodo y veo que me diga que esta disponible
	 */
	@Test
	public void test_veoQueUnaHabitacionDigaQueNoEstaDisponible() {
		habitacion.agregarReserva(reserva);
		assertFalse(habitacion.estaDisponible(new Periodo(new DateTime(2000,1,1,1,1), new DateTime(2000,1,1,2,1))));
		assertTrue(habitacion.estaDisponible(new Periodo(new DateTime(1500,1,1,1,1), new DateTime(1500,1,10,1,1))));
	}
	
	@Test
	public void test_veoQuePuedaQuitarleUnaReservaYaHechaAUnaHabitacionDesdeLaReserva() {
		habitacion.agregarReserva(reserva);
		reserva.quitarReserva();
		assertTrue(habitacion.estaDisponible(new Periodo(new DateTime(2000,1,1,1,1), new DateTime(2001,1,1,1,1))));
	}

}
