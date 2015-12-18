package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Fedele, Jesus Laime
 *
 */

public class BuscadorDeHoteles {

	private List<Hotel> hoteles = new ArrayList<Hotel>();
	private ArmadorDeResultado armador;
	
	/**
	 * @param hotel: es un Hotel
	 */
	public void agregarHotel(Hotel hotel) {
		hoteles.add(hotel);
	}

	/**
	 * @param ciudad
	 * @return los hoteles que 
	 */
	public List<Hotel> getHotelesPorCiudad(String ciudad) {
		List<Hotel> hs = new ArrayList<Hotel>();
		
		for (Hotel h : hoteles) {
			if (h.getNombreDeCiudad().equals(ciudad)) {
				hs.add(h);
			}
		}
		
		return hs;
	}

	/**
	 * @return la lista de hoteles que tiene el buscador 
	 */
	public List<Hotel> getHoteles() {
		return hoteles;
	}

	/**
	 * @param armador: un ArmadorDeResultado
	 */
	public void setArmadorDeResultado(ArmadorDeResultado armador) {
		this.armador = armador;
	}

	/**
	 * @param condicion: es una Condicion 
	 * @return una lista de Resultado que cumple la condicion
	 */
	public List<Resultado> getHotelesPorCondicion(Condicion condicion) {
		return armador.buscarAlternativas(hoteles, condicion);
	}

}
