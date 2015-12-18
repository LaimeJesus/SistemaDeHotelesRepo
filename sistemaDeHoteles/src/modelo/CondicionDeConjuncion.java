package modelo;

import java.util.List;

/**
 * @author Jesus Laime, Lucas Fedele
 *
 */
public class CondicionDeConjuncion extends Condicion {

	public List<Condicion> condiciones;

	/**
	 * @param grupoDeCondiciones: es una lista de Condicion
	 */
	public CondicionDeConjuncion(List<Condicion> grupoDeCondiciones) {
		// TODO Auto-generated constructor stub
		this.condiciones = grupoDeCondiciones;
	}

	@Override
	public boolean satisface(Habitacion h) {
		boolean satisfy = true;
		for(Condicion condition : this.condiciones){
			satisfy = satisfy && condition.satisface(h);
		}
		return satisfy;
	}

}
