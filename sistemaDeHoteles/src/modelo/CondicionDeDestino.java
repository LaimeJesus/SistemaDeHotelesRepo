package modelo;


public class CondicionDeDestino extends Condicion{

	private String destino;
	
	public CondicionDeDestino(String destino){
		this.setCondicion(destino);
	}
	public void setCondicion(String destino){
		this.destino = destino;
	}
	public String getCondicion(){
		return this.destino;
	}

	@Override
	public boolean satisface(Habitacion h) {
		return h.getHotelNombreDeCiudad() == this.getCondicion();
	}


	

}
