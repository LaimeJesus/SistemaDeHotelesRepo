package modelo;

import java.util.List;

public class CondicionCompuesta extends Condicion {
	
	private List<ICondicionable> condiciones;
	
	public CondicionCompuesta(List<ICondicionable> cs, Operador op) {
		this.setCondiciones(cs);
		this.setOperador(op);
	}

	@Override
	public boolean satisface(Habitacion h) {
		boolean satisfy = this.getOperador().neutro();
		for(ICondicionable ic : this.getCondiciones()){
			satisfy = this.getOperador().operar(satisfy, ic.satisface(h));
		}
		return satisfy;
	}

	private List<ICondicionable> getCondiciones() {
		return this.condiciones;
	}

	public void setCondiciones(List<ICondicionable> cs){
		this.condiciones = cs;
	}

}
