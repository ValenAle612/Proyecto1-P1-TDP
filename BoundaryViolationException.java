package TDALista;

/**
 * Modela el error ante el acceso a una posicion
 * que esta fuera del limite.
 */
public class BoundaryViolationException extends Exception{
	/**
	 * inicializa el mensaje que se mostrara al 
	 * querer acceder a una posicion fuera del limite
	 * @param mensaje que sera mostrado al lanzarse la excepcion
	 */
	public BoundaryViolationException(String msg){
		super(msg);
	}
}
