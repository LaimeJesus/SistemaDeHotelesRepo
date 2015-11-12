package modelo;

public class CondicionDeNombre extends Condicion{

	private String condicionNombre;

	
	public CondicionDeNombre(String nombre) {
		this.setCondicion(nombre);
	}

	private void setCondicion(String nombre) {
		this.condicionNombre = nombre;
	}

	@Override
	public boolean satisface(Habitacion h) {
		return h.getHotelName().equals((this.getCondicion()));
	}

	private String getCondicion() {
		return this.condicionNombre;
	}

}
