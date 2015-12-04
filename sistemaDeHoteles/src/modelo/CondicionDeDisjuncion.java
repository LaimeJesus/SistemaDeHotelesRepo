package modelo;

import java.util.List;

public class CondicionDeDisjuncion extends Condicion {

	public List<Condicion> condiciones;

	public CondicionDeDisjuncion(List<Condicion> mockList) {
		// TODO Auto-generated constructor stub
		this.condiciones = mockList;
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
