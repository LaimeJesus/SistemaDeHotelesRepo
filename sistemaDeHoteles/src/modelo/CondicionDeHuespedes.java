package modelo;

public class CondicionDeHuespedes extends Condicion{

	private Integer condicion;
	public CondicionDeHuespedes(Integer cantidad){
		this.setCondicion(cantidad);
	}
	public void setCondicion(Integer cantidad) {
		this.condicion = cantidad;
	}
	@Override
	public boolean satisface(Habitacion h) {
		return h.getLimiteDeHuespedes().equals(this.getCondicion());
	}
	public Integer getCondicion(){
		return this.condicion;
	}

}
