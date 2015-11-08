package modelo;

import java.util.Date;

public class CondicionDeFecha extends Condicion{
	
	private Date fechaDeEntrada;
	private Date fechaDeSalida;
	
	public CondicionDeFecha(Date fEntrada, Date fSalida){
		this.setFechaInicial(fEntrada);
		this.setFechaSalida(fSalida);
	}
	
	public void setFechaInicial(Date f){
		this.fechaDeEntrada = f;
		
	}
	public void setFechaSalida(Date f){
		this.fechaDeSalida = f;
	}
	
	
	//arreglar y usar periodo desde un principio
	@Override
	public boolean satisface(Habitacion h) {
		return h.estaDisponible(new Periodo(this.getFechaDeEntrada(),this.getFechaDeSalida()));
	}

	private Date getFechaDeSalida() {
		return this.fechaDeSalida;
	}

	private Date getFechaDeEntrada() {
		// TODO Auto-generated method stub
		return this.fechaDeEntrada;
	}
}
