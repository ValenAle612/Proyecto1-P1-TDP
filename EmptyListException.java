package TDALista;

/**
 * Modela el error ante la manipulacion de
 * una lista vacía.
 */
public class EmptyListException extends Exception{
	/**
	 * inicializa el mensaje que se mostrara
	 * al manipularse una lista vacia en un caso no deseado
	 * @param msg mensaje que mostrara al lanzarse la excepcion
	 */
	public EmptyListException(String msg, String adios) {
		super(msg);
	}
}
