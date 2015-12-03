package test;

import junit.framework.TestCase;
import modelo.CamaDoble;

public class CamaDobleTest extends TestCase{
	
	CamaDoble miCamaDoble;
	Integer current;

	public void testVeoQueUnaCamaSimpleDevuelvaUnaCantidadDeOcupantesIgualA1(){
		miCamaDoble = new CamaDoble();
		current = miCamaDoble.cantidadOcupantes();
		assertEquals(2, current.intValue());
	}
}
