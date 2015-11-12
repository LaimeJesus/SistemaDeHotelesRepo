package modelo;

public class CondicionDeFecha extends Condicion{
	
	private Periodo periodo;
	
	public CondicionDeFecha(Periodo p){
		this.setCondicion(p);
	}
		
	private void setCondicion(Periodo p) {
		this.periodo = p;
	}

	//arreglar y usar periodo desde un principio
	@Override
	public boolean satisface(Habitacion h) {
		return h.estaDisponible(this.getCondicion());
	}

	private Periodo getCondicion() {
		return this.periodo;
	}
	
}
