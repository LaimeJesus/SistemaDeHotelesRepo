package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.ArmadorDeResultado;
import modelo.BuscadorDeHoteles;
import modelo.Condicion;
import modelo.CondicionDeDestino;
import modelo.CondicionDeHuespedes;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.Resultado;

public class BuscadorDeHotelesTest {
	
	BuscadorDeHoteles buscador;
	
	Hotel hotel1;
	Hotel hotel2;
	
	@Before
	public void setup() {
		buscador = new BuscadorDeHoteles();
		
		hotel1 = mock(Hotel.class);
		hotel2 = mock(Hotel.class);
		
		buscador.agregarHotel(hotel1);
		buscador.agregarHotel(hotel2);
	}

	@Test
	public void test_verQuePuedoObtenerLosHotelesDeUnaCiudad() {
		when(hotel1.getNombreDeCiudad()).thenReturn("alta city papa");
		when(hotel2.getNombreDeCiudad()).thenReturn("que ondaaaa");
		
		assertEquals(1,buscador.getHotelesPorCiudad("alta city papa").size());
	}
	
	@Test
	public void test_verQuePuedoObtenerLosHotelesDeUnaCiudadPorUnaCondicion() {
		Condicion c1 = mock(CondicionDeDestino.class);
		ArmadorDeResultado armador = mock(ArmadorDeResultado.class);
		Resultado r1 = mock(Resultado.class);
		List<Resultado> l1 = new ArrayList<Resultado>(); l1.add(r1);
		when(armador.buscarAlternativas(buscador.getHoteles(), c1)).thenReturn(l1);
		buscador.setArmadorDeResultado(armador);
		assertEquals(1,buscador.getHotelesPorCondicion(c1).size());
	}

}
