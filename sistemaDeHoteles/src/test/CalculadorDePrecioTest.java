package test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.junit.Before;
import org.junit.Test;

import modelo.CalculadorDePrecio;
import modelo.Habitacion;
import modelo.IModificadorDePrecio;
import modelo.ModificadorDeprecioEnUnaFechaEspecifica;
import modelo.Periodo;

public class CalculadorDePrecioTest {

	private CalculadorDePrecio calculador = new CalculadorDePrecio();
	private ReadableInstant f1 = new DateTime(2000,1,1,1,1);
	private ReadableInstant f2 = new DateTime(2000,1,4,1,1);
	private Periodo periodo = new Periodo(f1,f2);
	private Habitacion habitacion = new Habitacion(null,0);
	private Integer precioBase = 10;
	private Integer precioModificacion = 20;
	private IModificadorDePrecio modificacion = new ModificadorDeprecioEnUnaFechaEspecifica(new DateTime(2000,1,3,1,1),precioModificacion);
	
	@Before
	public void setup() {
		habitacion.setPrecioBase(precioBase);
	}

	/*
	 * calculo el precio de una habitacion sin modificaciones
	 */
	@Test
	public void test_dadaUnaHabitacionConPrecioBase10SinModificacionesdePrecioCuandoLePreguntoPorSuPrecioEnUnaFechaRandomDeberiaDarme10() {
		assertEquals(precioBase * periodo.getCantidadDeDias(),calculador.calcularPrecio(periodo,habitacion));
	}
	
	/*
	 * calculo el precio por noche de una habitacion con una modificacion
	 */
	@Test
	public void test_dadaUnaHabitacionConPrecioBase10YUnaModificacionDe20EnUnaFechaVerQueCalculaBienElPrecio() {
		habitacion.agregarModificacion(modificacion);
		assertEquals((precioBase * periodo.getCantidadDeDias()) + precioModificacion,calculador.calcularPrecio(periodo, habitacion));
	}

}
