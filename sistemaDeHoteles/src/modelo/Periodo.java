package modelo;

import org.joda.time.ReadableInstant;

public class Periodo {

	private ReadableInstant fechaFin;
	private ReadableInstant fechaInicio;

	/*
	 * crea una nueva instancia de periodo con una fechaInicio y una fechaFin
	 */
	public Periodo(ReadableInstant fechaInicio, ReadableInstant fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	/*
	 * dice si una fecha pertenece al periodo
	 */
	public boolean perteneceAlPeriodo(ReadableInstant fecha) {
		// TODO Auto-generated method stub
		return fecha.isAfter(fechaInicio) && fechaFin.isAfter(fecha);
	}

}
