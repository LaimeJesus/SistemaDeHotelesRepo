package modelo;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeHoteles {

	private List<Hotel> hoteles = new ArrayList<Hotel>();
	private ArmadorDeResultado armador;
	
	public void agregarHotel(Hotel hotel) {
		hoteles.add(hotel);
	}

	public List<Hotel> getHotelesPorCiudad(String ciudad) {
		List<Hotel> hs = new ArrayList<Hotel>();
		
		for (Hotel h : hoteles) {
			if (h.getNombreDeCiudad() == ciudad) {
				hs.add(h);
			}
		}
		
		return hs;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setArmadorDeResultado(ArmadorDeResultado armador) {
		this.armador = armador;
	}

	public List<Resultado> getHotelesPorCondicion(Condicion c) {
		return armador.buscarAlternativas(hoteles, c);
	}

}
