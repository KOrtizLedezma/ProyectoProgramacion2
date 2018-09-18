package mesero.entity;

public class NoExisteMesero extends Exception{

private static final long serialVersionUID = 1L;
	
	public NoExisteMesero (){
		super("No existe el mesero");
	}
}
