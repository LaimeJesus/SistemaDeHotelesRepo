package modelo;

public class CondicionDeNombre extends Condicion{

	private String condicionNombre;

	
	public CondicionDeNombre(String nombre) {
		this.setCondicion(nombre);
	}

	private void setCondicion(String nombre) {
		// TODO Auto-generated method stub
		this.condicionNombre = nombre;
	}

	@Override
	public boolean satisface(Habitacion h) {
		// TODO Auto-generated method stub
		return this.getNombre() == h.getHotelName();
	}

	private String getNombre() {
		// TODO Auto-generated method stub
		return this.condicionNombre;
	}

}
