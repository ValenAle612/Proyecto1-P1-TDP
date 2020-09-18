package TDALista;

/**
 * Modela el error ante una posicion invalida.
 */
public class InvalidPositionException extends Exception{
	/**
	 * inicializa el mensaje que se mostrara
	 * al querer acceder a una posicion invalida
	 * @param mmsg ensaje que mostrara al lanzarse la excepcion.
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}
}
