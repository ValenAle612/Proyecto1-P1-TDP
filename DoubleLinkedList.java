package TDALista;

import java.util.Iterator;

/**
 * Crea una lista enlazada con posiciones donde cada una de ellas
 * posee acceso a la posicion anterior y la posicion posterior de la misma.
 * @author Valentina A. Navarro Fernandez
 *
 * @param <E> tipo generico
 */
public class DoubleLinkedList<E> implements PositionList<E>{
	//Cada nodo conoce un elemento, el nodo anterior y el nodo siguiente
		//La lista tiene dos nodos ficticion(dummy) llamados celdas de encabezamiento, header y trailer.
		//que evitan casos especiales al insertar y eliminar
		//La posicion es directa, se conoce el primer y ultimo nodo dummy
		protected DNodo<E> header;
		protected DNodo<E> trailer;
		protected int size;
		
		//Constructor
		
		/**
		 * Se crea una lista vacia.
		 */
			public DoubleLinkedList() {
				header=new DNodo<E>(null);
				trailer=new DNodo<E>(null);
				header.setSiguiente(trailer);
				trailer.setPrevio(header);
				size=0;
			}
			
		//getters
			
			@Override
			public E set(Position<E> p, E e)  throws InvalidPositionException{
				if(isEmpty()) throw new InvalidPositionException("Posicion nula");
					DNodo<E> n=checkPosition(p);
						E aux=p.element();
						n.setElemento(e);
						return aux;
			}	
			
			@Override
			public Iterable<Position<E>> positions(){
				PositionList<Position<E>> l=new DoubleLinkedList<Position<E>>();
				DNodo<E> actual=header.getSiguiente();
					while(actual!=trailer){
						l.addLast(actual);//agrega posicion p como ult elem de la lista L
						actual=actual.getSiguiente();				
					}
					return l;

			}
			
			@Override
			public E remove(Position<E> p) throws InvalidPositionException{
				if(size==0)
					throw new InvalidPositionException("La lista esta vacia, no hay elementos que eliminar");
				DNodo<E> pos=checkPosition(p);		
				E aux=pos.element();
				DNodo<E> prev=pos.getPrevio();
				DNodo<E> next=pos.getSiguiente();
				prev.setSiguiente(next);
				next.setPrevio(prev);
				size--;
				pos.setElemento(null);
				pos.setSiguiente(null);
				pos.setPrevio(null);
				return aux;				
			}
			
			/**
			 * Si es una posicion no valida se lanza una excepcion.
			 * 
			 * @param p Posición 
			 * @return p si es una posicion valida
			 * @throws InvalidPositionException lanza una exception de posicion invalida
			 */
			private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
				if(p==null) throw new InvalidPositionException("Posicion nula");
				if(p==trailer || p==trailer)
					throw new InvalidPositionException("Posición inválida");
				try {					
					return (DNodo<E>) p;
				}catch(ClassCastException e){
					throw new InvalidPositionException("p no es un nodo en la lista");
				}
			}
			
			@Override
			public Position<E> first() throws EmptyListException{
				if(size==0) throw new EmptyListException("Lista vacia");
				return header.getSiguiente();
			}
			
			@Override
			public Position<E> last() throws EmptyListException{
				if(size==0) throw new EmptyListException("Lista vacia");
				return trailer.getPrevio();
			}
			
			@Override
			public boolean isEmpty(){
				return size==0;
			}
			
			@Override
			public Iterator<E> iterator(){
				return new ElementIterator<E>(this);
			}
			
			@Override
			public Position<E> next(Position<E> p ) throws InvalidPositionException, BoundaryViolationException{
				DNodo<E> n=checkPosition(p);
				if(size==0) throw new InvalidPositionException("Posicion nula");
				if(	n.getSiguiente()==trailer ) throw new BoundaryViolationException("Siguiente de ultimo");
				return n.getSiguiente();
			}
			
			@Override
			public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
				DNodo<E> n=checkPosition(p);
				if(size==0) throw new InvalidPositionException("Posición nula");
				if(n.getPrevio()==header) throw new BoundaryViolationException("Anterior de primero");
				return n.getPrevio();
			}
			
			@Override
			public int size(){
				return size;
			}
			
			//setters
			@Override
			public void addFirst(E e){
				DNodo<E> nuevo=new DNodo<E>(e);
				header.getSiguiente().setPrevio(nuevo);
				nuevo.setSiguiente(header.getSiguiente());//al nodo nuevo le asigno como siguiente el siguiente de la cabeza
				nuevo.setPrevio(header);//al nodo nuevo le asigno como nodo previo la cabeza
				header.setSiguiente(nuevo);//le asigno, a la cabeza, como siguiente el nodo nuevo
				size++;
			}
			
			@Override
			public void addLast(E e) {
				DNodo<E> nuevo=new DNodo<E>(e);
				trailer.getPrevio().setSiguiente(nuevo);
				nuevo.setPrevio(trailer.getPrevio());//al nodo nuevo le asigno como previo, el previo del rabo
				nuevo.setSiguiente(trailer);//al nodo nuevo le asigno como nodo siguiente el rabo
				trailer.setPrevio(nuevo);//al rabo le asigno como previo el nuevo
				size++;
			}
			
			@Override
			public void addAfter(Position<E> p, E element) throws InvalidPositionException{
				DNodo<E> pos=checkPosition(p);
				DNodo<E> nuevo=new DNodo<E>(element);
				nuevo.setSiguiente(pos.getSiguiente());//el siguiente del nodo nuevo es el nodo siguiente del nodo en la pos. p
				nuevo.setPrevio(pos);
				nuevo.getSiguiente().setPrevio(nuevo);//el previo del nodo siguiente del nodo en la posicion p, ahora es el nodo nuevo
				pos.setSiguiente(nuevo);//el nodo siguiente del nodo en la pos. p es el nodo nuevo
				size++;
			}
			
			@Override
			public void addBefore(Position<E> p, E element) throws InvalidPositionException{
				DNodo<E> pos=checkPosition(p);
				DNodo<E> nuevo=new DNodo<E>(element);
				nuevo.setPrevio(pos.getPrevio());//el nodo previo del nuevo es el nodo previo del nodo en la posicion p
				nuevo.setSiguiente(pos);
				nuevo.getPrevio().setSiguiente(nuevo);//el siguiente del nodo previo del nodo en la posicion p, ahora es el nodo nuevo
				pos.setPrevio(nuevo);//el nodo previo del nodo en la pos. p es el nodo nuevo
				size++;
			}
			
}
