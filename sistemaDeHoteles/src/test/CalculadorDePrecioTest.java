package test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.junit.Before;
import org.junit.Test;

import modelo.CalculadorDePrecio;
import modelo.Habitacion;
import modelo.Periodo;

public class CalculadorDePrecioTest {

	private CalculadorDePrecio calculador = new CalculadorDePrecio();
	private ReadableInstant f1 = new DateTime(2000,1,1,1,1);
	private ReadableInstant f2 = new DateTime(2000,1,2,1,1);
	Periodo periodo = new Periodo(f1,f2);
	Habitacion habitacion = new Habitacion(null,0);
	
	@Before
	public void setup() {
		habitacion.setPrecioBase(10);
	}

	@Test
	public void test_dadaUnaHabitacionConPrecioBase10SinModificacionesdePrecioCuandoLePreguntoPorSuPrecioEnUnaFechaRandomDeberiaDarme10() {
		assertEquals(10,calculador.calcularPrecio(periodo,habitacion));
	}

}
