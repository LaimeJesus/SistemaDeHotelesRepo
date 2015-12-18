package modelo;

public class CondicionDeServicio extends Condicion{

	private Servicio condicion;

	public CondicionDeServicio(Servicio s){
		this.condicion = s;
	}
	
	@Override
	public boolean satisface(Habitacion habitacion) {
		// TODO Auto-generated method stub
		return habitacion.getServicios().contains(this.condicion) || habitacion.verHotelTieneServicio(this.condicion);
	}

	public Servicio getCondicion() {
		// TODO Auto-generated method stub
		return this.condicion;
	}

}
