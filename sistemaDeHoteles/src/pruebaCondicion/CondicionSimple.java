package pruebaCondicion;

abstract class CondicionSimple{
	
	private String condicion;
	public CondicionSimple(String g){
		this.condicion = g;
	}
	
	public String getCondicion(){
		return this.condicion;
	}
}
