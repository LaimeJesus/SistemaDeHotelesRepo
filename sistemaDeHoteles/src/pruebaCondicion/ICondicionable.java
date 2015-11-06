package pruebaCondicion;


public interface ICondicionable {

		public boolean satisface(Hotel h);
		public ICondicionable compose(ICondicionable ic);
}
