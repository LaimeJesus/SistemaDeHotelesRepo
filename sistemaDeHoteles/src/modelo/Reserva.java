package modelo;

public class Reserva {

	private Habitacion habitacion;
	private Periodo periodo;
	private String usuario;

	/*
	 * crea una nueva instancia de reserva, que representa la reserva sobre una habitacion, en un periodo y
	 * hecha por un usuario
	 */
	public Reserva(Habitacion habitacion, Periodo periodo, String usuario) {
		this.habitacion = habitacion;
		this.periodo = periodo;
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

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
