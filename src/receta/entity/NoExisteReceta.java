package receta.entity;

public class NoExisteReceta extends Exception{

	
    private static final long serialVersionUID = 1L;
	
	public NoExisteReceta (){
		super("No existe la Receta");
	}
}
