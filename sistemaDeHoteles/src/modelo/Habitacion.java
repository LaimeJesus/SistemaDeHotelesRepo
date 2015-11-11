package modelo;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Habitacion {
	
	private Hotel hotel;
	private Integer limiteHuespedes;
	private Integer precioBase;
	private ArrayList<IModificadorDePrecio> modificadores = 
			new ArrayList<IModificadorDePrecio>();
	
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
	//hay que arreglarW
	public boolean estaDisponible(Periodo p) {
		// TODO Auto-generated method stub
		//hay que agregar cosas
		return true;
	}
	public Integer getLimiteDeHuespedes() {
		// TODO Auto-generated method stub
		return this.limiteHuespedes;
	}

	/*
	 * dice el precio en una fecha d
	 */
	public Integer getPrecioEn(DateTime d) {
		Integer precio = precioBase;
		
		for (IModificadorDePrecio m : modificadores) {
			precio = precio + m.getModificacion(d);
		}
		
		return precio;
	}

	public void setPrecioBase(Integer i) {
		this.precioBase = i;
	}

}
