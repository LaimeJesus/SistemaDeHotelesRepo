package modelo;

import java.util.List;

public class CondicionCompuesta extends Condicion {
	
	private List<ICondicionable> condiciones;
	private Operador operador;
	
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

	private void setCondiciones(List<ICondicionable> cs){
		this.condiciones = cs;
	}
	private void setOperador(Operador op) {
		this.operador = op;
	}
	
	private Operador getOperador(){
		return this.operador;
	}


}
