package modelo;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesus Laime, Lucas Fedele
 */
public abstract class Condicion {

	/**
	 * @param habitacion: es una Habitacion
	 * @return true si la habitacion cumple con esta condicion, false caso contrario
	 */
	public abstract boolean satisface(Habitacion habitacion);
	
	/**
	 * @param condicion: es una Condicion
	 * @return una CondicionCompuestaPorConjuncion
	 */
	public Condicion composeToConjuncion(Condicion condicion){
		return new CondicionDeConjuncion(this.crearGrupoDeCondicion(this,condicion));
	}
	
	/**
	 * @param condicion: es una Condicion
	 * @return una CondicionCompuestaPorDisjuncion
	 */
	public Condicion composeToDisjuncion(Condicion condicion){
		return new CondicionDeDisjuncion(this.crearGrupoDeCondicion(this, condicion));
	}
	
	/**
	 * @param condicion1: es una Condicion
	 * @param condition2: es una Condicion
	 * @return una Lista de Condicion
	 */
	public List<Condicion> crearGrupoDeCondicion(Condicion condicion1, Condicion condicion2) {
		List<Condicion> condiciones = new ArrayList<Condicion>();
		condiciones.add(condicion1);
		condiciones.add(condicion2);
		return condiciones;
	}
	
}
