package modelo;

import java.util.List;

/**
 * @author Jesus Laime, Lucas Fedele
 *
 */

public class CondicionDeDisjuncion extends Condicion {

	public List<Condicion> condiciones;

	/**
	 * @param grupoDeCondiciones: es una lista de condiciones
	 */
	public CondicionDeDisjuncion(List<Condicion> grupoDeCondiciones) {
		// TODO Auto-generated constructor stub
		this.condiciones = grupoDeCondiciones;
	}

	@Override
	public boolean satisface(Habitacion h) {
		boolean satisfy = false;
		for(Condicion condition : this.condiciones){
			satisfy = satisfy || condition.satisface(h);
		}
		return satisfy;
	}

}
