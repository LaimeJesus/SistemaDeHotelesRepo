package test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.junit.Test;

import modelo.IModificadorDePrecio;
import modelo.ModificadorDePrecioEnUnPeriodo;

public class ModificadorDePrecioEnUnPeriodoTest {

	private ReadableInstant fecha = new DateTime(2000,1,1,1,1);
	private ReadableInstant fechaFin = new DateTime(2000,2,2,0,0);
	private ReadableInstant fechaInicio = new DateTime(2000,1,1,0,0);
	private IModificadorDePrecio modificador = 
			new ModificadorDePrecioEnUnPeriodo(fechaInicio,fechaFin,5);

	@Test
	/*
	 * creo un modificador de periodo, le doy una fecha que este en ese periodo
	 * y veo que me de la modificacion que le setie
	 */
	public void test_crearUnModificadorConUnPeriodoYVerQueMeDaSuModificacionSiLePasoUnaFechaQueEstaEnEsePeriodo() {
		assertEquals(Integer.valueOf(5),modificador.getModificacion(fecha));
	}
	
	@Test
	/*
	 * creo un modificador de periodo, le doy una fecha que No este en ese periodo
	 * y veo que me de 0 de modificacion
	 */
	public void test_crearUnModificadorConUnPeriodoDarleUnaFechaQueNoEsteYVerQueMeDaCeroDeModificacion() {
		assertEquals(Integer.valueOf(0),modificador.getModificacion(new DateTime(1000,1,1,0,0)));
	}

}
