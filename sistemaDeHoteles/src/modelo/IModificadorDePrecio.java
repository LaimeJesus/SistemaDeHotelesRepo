package modelo;

import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;

public interface IModificadorDePrecio {

	/*
	 * obtiene la modificacion del precio segun una fecha
	 */
	public Object getModificacion(ReadableInstant localDate);

}
