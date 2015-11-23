package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Servicio;

public class ServicioTest {

	@Test
	public void test_creoUnServicioYVeoQueTengaTodoLoQueLeSetie() {

		String nombre = "patis para todos";
		String descripcion = "patis para todos (y todas)";
		Integer precio = 0;
		
		Servicio servicio = new Servicio(nombre, descripcion, precio);
		
		assertEquals(nombre,servicio.getNombre());
		assertEquals(descripcion,servicio.getDescripcion());
		assertEquals(precio,servicio.getPrecio());
	}

}
