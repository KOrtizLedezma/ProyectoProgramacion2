package menuDia.entity;

public class NoExisteMenuDia extends Exception {
private static final long serialVersionUID = 1L;
	
	public NoExisteMenuDia (){
		super("No existe el menu del dia");
		System.out.println("No existe el Menu");
	}
}
