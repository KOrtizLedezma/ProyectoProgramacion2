package plato.entity;

public class NoExistePlato extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoExistePlato (){
		super("No existe el Plato");
	}

}
