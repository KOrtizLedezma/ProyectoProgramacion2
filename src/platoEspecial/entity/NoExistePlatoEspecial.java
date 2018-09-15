package platoEspecial.entity;

public class NoExistePlatoEspecial extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoExistePlatoEspecial (){
		super("No existe el Plato Especial");
	}

}
