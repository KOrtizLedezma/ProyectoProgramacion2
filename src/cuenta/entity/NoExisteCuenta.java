package cuenta.entity;

public class NoExisteCuenta extends Exception {
private static final long serialVersionUID = 1L;
	
	public NoExisteCuenta (){
		super("No existe la cuenta");
	}
}
