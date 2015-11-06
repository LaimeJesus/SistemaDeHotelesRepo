package pruebaCondicion;

import java.util.Collection;
import java.util.Date;

public class Hotel {

	public String ciudad;
	public Collection<Integer> habitaciones;
	public String name;
	public Integer cantidadDeHuespedes;
	
	public Hotel(String name, String ciudad, Collection<Integer> habitaciones, Integer huespedes){
		this.ciudad = ciudad;
		this.habitaciones = habitaciones;
		this.name = name;
		this.cantidadDeHuespedes = huespedes;
	}
	
	public String getCiudad(){
		return this.ciudad;
	}
	public String getName(){
		return this.name;
	}
	public Collection<Integer> getHoteles(){
		return this.habitaciones;
	}

	public boolean estaDisponibleDesde(Date fechaDeEntrada) {
		return true;
	}

	public boolean estaDisponibleHasta(Date fechaDeSalida) {
		return true;
	}
}
