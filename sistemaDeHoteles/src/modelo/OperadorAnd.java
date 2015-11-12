package modelo;

public class OperadorAnd extends Operador {

	@Override
	public boolean operar(boolean x, boolean y) {
		// TODO Auto-generated method stub
		return x && y;
	}

	@Override
	public boolean neutro() {
		// TODO Auto-generated method stub
		return true;
	}

}
