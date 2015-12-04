package test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.Cama;
import modelo.CamaDoble;
import modelo.CamaSimple;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Periodo;
import modelo.Reserva;

public class HabitacionTest extends TestCase{
	
	private Hotel mockHotel;
	private Habitacion sut;
	private Reserva mockReserva;
	private List<Cama> mockCamaList;
	private CamaSimple mockCamaSimple;
	private Cama mockCamaDoble;

	
	private Habitacion habitacion = new Habitacion(null);
	private Periodo periodoReserva = new Periodo(new DateTime(1999,1,1,1,1),new DateTime(2555,1,1,1,1));
	private Reserva reserva = new Reserva(habitacion, periodoReserva, "pepe");
	
	public void setUp(){
		
		mockCamaList = new ArrayList<Cama>();
		mockCamaSimple = Mockito.mock(CamaSimple.class);
		mockCamaSimple = Mockito.mock(CamaSimple.class);
		mockCamaDoble = Mockito.mock(CamaDoble.class);
		mockCamaList.add(mockCamaSimple);
		mockCamaList.add(mockCamaDoble);

		mockReserva = Mockito.mock(Reserva.class);
		
		sut = new Habitacion(mockCamaList);
		mockHotel = Mockito.mock(Hotel.class);
		
		sut.agregarReserva(mockReserva);
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

	public void testVeoSiUnaHabitacionEstaDisponible(){
		
		Periodo periodoOcupadoPorLaReserva = Mockito.mock(Periodo.class);
		Periodo periodoAComparar = Mockito.mock(Periodo.class);
		
		Mockito.when(mockReserva.getPeriodo()).thenReturn(periodoOcupadoPorLaReserva);
		Mockito.when(periodoOcupadoPorLaReserva.coincideCon(periodoAComparar)).thenReturn(false);
		
		assertTrue(sut.estaDisponible(periodoAComparar));
	}
	
	public void testVeoQueConsigoLaCantidadDeHuespedesDisponiblesQueEspero(){
		
		sut.getLimiteDeHuespedes();
		Mockito.verify(mockCamaSimple).cantidadOcupantes();
		Mockito.verify(mockCamaDoble).cantidadOcupantes();
	}
	
	
	@Test
	public void test_verQuePuedoSetearReservas() {
		assertEquals(1,sut.getReservas().size());
	}
	

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
