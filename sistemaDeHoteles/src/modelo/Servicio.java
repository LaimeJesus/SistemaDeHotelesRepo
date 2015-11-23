package modelo;

public class Servicio {

	private String descripcion;
	private Integer precio;
	private String nombre;

	public Servicio(String nombre, String descripcion, Integer precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}

	public Integer getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}

}
