package pruebaCondicion;

public class CondicionDeHuespedes extends Condicion{

	private Integer condicion;
	public CondicionDeHuespedes(Integer cantidad){
		this.condicion = cantidad;
	}
	@Override
	public boolean satisface(Hotel h) {
		return h.cantidadDeHuespedes == this.condicion;
	}

}
