package TDALista;

/**
 * Nodo con rotulo de tipo generico <E> que tiene
 * acceso al nodo enlazado siguiente y previo.
 * @author Valentina A. Navarro Fernandez.
 *
 * @param <E>
 */
public class DNodo<E> implements Position<E>{
	private E elemento;
	private DNodo<E> previo, siguiente;
	
	//Constructores 
	/**
	 * Se crea un nodo no vacio, enlazado a su nodo siguiente y a su nodo previo.
	 * @param item Elemento de tipo generico
	 * @param ant Nodo anterior al actual
	 * @param sig	Nodo siguiente al actual
	 */
			public DNodo(E item, DNodo<E> ant, DNodo<E> sig) {
				elemento=item; 
				siguiente=sig;	
				previo=ant;
			}
			/**
			 * Inicia el elemento del nodo con item e inicializa el nodo siguiente y al previo como nulos.
			 * @param item elemento de tipo generico
			 */
			public DNodo(E item) {
				this(item,null,null);			
			}

		//Setters
			/**
			 * Le asigna al elemento del nodo, el elemento pasado por parámetro.
			 * @param elemento Elemento de tipo generico
			 */
			public void setElemento(E elemento) {
				this.elemento=elemento;
			}
			/**
			 * Le asigna como nodo siguiente, el nodo pasado por parámetro.
			 * @param siguiente Nodo siguiente al actual
			 */
			public void setSiguiente(DNodo<E> siguiente) {
				this.siguiente=siguiente;
			}
			/**
			 *Le asigna como nodo previo, el nodo pasado por paramétro.
			 * @param prev Nodo previo al actual
			 */
			public void setPrevio(DNodo<E> prev) {
				this.previo=prev;
			}
			
		//Getter
			@Override
			public E element() {
				return elemento;
			}
			/**
			 * Se obtiene el nodo siguiente al nodo actual
			 * @return El nodo siguiente al nodo actual.
			 */
			public DNodo<E> getSiguiente(){
				return siguiente;
			}
			/**
			 * Se obtiene el nodo previo al nodo actual
			 * @return El nodo previo al nodo actual.
			 */
			public DNodo<E> getPrevio(){
				return previo;
			}
			
}
