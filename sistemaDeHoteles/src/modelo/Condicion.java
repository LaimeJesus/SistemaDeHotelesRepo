package modelo;


import java.util.ArrayList;
import java.util.List;

public abstract class Condicion implements ICondicionable{

	private Operador operador;
	
	public abstract boolean satisface(Habitacion h);
	public ICondicionable compose(ICondicionable ic, Operador op){
		List<ICondicionable> cs = new ArrayList<ICondicionable>();
		cs.add(this);
		cs.add(ic);
		return new CondicionCompuesta(cs, op);
	}
	public void setOperador(Operador op) {
		this.operador = op;
	}
	public Operador getOperador(){
		return this.operador;
	}
}
