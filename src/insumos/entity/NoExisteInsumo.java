package insumos.entity;

public class NoExisteInsumo extends Exception {
private static final long serialVersionUID = 1L;
	
	public NoExisteInsumo (){
		super("No existe el insumo");
	}
}
