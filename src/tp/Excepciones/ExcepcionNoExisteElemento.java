package tp.Excepciones;

public class ExcepcionNoExisteElemento extends Exception{
	
	public ExcepcionNoExisteElemento() {
		super("No existe un elemento que coincida con ese identificador");
	}
}
