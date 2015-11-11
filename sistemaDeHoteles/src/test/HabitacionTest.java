package test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import modelo.Habitacion;
import modelo.Periodo;
import modelo.Reserva;

public class HabitacionTest {

	private Habitacion habitacion = new Habitacion(null,1);
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
	 * y veo que me diga que no
	 */
	@Test
	public void test_veoQueUnaHabitacionDigaQueNoEstaDisponible() {
		habitacion.agregarReserva(reserva);
		assertFalse(habitacion.estaDisponible(new Periodo(new DateTime(2000,1,1,1,1), new DateTime(2000,1,1,2,1))));
	}

}
