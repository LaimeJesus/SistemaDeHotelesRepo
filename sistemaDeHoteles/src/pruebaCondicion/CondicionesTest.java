package pruebaCondicion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CondicionesTest {

	Condicion condicionHuesped;
	CondicionDeDestino condicionDestino;
	ICondicionable condicion;
	ArrayList<Integer> habs;
	Hotel hotelo;
	@Before
	public void setUp(){
		this.habs = new ArrayList<Integer>();
		this.condicionHuesped = new CondicionDeHuespedes(4);
		this.condicionDestino = new CondicionDeDestino();
		this.condicionDestino.setCondicionDeNombre("perro");
		
		this.condicion = this.condicionDestino.compose(this.condicionDestino);
		this.hotelo = new Hotel("perro", "bera", this.habs, 4);
	}

	@Test
	public void test() {
		assertTrue(this.condicion.satisface(this.hotelo));
	}

}
