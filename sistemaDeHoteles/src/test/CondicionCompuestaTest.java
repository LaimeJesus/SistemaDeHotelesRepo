package test;
import modelo.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import junit.framework.TestCase;

public class CondicionCompuestaTest extends TestCase{

	CamaSimple camaSimple;
	CamaDoble camaDoble;
	List<Cama> camas;
	List<Habitacion> habitaciones;
	Hotel hotel;
	Habitacion habitacion;
	CondicionDeHuespedes condicionDeHuespedes;
	ICondicionable condicionCompuestaHuespedesYNombre;
	ICondicionable condicionCompuestaDestinosCordobaYBsAs;
	CondicionDeDestino destinoBuenosAires;
	CondicionDeDestino destinoCordoba;
	OperadorAnd myand;
	OperadorOr myor;
	CondicionDeNombreDeHotel condicionDeNombre;

	@Before
	public void setUp(){
		camaSimple = new CamaSimple();
		camaDoble = new CamaDoble();
		camas = new ArrayList<Cama>();
		camas.add(camaSimple);
		camas.add(camaDoble);
		habitacion = new Habitacion(camas);
		condicionDeHuespedes = new CondicionDeHuespedes(3);

		habitaciones = new ArrayList<Habitacion>();
		habitaciones.add(habitacion);
		hotel = new Hotel("pepe", "Buenos Aires", habitaciones);

		myand = new OperadorAnd();
		myor = new OperadorOr();

		destinoBuenosAires = new CondicionDeDestino("Buenos Aires");
		destinoCordoba = new CondicionDeDestino("Cordoba");
		condicionDeNombre = new CondicionDeNombreDeHotel("pepe");
		condicionCompuestaHuespedesYNombre = condicionDeHuespedes.compose(condicionDeNombre, myand);
		condicionCompuestaDestinosCordobaYBsAs = destinoCordoba.compose(destinoBuenosAires, myor);
	}

	public void testVerSiUnaHabitacionSatisfaceUnaCondicionCompuestaPorUnAnd(){
		assertTrue(condicionCompuestaHuespedesYNombre.satisface(habitacion));
	}
	public void testVerSiUnaHabitacionSatisfaceUnaCondicionCompuestaPorUnOr(){
		assertTrue(condicionCompuestaDestinosCordobaYBsAs.satisface(habitacion));
	}
	
}
