package test;

import java.util.ArrayList;
import junit.framework.TestCase;
import modelo.*;
public class ArmadorDeResultadoTest extends TestCase{
	
	ArmadorDeResultado armadorDeResultado;
	ArrayList<Hotel> hoteles;
	CondicionDeDestino condicionDestinoArgentina;
	CondicionDeDestino condicionDestinoUruguay;
	ArrayList<Habitacion> habitacionesHotel1;
	ArrayList<Habitacion> habitacionesHotel2;
	Hotel hotel1;
	Hotel hotel2;
	Habitacion habitacion1;
	Habitacion habitacion2;
	ICondicionable condicionCompuestaOrDestino;
	ICondicionable condicionCompuestaAndDestino;
	OperadorAnd myAnd;
	OperadorOr myOr;
	CamaSimple camaSimple;
	CamaDoble camaDoble;
	ArrayList<Cama> camas;
	CondicionDeNombre condicionDeNombre;
	ICondicionable condicionCompuestaAndDestinoYNombre;
	
	
	public void setUp(){
		armadorDeResultado = new ArmadorDeResultado();
		hoteles = new ArrayList<Hotel>();

		condicionDestinoArgentina = new CondicionDeDestino("Argentina");
		condicionDestinoUruguay = new CondicionDeDestino("Uruguay");
		myOr = new OperadorOr();
		myAnd = new OperadorAnd();
		condicionDeNombre = new CondicionDeNombre("Pepe");
		condicionCompuestaOrDestino = condicionDestinoArgentina.compose(condicionDestinoUruguay, myOr);
		condicionCompuestaAndDestinoYNombre = condicionDestinoUruguay.compose(condicionDeNombre, myAnd);
		habitacion1 = new Habitacion(null);
		habitacion2 = new Habitacion(null);


		habitacionesHotel1 = new ArrayList<Habitacion>();
		habitacionesHotel2 = new ArrayList<Habitacion>();
		habitacionesHotel1.add(habitacion1);
		habitacionesHotel2.add(habitacion2);


		hotel1 = new Hotel("Pepe", "Argentina", habitacionesHotel1);
		hotel2 = new Hotel("Pipi", "Uruguay", habitacionesHotel2);
		
		hoteles.add(hotel1);
		hoteles.add(hotel2);
	}
	
	public void testVerSiBuscarAlternativasEncuentraUnaHabitacionQueCumplaUnaCondicion(){
				
		assertEquals(1,armadorDeResultado.buscarAlternativas(hoteles,condicionDeNombre).size());
	}
	
	public void testVerSiBuscarAlternativasEncuentraUnaHabitacionQueCumplaAlMenosUnaCondicion(){
		
		assertEquals(2,armadorDeResultado.buscarAlternativas(hoteles,condicionCompuestaOrDestino).size());
	}

	public void testVerSiBuscarAlternativasNoEncuentraUnaNingunaHabitacionQueCumplaDosCondiciones(){
		assertEquals(0,armadorDeResultado.buscarAlternativas(hoteles, condicionCompuestaAndDestinoYNombre).size());
	}

}