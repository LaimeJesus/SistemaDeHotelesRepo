package modelo;

import org.joda.time.ReadableInstant;

public class ModificadorDePrecioEnUnPeriodo implements IModificadorDePrecio {

	private Periodo periodo;
	private Integer modificacion;

	public ModificadorDePrecioEnUnPeriodo(
			ReadableInstant fechaInicio, 
			ReadableInstant fechaFin,
			Integer modificacion) {
		
		this.periodo = new Periodo(fechaInicio,fechaFin);
		this.modificacion = modificacion;
	}

	@Override
	public Integer getModificacion(ReadableInstant fecha) {
		if (periodo.perteneceAlPeriodo(fecha)) {
			return modificacion;
		}
		return 0;
	}

}
