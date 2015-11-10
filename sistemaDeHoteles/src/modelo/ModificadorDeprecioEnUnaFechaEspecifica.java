package modelo;

import org.joda.time.ReadableInstant;

public class ModificadorDeprecioEnUnaFechaEspecifica implements IModificadorDePrecio {

	private Object fecha;
	private Object modificacion;

	/*
	 * crea una nueva instancia de ModificadorDePrecioEnUnaFechaEspecifica en una
	 * fecha y con una modificacion
	 */
	public ModificadorDeprecioEnUnaFechaEspecifica(
			Object fecha, 
			Integer modificacion) {
		
		this.fecha = fecha;
		this.modificacion = modificacion;
	}

	@Override
	public Object getModificacion(ReadableInstant fecha) {
		// ver siperimplementor
		if (this.fecha == fecha) {
			return modificacion;
		}
		return 0;
	}

}