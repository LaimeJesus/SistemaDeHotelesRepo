package test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.junit.Test;

import modelo.IModificadorDePrecio;
import modelo.ModificadorDeprecioEnUnaFechaEspecifica;

public class ModificadorDePrecioEnUnaFechaEspecificaTest {

	private ReadableInstant fecha;
	
	private IModificadorDePrecio modificador = 
			new ModificadorDeprecioEnUnaFechaEspecifica(fecha,5);

	@Test
	/*
	 * Creo una modificacion en una fecha especifica y cuando le pido la modificacion
	 * veo que sea la que le setie
	 */
	public void test_crearUnaModificacionEnUnaFechaEspecifica() {
		assertEquals(Integer.valueOf(5),modificador.getModificacion(fecha));
	}
	
	@Test
	/*
	 * Creo una modificacion en una fecha especifica, le doy otra fecha y veo que me 
	 * devuelva 0
	 */
	public void test_crearUnaModificacionEnUnaFechaEspecificaYDarleOtraFecha() {
		assertEquals(Integer.valueOf(0),modificador.getModificacion(new DateTime(2000,1,1,1,1)));
	}

}
