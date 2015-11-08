package test;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;

import junit.framework.TestCase;
import modelo.CondicionDeDestino;
import modelo.CondicionDeFecha;
import modelo.CondicionDeHuespedes;
import modelo.CondicionDeNombre;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.ICondicionable;

public class CondicionesTest extends TestCase{

	ArrayList<Habitacion> list;
	Hotel hotel;
	Habitacion habitacion;
	Date f1;
	Date f2;
	CondicionDeDestino condicionDeDestino;
	CondicionDeFecha condicionDeFecha;
	CondicionDeNombre condicionDeNombre;
	CondicionDeHuespedes condicionDeHuespedes;
	ICondicionable condicionCompuesta;

	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp(){
		condicionDeDestino = new CondicionDeDestino("Buenos Aires");
		list = new ArrayList<Habitacion>();
		hotel = new Hotel("pepe", "Buenos Aires", list);
		habitacion = new Habitacion(hotel,4);
		f1 = new Date(2010, 10, 15);
		f2 = new Date(2011, 1, 1);
		condicionDeFecha = new CondicionDeFecha(f1,f2);
		condicionDeNombre = new CondicionDeNombre("pepe");
		condicionDeHuespedes = new CondicionDeHuespedes(4);
		condicionDeHuespedes.setCondicion(4);
		condicionCompuesta = condicionDeFecha.compose(condicionDeNombre).compose(condicionDeHuespedes).compose(condicionDeDestino);

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
}
