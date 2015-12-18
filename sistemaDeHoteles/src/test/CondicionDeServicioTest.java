package test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import modelo.CondicionDeNombreDeHotel;
import modelo.CondicionDeServicio;
import modelo.Habitacion;
import modelo.Servicio;

public class CondicionDeServicioTest extends TestCase{
	

	//esta condicion tiene como objetivo ver si una habitacion pertenece a un hotel que tenga ese nombre.
	CondicionDeServicio sut;
	Habitacion mockHabitacion;
	private Servicio mockServicio;
	private List<Servicio> mockListaDeServicios;
	
	public void setUp(){
		mockServicio = mock(Servicio.class);
		sut = new CondicionDeServicio(mockServicio);
		mockHabitacion = mock(Habitacion.class);
		
		mockListaDeServicios = new ArrayList<Servicio>(); 
		mockListaDeServicios.add(mockServicio);

	}
	
	public void testVeoSiUnaHabitacionSatisfaceUnaCondicionDeServicio(){
		//arrange
		when(mockHabitacion.getServicios()).thenReturn(mockListaDeServicios);
		
		//verify
		assertTrue(sut.satisface(mockHabitacion));
		verify(mockHabitacion).getServicios();
	}


	public void testVeoQueUnaHabitacionNoSatisfagaUnaCondicionDeServicio(){
		//arrange
		//Uso este mock para ver que una habitacion envie el metodo getHotelName y que devuelve hotel_name_not_expected
		when(mockHabitacion.getServicios()).thenReturn(new ArrayList<Servicio>());
		
		//verify
		assertFalse(sut.satisface(mockHabitacion));
		verify(mockHabitacion).getServicios();
		verify(mockHabitacion).verHotelTieneServicio(sut.getCondicion());
	}

}
