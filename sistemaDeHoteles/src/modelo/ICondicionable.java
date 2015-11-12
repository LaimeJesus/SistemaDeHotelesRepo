package modelo;


public interface ICondicionable {

		public boolean satisface(Habitacion habitacion);
		public ICondicionable compose(ICondicionable ic, Operador op);
}
