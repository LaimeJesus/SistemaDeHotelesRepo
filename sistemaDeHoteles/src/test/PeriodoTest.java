package test;

import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.Periodo;

public class PeriodoTest extends TestCase{

	private ReadableInstant fecha = new DateTime(2000,1,1,1,0);
	private ReadableInstant fechaFin = new DateTime(2000,2,2,0,0);
	private ReadableInstant fechaInicio = new DateTime(2000,1,1,0,0);
	private Periodo periodo = new Periodo(fechaInicio, fechaFin);
	private ReadableInstant fechaInicioMock;
	private ReadableInstant fechaFinMock;
	private Periodo sut;
	
	//creo que le faltan un par de test a esta clase
	public void setUp(){
		fechaInicioMock = Mockito.mock(ReadableInstant.class);
		fechaFinMock = Mockito.mock(ReadableInstant.class);
		sut = new Periodo(fechaInicioMock, fechaFinMock);
	}
	
	
	/*
	 * creo una fecha y un periodo y veo que la fecha pertenesca al periodo
	 */
	@Test
	public void test_verQueUnaFechaPerteneceAUnPeriodo() {
		assertTrue(periodo.perteneceAlPeriodo(fecha));
	}

	public void testVerQueSeSetearonBienLosConstructoresDelPeriodo(){

		assertEquals(fechaInicioMock, sut.getFechaInicio());
		assertEquals(fechaFinMock, sut.getFechaFin());
	}
	public void testVerQueUnaFechaNoPerteneceAUnPeriodo(){
		fecha = Mockito.mock(ReadableInstant.class);
		Mockito.when(fecha.isAfter(fechaInicioMock)).thenReturn(true);
		Mockito.when(fechaFinMock.isAfter(fecha)).thenReturn(false);
		
		assertFalse(sut.perteneceAlPeriodo(fecha));
		Mockito.verify(fecha).isAfter(fechaInicioMock);
		Mockito.verify(fechaFinMock).isAfter(fecha);		
	}
	
}
