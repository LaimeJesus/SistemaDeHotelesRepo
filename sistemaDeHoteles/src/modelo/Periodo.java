package modelo;
import java.util.Date;

public class Periodo {

	private Date fechaDeInicio;
	private Date fechaDeFinal;
	public Periodo(Date inicio, Date fin){
		this.setInicio(inicio);
		this.setFin(fin);
	}
	public void setInicio(Date f){
		this.fechaDeInicio = f;
	}
	public void setFin(Date f){
		this.fechaDeFinal = f;
	}
	
	public boolean estaEntre(Date t){
		return this.getInicio().after(t) && this.getFin().before(t);
	}
	private Date getFin() {
		// TODO Auto-generated method stub
		return this.fechaDeFinal;
	}
	private Date getInicio() {
		// TODO Auto-generated method stub
		return this.fechaDeInicio;
	}
}
