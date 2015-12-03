package test;

import junit.framework.TestCase;
import modelo.CamaSimple;

public class CamaSimpleTest extends TestCase{
	
	CamaSimple miCamaSimple;
	Integer current;

	public void testVeoQueUnaCamaSimpleDevuelvaUnaCantidadDeOcupantesIgualA1(){
		miCamaSimple = new CamaSimple();
		current = miCamaSimple.cantidadOcupantes();
		assertEquals(1, current.intValue());
	}
}
