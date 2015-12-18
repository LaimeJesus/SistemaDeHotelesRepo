package modelo;


/**
 * @author Jesus Laime, Lucas Fedele
 *
 */
public class CondicionDeDestino extends Condicion{

	private String destino;
	
	/**
	 * @param destino: es un String
	 */
	public CondicionDeDestino(String destino){
		this.setCondicion(destino);
	}
	/**
	 * @param destino: es un String
	 */
	public void setCondicion(String destino){
		this.destino = destino;
	}
	/**
	 * @return el nombre del destino
	 */
	public String getCondicion(){
		return this.destino;
	}

	@Override
	public boolean satisface(Habitacion h) {
		return this.getCondicion().contains(h.getHotelNombreDeCiudad());
	}


	

}
