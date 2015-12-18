package modelo;
/**
 * @author Jesus Laime, Lucas Fedele
 *
 */
public class Servicio {

	private String descripcion;
	private Integer precio;
	private String nombre;

	/**
	 * @param nombre: es un String
	 * @param descripcion: es un String
	 * @param precio: es un Integer
	 */
	public Servicio(String nombre, String descripcion, Integer precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	/**
	 * @return el nombre del servicio
	 */
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	/**
	 * @return la descripcion del servicio
	 */
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}

	/**
	 * @return el precio del servicio
	 */
	public Integer getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}

}
