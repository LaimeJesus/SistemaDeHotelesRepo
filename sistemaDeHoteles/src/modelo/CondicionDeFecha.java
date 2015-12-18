package modelo;

/**
 * @author Jesus Laime, Lucas Fedele
 *
 */

public class CondicionDeFecha extends Condicion{
	
	private Periodo periodo;
	
	/**
	 * @param p: es un periodo
	 */
	public CondicionDeFecha(Periodo p){
		this.setCondicion(p);
	}
		
	/**
	 * @param p: es un Periodo
	 */
	private void setCondicion(Periodo p) {
		this.periodo = p;
	}

	@Override
	public boolean satisface(Habitacion h) {
		return h.estaDisponible(this.getCondicion());
	}

	/**
	 * @return devuelve el Periodo de esta condicion
	 */
	private Periodo getCondicion() {
		return this.periodo;
	}
	
}
