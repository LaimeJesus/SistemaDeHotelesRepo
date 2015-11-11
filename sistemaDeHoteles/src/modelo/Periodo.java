package modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
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

	public List<DateTime> getFechasContenidas() {
		ArrayList<DateTime> dts = new ArrayList<DateTime>();
		DateTime curr = (DateTime) fechaInicio;
		
		while (!curr.equals(fechaFin)) {
			dts.add(curr);
			curr = nextDayInPeriodo(curr);
		}
		
		return dts;
	}

	private DateTime nextDayInPeriodo(DateTime curr) {
		return curr.plusDays(1);
	}

}
