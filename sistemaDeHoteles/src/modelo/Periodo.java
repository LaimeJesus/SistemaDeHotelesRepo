package modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

/**
 * @author Jesus Laime, Lucas Fedele
 *
 */
public class Periodo {

	
	private ReadableInstant fechaFin;
	private ReadableInstant fechaInicio;

	/*
	 * crea una nueva instancia de periodo con una fechaInicio y una fechaFin
	 */
	
	public Periodo(ReadableInstant f){
		this.fechaInicio = f;
		this.fechaFin = f;
	}
	
	public Periodo(ReadableInstant fechaInicio, ReadableInstant fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	/*
	 * dice si una fecha pertenece al periodo
	 */
	/**
	 * @param fecha: es una fecha que implemente la interfaz ReadableInstant
	 * @return true si la fecha esta entre el inicio y fin del periodo, false caso contrario
	 */
	public boolean perteneceAlPeriodo(ReadableInstant fecha) {
		return fecha.isAfter(fechaInicio) && fechaFin.isAfter(fecha);
	}

	/**
	 * @return dice la cantidad de dias que hay en un periodo
	 */
	public Integer getCantidadDeDias() {
		return getFechasContenidas().size();
	}

	/**
	 * @return retorna una coleccion con todas las fechas contenidas en el periodo
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

	/**
	 * @param periodo: es un Periodo
	 * @return si periodo coincide con este periodo
	 */
	public Boolean coincideCon(Periodo periodo) {
		return !(periodo.getFechaFin().isAfter(fechaFin) || fechaInicio.isAfter(periodo.getFechaFin()));
	}

	
	/**
	 * @return la fecha de fin
	 */
	public ReadableInstant getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * @return la fecha de inicio
	 */
	public ReadableInstant getFechaInicio() {
		return fechaInicio;
	}



}
