package test;

import modelo.Condicion;
import org.mockito.Mockito;
import junit.framework.TestCase;

public class CondicionTest extends TestCase{
		
	
	//no estoy seguro si se puede testear una clase abstracta.
	//tube un problema para testear el mensaje crearGrupoDeCondicion cuando se envia compose por eso no lo testee
	//en cada uno de los compose
	private Condicion sutAzar;
	private Condicion sutRandom;
	

	public void setUp(){
		sutRandom = Mockito.mock(Condicion.class);
		sutAzar = Mockito.mock(Condicion.class);	
	}
	public void testComposeDeConjuncion(){
		sutRandom.composeToConjuncion(sutAzar);
		Mockito.verify(sutRandom).composeToConjuncion(sutAzar);
		
	}
	public void testComposeDeDisjuncion(){
		sutRandom.composeToDisjuncion(sutAzar);
		Mockito.verify(sutRandom).composeToDisjuncion(sutAzar);
	}
	public void testQueCondicionArmaElGrupoDeCondicion(){
		sutRandom.crearGrupoDeCondicion(sutRandom, sutAzar);
		Mockito.verify(sutRandom).crearGrupoDeCondicion(sutRandom, sutAzar);

	}
}
