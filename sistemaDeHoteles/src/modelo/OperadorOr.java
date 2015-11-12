package modelo;

public class OperadorOr extends Operador{
	
	public boolean operar(boolean x, boolean y){
		return x || y;
	}

	@Override
	public boolean neutro() {
		// TODO Auto-generated method stub
		return false;
	}

}
