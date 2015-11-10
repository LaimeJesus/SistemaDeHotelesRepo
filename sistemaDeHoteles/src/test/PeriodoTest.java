package test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.junit.Test;

import modelo.Periodo;

public class PeriodoTest {

	private ReadableInstant fecha = new DateTime(2000,1,1,1,0);
	private ReadableInstant fechaFin = new DateTime(2000,2,2,0,0);
	private ReadableInstant fechaInicio = new DateTime(2000,1,1,0,0);
	private Periodo periodo = new Periodo(fechaInicio, fechaFin);

	/*
	 * creo una fecha y un periodo y veo que la fecha pertenesca al periodo
	 */
	@Test
	public void test_verQueUnaFechaPerteneceAUnPeriodo() {
		assertTrue(periodo.perteneceAlPeriodo(fecha));
	}

}
