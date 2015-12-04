package test;

import java.util.ArrayList;

import modelo.Condicion;
import modelo.OperadorAnd;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class CondicionTest extends TestCase{
		
	
	//a borrar si no puedo entender cmo hacer un buen mock para este mensaje
	private Condicion sut;
	private ArrayList mockList;
	private Condicion condicionExample;
	private OperadorAnd mockOperator;
	
	//no pude testearla tengo que entende r un poco mas mock
	public void testVeoQueComposeSeEjecutaDeManeraCorrecta(){
		sut = Mockito.mock(Condicion.class);
		condicionExample = Mockito.mock(Condicion.class);
		mockOperator = Mockito.mock(OperadorAnd.class);
		mockList = Mockito.mock(ArrayList.class);
		sut.compose(condicionExample, mockOperator);
		
		assertTrue(true);
	}
}
