package modelo;

import java.util.Date;

public class CondicionDeFecha extends Condicion{
	
	private Periodo periodo;
	
	public CondicionDeFecha(Periodo p){
		this.setCondicion(p);
	}
		
	private void setCondicion(Periodo p) {
		// TODO Auto-generated method stub
		this.periodo = p;
	}

	//arreglar y usar periodo desde un principio
	@Override
	public boolean satisface(Habitacion h) {
		return h.estaDisponible(this.getCondicion());
	}

	private Periodo getCondicion() {
		// TODO Auto-generated method stub
		return this.periodo;
	}
	
}
