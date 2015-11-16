package test;

import java.util.ArrayList;
import junit.framework.TestCase;
import modelo.ArmadorDeResultado;
import modelo.CondicionDeDestino;
import modelo.Habitacion;
import modelo.Hotel;

public class ArmadorDeResultadoTest extends TestCase{
	
	public void testCuandoLeDicenBuscarAlternativasConUnaListaDeHotelesSiUnoSatisfaceUnaCondicionSutamanhoEsMayorA0(){
		ArmadorDeResultado armadorDeResultado = new ArmadorDeResultado();
		ArrayList<Hotel> lista = new ArrayList<Hotel>();
		CondicionDeDestino condicion = new CondicionDeDestino("Argentina");
		ArrayList<Habitacion> listahab1 = new ArrayList<Habitacion>();
		ArrayList<Habitacion> listahab2 = new ArrayList<Habitacion>();

		Hotel h1 = new Hotel("Pepe", "Argentina", listahab1);
		Hotel h2 = new Hotel("Pepe", "Uruguay", listahab2);
		Habitacion hab1 = new Habitacion(h1, 2);
		Habitacion hab2 = new Habitacion(h2, 4);
		
		listahab1.add(hab1);
		listahab2.add(hab2);
		lista.add(h1);
		lista.add(h2);
		
		assertEquals(1, armadorDeResultado.buscarAlternativas(lista , condicion).size());
	}

}
