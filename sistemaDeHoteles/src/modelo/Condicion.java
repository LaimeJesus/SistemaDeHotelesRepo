package modelo;


import java.util.ArrayList;
import java.util.List;

public abstract class Condicion implements ICondicionable{

	public abstract boolean satisface(Habitacion h);
	public ICondicionable compose(ICondicionable ic){
		List<ICondicionable> cs = new ArrayList<ICondicionable>();
		cs.add(this);
		cs.add(ic);
		return new CondicionCompuesta(cs);
	}
}
