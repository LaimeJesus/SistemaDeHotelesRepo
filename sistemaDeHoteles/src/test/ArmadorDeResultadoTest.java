package test;

import java.util.ArrayList;
import junit.framework.TestCase;
import modelo.ArmadorDeResultado;
import modelo.CondicionDeDestino;
import modelo.Habitacion;
import modelo.Hotel;

public class ArmadorDeResultadoTest extends TestCase{
	
	ArmadorDeResultado armadorDeResultado;
	ArrayList<Hotel> hoteles;
	CondicionDeDestino condicion;
	ArrayList<Habitacion> habitacionesh1;
	ArrayList<Habitacion> habitacionesh2;
	Hotel hotel1;
	Hotel hotel2;
	Habitacion hab1;
	Habitacion hab2;
	
	public void setUp(){
		armadorDeResultado = new ArmadorDeResultado();
		hoteles = new ArrayList<Hotel>();
		condicion = new CondicionDeDestino("Argentina");
		habitacionesh1 = new ArrayList<Habitacion>();
		habitacionesh2 = new ArrayList<Habitacion>();

		hotel1 = new Hotel("Pepe", "Argentina", habitacionesh1);
		hotel2 = new Hotel("Pepe", "Uruguay", habitacionesh2);
		hab1 = new Habitacion(hotel1, 2);
		hab2 = new Habitacion(hotel2, 4);
		
		hotel1.agregarHabitacion(hab1);
		hotel2.agregarHabitacion(hab2);
		hoteles.add(hotel1);
		hoteles.add(hotel2);
	}
	
	public void testCuandoLeDicenBuscarAlternativasConUnaListaDeHotelesSiUnoSatisfaceUnaCondicionSutamanhoEsMayorA0(){
				
		assertEquals(1, armadorDeResultado.buscarAlternativas(hoteles , condicion).size());
	}
	
}
