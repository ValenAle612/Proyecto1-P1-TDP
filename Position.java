package TDALista;

/**
 * Posicion de un nodo con rotulo de tipo generico <E>.
 * @author laval
 *
 * @param <E>
 */
public interface Position<E> {
	
	/**
	 * Devuelve el elemento de la posicion
	 * @return Elemento de la posicion p
	 */
	public E element();
	
}
