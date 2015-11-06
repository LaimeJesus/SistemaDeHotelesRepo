package pruebaCondicion;

import java.util.List;

public class CondicionCompuesta extends Condicion {
	
	private List<ICondicionable> condiciones;
	
	public CondicionCompuesta(List<ICondicionable> cs) {
		this.setCondiciones(cs);
	}

	@Override
	public boolean satisface(Hotel h) {
		boolean satisfy = true;
		for(ICondicionable ic : this.getCondiciones()){
			satisfy = satisfy && ic.satisface(h);
		}
		return satisfy;
	}

	private List<ICondicionable> getCondiciones() {
		// TODO Auto-generated method stub
		return this.condiciones;
	}

	public void setCondiciones(List<ICondicionable> cs){
		this.condiciones = cs;
	}

}
