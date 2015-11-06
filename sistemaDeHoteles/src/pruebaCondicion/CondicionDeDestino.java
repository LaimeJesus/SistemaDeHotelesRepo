package pruebaCondicion;


public class CondicionDeDestino extends Condicion{

	private String condicion;
	
	public void setCondicionDeNombre(String name){
		this.condicion = name;
	}
	public void setCondicionDeCiudad(String ciudad){
		this.condicion = ciudad;
	}
	@Override
	public boolean satisface(Hotel h) {
		// TODO Auto-generated method stub
		return h.getName() == this.condicion;
	}


	

}
