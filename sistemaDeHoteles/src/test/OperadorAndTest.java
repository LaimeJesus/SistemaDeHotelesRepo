package test;

import junit.framework.TestCase;
import modelo.OperadorAnd;

public class OperadorAndTest extends TestCase{
	
	OperadorAnd sut;
	public void setUp(){
		sut = new OperadorAnd();
	}
	
	public void testVerQueConsigoBienElNeutro(){
		
		assertEquals(true, sut.neutro());
	}
	public void testVerQueOrOpereBien(){
		
		boolean primerCaso = sut.operar(false,false);
		boolean segundoCaso = sut.operar(true,true);
		boolean tercerCaso = sut.operar(primerCaso,segundoCaso);
		boolean cuartoCaso = sut.operar(segundoCaso,primerCaso);
		
		assertEquals(false, primerCaso);
		assertEquals(true, segundoCaso);
		assertEquals(false, tercerCaso);
		assertEquals(false, cuartoCaso);
	}
}
