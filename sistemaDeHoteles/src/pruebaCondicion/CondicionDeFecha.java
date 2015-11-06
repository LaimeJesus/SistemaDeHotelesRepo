package pruebaCondicion;

import java.util.Date;

public class CondicionDeFecha extends Condicion{
	
	private Date fechaDeEntrada;
	private Date fechaDeSalida;
	private int condicionEntrada;
	private int condicionSalida;
	
	public CondicionDeFecha(){
		this.condicionEntrada = 0;
		this.condicionSalida = 0;
	}
	
	public void setCondicionFechaInicial(Date f){
		this.fechaDeEntrada = f;
		this.condicionEntrada = 1;
		
	}
	public void setCondicionFechaFinal(Date f){
		this.fechaDeSalida = f;
		this.condicionSalida = 1;
	}

	@Override
	public boolean satisface(Hotel h) {
		boolean satisfy = true;
		if(this.condicionEntrada == 1){
			satisfy = satisfy && h.estaDisponibleDesde(this.fechaDeEntrada);
		}
		if(this.condicionSalida == 1){
			satisfy = satisfy && h.estaDisponibleHasta(this.fechaDeSalida);
		}
		return satisfy;
	}
}
