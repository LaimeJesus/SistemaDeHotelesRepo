package modelo;


import java.util.ArrayList;
import java.util.List;

public abstract class Condicion {


	public abstract boolean satisface(Habitacion h);
	
	public Condicion composeToConjuncion(Condicion c){
		return new CondicionDeConjuncion(this.crearGrupoDeCondicion(this,c));
	}
	public Condicion composeToDisjuncion(Condicion c){
		return new CondicionDeDisjuncion(this.crearGrupoDeCondicion(this, c));
	}
	
	public List<Condicion> crearGrupoDeCondicion(Condicion condicion, Condicion condition) {
		List<Condicion> condiciones = new ArrayList<Condicion>();
		condiciones.add(this);
		condiciones.add(condition);
		return condiciones;
	}
	
}
