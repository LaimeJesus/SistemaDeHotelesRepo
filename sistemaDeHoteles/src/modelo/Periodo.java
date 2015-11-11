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
		return fecha.isAfter(fechaInicio) && fechaFin.isAfter(fecha);
	}

	/*
	 * dice la cantidad de dias que hay en un periodo
	 */
	public Integer getCantidadDeDias() {
		return getFechasContenidas().size();
	}
	
	/*
	 * retorna una coleccion con todas las fechas contenidas en el periodo
	 */
	public List<DateTime> getFechasContenidas() {
		ArrayList<DateTime> dts = new ArrayList<DateTime>();
		DateTime curr = (DateTime) fechaInicio;
		
		while (!curr.equals(fechaFin)) {
			dts.add(curr);
			curr = nextDayInPeriodo(curr);
		}
		
		return dts;
	}

	/*
	 * dada una fecha curr, retorna la fecha que corresponde al dia siguiente
	 * NOTA: NO siempre se devuelve una fecha dentro del periodo
	 */
	private DateTime nextDayInPeriodo(DateTime curr) {
		return curr.plusDays(1);
	}

}
