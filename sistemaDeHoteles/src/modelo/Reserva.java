package modelo;

/**
 * @author Jesus Laime, Lucas Fedele
 *
 */
public class Reserva {

	private Habitacion habitacion;
	private Periodo periodo;
	private String usuario;
	/*
	 * crea una nueva instancia de reserva, que representa la reserva sobre una habitacion, en un periodo y
	 * hecha por un usuario
	 *
	 * @param habitacion: es una Habitacion
	 * @param periodo: es un Periodo
	 * @param usuario: es un String
	 */
	public Reserva(Habitacion habitacion, Periodo periodo, String usuario) {
		this.habitacion = habitacion;
		this.periodo = periodo;
		this.usuario = usuario;
	}

	/**
	 * @return el nombre del usuario que realizo la reserva
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @return el periodo en el cual se realizo la reserva
	 */
	public Periodo getPeriodo() {
		return periodo;
	}

	/**
	 * @return la habitacion que se reservo
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/*
	 * quita una reserva (this) en la habitacion a donde pertenece
	 */
	public void quitarReserva() {
		this.getHabitacion().quitarReserva(this);
	}

}
