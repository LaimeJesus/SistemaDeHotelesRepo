package test;

import modelo.OperadorOr;
import junit.framework.TestCase;

public class OperadorOrTest extends TestCase{
	
	OperadorOr sut;
	public void setUp(){
		sut = new OperadorOr();
	}
	
	public void testVerQueConsigoBienElNeutro(){
		
		assertEquals(false, sut.neutro());
	}
	public void testVerQueOrOpereBien(){
		
		boolean primerCaso = sut.operar(false,false);
		boolean segundoCaso = sut.operar(true,true);
		boolean tercerCaso = sut.operar(primerCaso,segundoCaso);
		boolean cuartoCaso = sut.operar(segundoCaso,primerCaso);
		
		assertEquals(false, primerCaso);
		assertEquals(true, segundoCaso);
		assertEquals(true, tercerCaso);
		assertEquals(true, cuartoCaso);
	}

}
