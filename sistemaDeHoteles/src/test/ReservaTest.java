package test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import modelo.Habitacion;
import modelo.Periodo;
import modelo.Reserva;

public class ReservaTest {

	private Periodo periodo = new Periodo(new DateTime(2000,1,1,1,1),new DateTime(2000,1,2,1,1));
	private Reserva reserva;
	private String usuario = "pepe";
	private Habitacion habitacion = new Habitacion(null);
	
	@Before
	public void setup() {
		reserva = new Reserva(habitacion,periodo,usuario);
	}

	/*
	 * creo una reserva y veo que tenga los colaboradores que le setie
	 */
	@Test
	public void test() {
		assertEquals(periodo,reserva.getPeriodo());
		assertEquals(usuario,reserva.getUsuario());
		assertEquals(habitacion,reserva.getHabitacion());
	}

}
