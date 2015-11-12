package test;

import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.junit.Before;

import junit.framework.TestCase;
import modelo.CondicionCompuesta;
import modelo.CondicionDeDestino;
import modelo.CondicionDeFecha;
import modelo.CondicionDeHuespedes;
import modelo.CondicionDeNombre;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.ICondicionable;
import modelo.OperadorAnd;
import modelo.OperadorOr;
import modelo.Periodo;

public class CondicionesTest extends TestCase{

	ArrayList<Habitacion> list;
	Hotel hotel;
	Habitacion habitacion;
	ReadableInstant f1;
	ReadableInstant f2;
	CondicionDeDestino condicionDeDestino;
	CondicionDeFecha condicionDeFecha;
	CondicionDeNombre condicionDeNombre;
	CondicionDeHuespedes condicionDeHuespedes;
	ICondicionable condicionCompuesta;
	OperadorAnd myand;
	CondicionDeDestino condicionDestino2;
	CondicionDeDestino condicionDestino3;
	OperadorOr myor;
	ICondicionable cp3;
	
	@Before
	public void setUp(){
		list = new ArrayList<Habitacion>();
		hotel = new Hotel("pepe", "Buenos Aires", list);
		habitacion = new Habitacion(hotel,4);
		f1 = new DateTime(2010, 10, 15, 1 ,1);
		f2 = new DateTime(2011, 1, 1, 1, 1);
		condicionDeDestino = new CondicionDeDestino("Buenos Aires");
		condicionDeFecha = new CondicionDeFecha(new Periodo(f1,f2));
		condicionDeNombre = new CondicionDeNombre("pepe");
		condicionDeHuespedes = new CondicionDeHuespedes(4);
		condicionDeHuespedes.setCondicion(4);
		myand = new OperadorAnd();
		condicionCompuesta = condicionDeFecha.compose(condicionDeNombre, myand).compose(condicionDeHuespedes, myand).compose(condicionDeDestino, myand);
		condicionDestino2 = new CondicionDeDestino("Buenos Aires");
		condicionDestino3 = new CondicionDeDestino("Cordoba");
		myor = new OperadorOr();
		cp3 = condicionDestino2.compose(condicionDestino3, myor);
		
	}

	public void testCuandoPreguntoSiUnaHabitacionDeUnHotelEnBuenosAiresSatisfaceUnaCondicionDeLugarDeBuenosAiresEntoncesEsteEsVerdadero(){
		assertTrue(condicionDeDestino.satisface(habitacion));
	}
	public void testCuandoPreguntoSiUnaHabitacionEstaDisponibleEntreDosFechasEstoDaVerdadero(){
		
		assertTrue(condicionDeFecha.satisface(habitacion));
	}
	public void testCuandoPreguntoSiUnaHabitacionSatisfaceUnaCondicionDeNombreDeHotelEstaDaVerdadero(){

		assertTrue(condicionDeNombre.satisface(habitacion));
	}
	public void testCuandoPreguntoSiUnaHabitacionSatisfaceUnaCondicionDeCantidadDeHuespedesEsteRespondeAlgo(){
		assertTrue(condicionDeHuespedes.satisface(habitacion));
	}
	public void testCuandoPreguntoSiUnaHabitacionSatisfaceUnaCondicionCompuestaEstoDaVerdadero(){
		assertTrue(condicionCompuesta.satisface(habitacion));
	}
	public void testCuandoPreguntoSiUnaHabitacionSatisfaceUnaCondicionCompuestaConOperadorOrEsVerdaderoAlgunaDeLasCondiciones(){
		assertTrue(cp3.satisface(habitacion));
	}
	
}
