package mesa.entity;

public class NoExisteMesa extends Exception {
private static final long serialVersionUID = 1L;
	
	public NoExisteMesa (){
		super("No existe la mesa");
	}
}
