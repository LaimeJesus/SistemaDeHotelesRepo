package test;
import modelo.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class CondicionCompuestaTest extends TestCase{

	//necesito cambiar los test pero no llego a ver como asi que dsp lo veo
	Habitacion mock_habitacion;
	CondicionDeHuespedes mockCondicionDeHuespedes;
	CondicionDeNombreDeHotel mockCondicionDeNombre;
	
	ICondicionable sutHuespedesNombreAND;
	ICondicionable sutHuespedesNombreOR;
	OperadorAnd myMockAnd;
	OperadorOr myMockOr;
	List<ICondicionable> mockList;


	@Before
	public void setUp(){
		//las condiciones
		mockCondicionDeHuespedes = Mockito.mock(CondicionDeHuespedes.class);
		mockCondicionDeNombre = Mockito.mock(CondicionDeNombreDeHotel.class);
		
		//la habitacion
		mock_habitacion = Mockito.mock(Habitacion.class);
	
		//los operadores
		myMockAnd = Mockito.mock(OperadorAnd.class);
		myMockOr = Mockito.mock(OperadorOr.class);
		
		//la lista de condiciones
		mockList = new ArrayList<ICondicionable>();
		mockList.add(mockCondicionDeHuespedes);
		mockList.add(mockCondicionDeNombre);
		
		//los sistemas a testear
		sutHuespedesNombreAND = new CondicionCompuesta(mockList, myMockAnd);
		sutHuespedesNombreOR = new CondicionCompuesta(mockList, myMockOr);
	}
	public void testVeoQueCadaCondicionEnvioElMensajeSatisface(){

		sutHuespedesNombreOR.satisface(mock_habitacion);
		sutHuespedesNombreAND.satisface(mock_habitacion);
		Mockito.verify(mockCondicionDeHuespedes, Mockito.atLeastOnce()).satisface(mock_habitacion);
		Mockito.verify(mockCondicionDeNombre, Mockito.atLeastOnce()).satisface(mock_habitacion);

	}
	
	public void testVeoQueSeCargoElNeutroDeLaOperacion(){
		sutHuespedesNombreOR.satisface(mock_habitacion);
		sutHuespedesNombreAND.satisface(mock_habitacion);
		
		Mockito.verify(myMockAnd).neutro();
		Mockito.verify(myMockOr).neutro();
	}
	
	public void testVeoQueLosOperadoresOperaronAlMenosUnaVez(){
		
		Mockito.when(myMockAnd.neutro()).thenReturn(true);
		Mockito.when(myMockOr.neutro()).thenReturn(false);
		
		sutHuespedesNombreOR.satisface(mock_habitacion);
		sutHuespedesNombreAND.satisface(mock_habitacion);
		
		Mockito.verify(myMockAnd, Mockito.atLeastOnce()).operar(true, mockCondicionDeHuespedes.satisface(mock_habitacion));
		Mockito.verify(myMockAnd, Mockito.atLeastOnce()).operar(true, mockCondicionDeNombre.satisface(mock_habitacion));
		
		Mockito.verify(myMockOr, Mockito.atLeastOnce()).operar(false, mockCondicionDeHuespedes.satisface(mock_habitacion));
		Mockito.verify(myMockOr, Mockito.atLeastOnce()).operar(false, mockCondicionDeNombre.satisface(mock_habitacion));
	}
	
	public void testCasoBordeListaDeCondicionesVacia(){
		mockList= new ArrayList<ICondicionable>();
		sutHuespedesNombreAND = new CondicionCompuesta(mockList, myMockAnd);
		sutHuespedesNombreOR = new CondicionCompuesta(mockList, myMockOr);
	
		sutHuespedesNombreOR.satisface(mock_habitacion);
		sutHuespedesNombreAND.satisface(mock_habitacion);
		
		Mockito.verify(myMockAnd, Mockito.never()).operar(true, mockCondicionDeHuespedes.satisface(mock_habitacion));
		Mockito.verify(myMockAnd, Mockito.never()).operar(true, mockCondicionDeNombre.satisface(mock_habitacion));
		
		Mockito.verify(myMockOr, Mockito.never()).operar(false, mockCondicionDeHuespedes.satisface(mock_habitacion));
		Mockito.verify(myMockOr, Mockito.never()).operar(false, mockCondicionDeNombre.satisface(mock_habitacion));
	}
}
