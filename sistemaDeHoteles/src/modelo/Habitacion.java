package modelo;

public class Habitacion {
	private Hotel hotel;
	private Integer limiteHuespedes;
	
	public Habitacion(Hotel h, Integer limiteHuespedes){
		this.setHotel(h);
		this.setLimiteHuespedes(limiteHuespedes);
	}

	private void setLimiteHuespedes(Integer limiteHuespedes) {
		// TODO Auto-generated method stub
		this.limiteHuespedes = limiteHuespedes;
	}

	private void setHotel(Hotel h) {
		this.hotel = h;
	}

	public String getHotelName() {
		return this.getHotel().getName();
	}
	public String getHotelNombreDeCiudad(){
		return this.getHotel().getNombreDeCiudad();
	}

	public Hotel getHotel() {
		// TODO Auto-generated method stub
		return this.hotel;
	}
	//hay que arreglar
	public boolean estaDisponible(Periodo p) {
		// TODO Auto-generated method stub
		//hay que agregar cosas
		return true;
	}
	public Integer getLimiteDeHuespedes() {
		// TODO Auto-generated method stub
		return this.limiteHuespedes;
	}

}
