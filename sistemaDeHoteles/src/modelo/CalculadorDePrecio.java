package modelo;

import org.joda.time.DateTime;

public class CalculadorDePrecio {

	public Object calcularPrecio(Periodo periodo, Habitacion habitacion) {
		Integer precio = 0;
		for (DateTime d : periodo.getFechasContenidas()) {
			precio = precio + habitacion.getPrecioEn(d);
		}
		return precio;
	}

}
