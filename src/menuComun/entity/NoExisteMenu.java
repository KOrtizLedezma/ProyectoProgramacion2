package menuComun.entity;

public class NoExisteMenu extends Exception {
private static final long serialVersionUID = 1L;
	
	public NoExisteMenu (){
		super("No existe el menu");
		System.out.println("No existe el Menu");
	}
}
