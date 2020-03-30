package ule.edi.doubleLinkedList;


import java.util.Iterator;

import ule.edi.exceptions.EmptyCollectionException;

	
	public interface DoubleList<T> extends Iterable<T>{
		/**
		 * TAD 'DoubleList'
		 * 
		 * Almacena una colección de objetos de tipo <code>T</code>, permitiendo elementos repetidos.  
		 * 
		 * Ejemplo: (A B C A B D )
		 *
		 * 
		 * Excepciones
		 * 
		 * No se permiten elementos <code>null</code>. Si a cualquier método que recibe un elemento se le pasa el 
		 * valor <code>null</code>, lanzará una excepción {@link NullPointerException}.
		 * 
		 * Los valores de parámetros <code>position</code> deben ser mayores que cero y nunca negativos. Si se 
		 * recibe un valor negativo o cero se lanzará {@link IllegalArgumentException}.
		 * 
		 * 
		 * Constructores
		 * 
		 * Se definirá un constructor por defecto que inicialice la instancia
		 * como lista vacía.
		 * 
		 *  
		 * Método {@link Object#toString()}
		 * 
		 * El formato será mostrar el toString de los elementos separados por espacios (A B C D D D B ) el toString 
		 *
		 * 
		 * @author profesor
		 *
		 * @param <T> tipo de elementos en la lista
		 */
		
		
		/**
		 * Indica si esta lista está vacía
		 * 
		 * @return <code>true</code> si no contiene elementos
		 */
		public boolean isEmpty();
		
		/**
		 * Elimina todo el contenido de esta lista.
		 * <p>
		 * Deja la lista vacía
		 * 
		 */
		public void clear();
		
		/**
		 * Añade un elemento como primer elemento de la lista.
		 * <p>
		 * Si una lista l contiene (A B C )  y hacemos l.insertFirst("C") 
		 * la lista quedará (C A B C )
		 * 
		 * @param elem el elemento a añadir
		 * 
		 * @throws NullPointerException si elem es <code>null</code>
		 */
		public void insertFirst(T elem);
		
		/**
		 * Añade un elemento como último elemento de la lista
		 * <p>
		 * Si una lista l contiene (A B C )  y hacemos l.insertLast("C") 
		 * la lista quedará (A B C C )
		 * 
		 * @param elem el elemento a añadir
		 * 
		 * @throws NullPointerException si elem es <code>null</code>
		 */
		public void insertLast(T elem);
		
		/**
		 * Elimina y devuelve el primer elemento de la lista.
		 * <p>
		 * Si una lista l contiene (A B C )  y hacemos l.removeFirst() 
		 * la lista quedará (B C ) y devolverá A
		 * 
	     * @throws EmptyCollectionException si la lista es vacía 
		 * 
		 */
		public T removeFirst() throws EmptyCollectionException;
		
		/**
		 * Elimina y devuelve el último elemento de la lista.
		 * <p>
		 * Si una lista l contiene (A B C )  y hacemos l.removeLast() 
		 * la lista quedará (A B ) y devolverá C
		 * 
	     * @throws EmptyCollectionException si la lista es vacía 
		 * 
		 */
		public T removeLast() throws EmptyCollectionException;;

		
		/**
		 * Añade un elemento en la posición pasada como parámetro desplazando los elementos que estén a partir de esa posición.
		 * <p>
		 * Si una lista l contiene (A B C )  y hacemos l.insertPos("C", 2) 
		 * la lista quedará (A C B C ).
		 * <p>
		 * Si position>size() se insertará como último elemento.
		 * 
		 * @param elem el elemento a añadir
		 * @param position la posición en la que añadirá el elemento
		 * 
		 * @throws NullPointerException si elem es <code>null</code>
		 * @throws IllegalArgumentException si position <= 0
		 * 
		 */
		public void insertPos(T elem, int position);
		
		/**
		 * Añade un elemento delante de la primera aparición del elemento pasado como 2º parámetro desplazando los elementos que estén a partir de ese elemento.
		 * <p>
		 * Si una lista l contiene (A B C B )  <br>
		 *  l.insertPos("D", "B") ;   la lista quedará (A D B C B ).
		 * 
		 * 
		 * @param elem el elemento a añadir
		 * @param target el elemento delante del cual insertará elem
		 * 
		 * @throws NullPointerException  si elem o target son <code>null</code>
		 * @throws NoSuchElementException  si target no está en la lista
		 * 
		 */
		public void insertBefore(T elem, T target);
		
		/**
		 * Devuelve el elemento que está en position.
		 * <p>
		 * Si una lista l contiene (A B C D E ): <br>
		 * l.getElemPos(1) -> A <br>
		 * l.getElemPos(3) -> C <br>
		 * l.getElemPos(10) -> IllegalArgumentException
		 * 
		 * 
		 * @param position posición a comprobar para devolver el elemento 
		 * 
		 * @throws IllegalArgumentException si position no está entre 1 y size() 
		 * 
		 */
		public T getElemPos(int position);
		
		/**
		 * Devuelve la posición de la primera aparición del elemento.
		 * <p>
		 * Si una lista l contiene (A B C B D A ): <br>
		 * l.getPosFirst("A") -> 1 <br>
		 * l.getPosFirst("B") -> 2 <br>
		 * l.getPosFirst("Z") -> NoSuchElementException
		 * 
		 * @param elem elemento a encontrar.
		 *
		 * @throws NullPointerException si elem es <code>null</code>
		 * @throws NoSuchElementException si elem no está en la lista.
		 * 
		 */
		public int getPosFirst(T elem);
		
		/**
		 * Devuelve la posición de la última aparición del elemento.
		 * <p>
		 * Si una lista l contiene (A B C B D A ): <br>
		 * l.getPosFirst("A") -> 6 <br>
		 * l.getPosFirst("B") -> 4 <br>
		 * l.getPosFirst("Z") -> NoSuchElementException
		 * 
		 * @param elem elemento a encontrar.
		 * 
		 * @throws NullPointerException si elem es <code>null</code>
		 * @throws NoSuchElementException si elem no está en la lista.
		 * 
		 */
		public int getPosLast(T elem);
		
		/**
		 * Elimina y devuelve el elemento que está en position.
		 * <p>
		 * Si una lista l contiene (A B C B D A ): <br>
		 * l.removePos(1) -> "A", dejando la lista (B C B D A ): <br>
		 * l.removePos(3) -> "C", dejando la lista (A B B D A ): <br>
		 * l.removePos(10) -> IllegalArgumentException
		 * 
		 * @param position posición a comprobar para devolver el elemento.
		 * 
		 * @throws IllegalArgumentException si position no está entre 1 y size().
		 * 
		 */
		public T removePos(int pos);
		
		/**
		 * Elimina todas las apariciones del elemento y devuelve el número de instancias eliminadas.
		 * <p>
		 * Si una lista l contiene (A B C B D A B ): <br>
		 * l.removeAll("A") -> 2, dejando la lista (B C B D B ): <br>
		 * l.removeAll("B") -> 3, dejando la lista (A C D A ): <br>
	 	 * l.removeAll("Z") -> NoSuchElementException 
	 	 * 
	     * @param elem elemento a eliminar.
	     * 
		 * @throws NullPointerException si elem es <code>null</code>
		 * @throws NoSuchElementException si elem no está en la lista.
		 * 
		 */
		public int removeAll(T elem);
		
		/**
		 * Indica si el elemento está en esta lista. <br>
		 * 
		 * Devuelve <code>true</code> si al menos existe una
		 * instancia del elemento dado en esta lista (es decir,
		 * un elemento 'x' tal que <code>x.equals(element)</code>)
		 * y <code>false</code> en caso contrario.
		 * 
		 * @param elem elemento a buscar en esta lista
		 * @return <code>true</code>/<code>false</code> según el resultado
		 * 
		 * @throws NullPointerException el elemento indicado es <code>null</code>
		 */
		public boolean contains(T elem);
		
		/**
		 * Devuelve el número total de elementos en esta lista. <br>
		 * 
		 * Ejemplo:<br>
	     * Si una lista l contiene (A B C B D A B ): <br>
		 *  l.size() -> 7
		 *   
		 * @return número total de elementos en esta lista
		 */
		public int size();
		
		/**
		 * Crea y devuelve un String con el contenido de la lista empezando por el final hasta el principio.
		 * 
		 * <br> Si esta lista es vacía devuelve el toString() de la lista vacía -> (). <br>
		 * 
		 * <br> Ejemplo:<br>
		 * Si una lista l contiene (A B C ): <br>
		 *  l.toStringReverse() -> (C B A ) 
		 * @return recorrido inverso de la lista (desde el final al principio)
		 */
		public String toStringReverse();
		
		
		/**
		 * Crea una nueva lista inversa de esta lista. <br>
		 * Si esta lista es vacía devuelve la lista vacía. <br>
		 * 
		 * Ejemplo:<br>
		 * Si una lista l contiene (A B C ): <br>
		 *  l.reverse().toString() -> (C B A ) 
		 * @return lista inversa de esta lista 
		 */
		public DoubleList<T> reverse();
		
		/**
		 * Devuelve el número de veces que se repite el elemento con máximo número de repeticiones. <br>
		 * Ejemplo:<br>
		 * Si una lista l contiene (A B C A A C A): <br>
		 *  l.maxRepeated() -> 4   // el elemento que más se repite es A, y lo hace 4 veces
		 * @return nº de repeticiones del elemento que más se repite 
		 */
		public int maxRepeated();
		
		/**
		 * Indica si esta lista es igual a la pasada como parámetro (tienen los mismos elemento en el mismo orden). <br>
		 * 
		 * Ejemplos:<br>
		 * l1=(A B C ) ; l2=(B C A )  : l1.isEquals(l2) -> false <br>
		 * l1=(A B C ) ; l2=(A B C )  : l1.isEquals(l2) -> true <br>
		 * 
		 * @param other lista a comprobar si es igual a esta lista
		 * 
		 * @return true si son iguales, false en caso contrario
		 * @throws NullPointerException other es null
		 */
		public boolean isEquals(DoubleList<T> other);
		
		/**
		 * Indica si esta lista contiene todos los elementos de la lista pasada como parámetro. <br>
		 * Ejemplos:<br>
		 * l1=(A B C D E ) ; l2=(B C A )  : l1.containsAll(l2) -> true <br>
		 * l1=(A B C ) ; l2=(A B D )      : l1.containsAll(l2) -> false <br>
		 
		 * @param other lista a comprobar 
		 * 
		 * @return true si esta lista contiene todos los elementos de other, false en caso contrario
		 * @throws NullPointerException other es null
		 * 
		 */
		public boolean containsAll(DoubleList<T> other);
		
		/**
		 * Indica si other es sublista de esta lista. 
		 * <p>Una lista vacía es sublista de cualquier lista.
		 * <p>
		 * Ejemplos:<br>u
		 * l1=(A B C D E ) ; l2=(B C D )  : l1.isSubList(l2) -> true <br>
		 * l1=(A B C D E ) ; l2=(A B D )  : l1.isSubList(l2) -> false <br>
		 
		 * @param other lista a comprobar 
		 * 
		 * @return true si other es sublista de esta lista, false en caso contrario
		 * @throws NullPointerException other es null
		 * 
		 */
		public boolean isSubList(DoubleList<T> other);
		
		/**
		 * Devuelve el toString de la sublista formada por los elementos situados entre las posiciones from hasta until incluidas. 
		 * 
		 * <br> Si until > size() se muestra hasta el final de la lista.
		 * <br> Si from > size() se muestra () (toString de la lista vacía)
		 * 
		 * <br> Ejemplos:<br>
		 * l1=(A B C D E ) ; l1.toSringFromUntil(1,3)  -> (A B C ) <br>
		 * l1=(A B C D E ) ; l1.toSringFromUntil(3,10)  -> (C D E ) <br>
		 * l1=(A B C D E ) ;l1.toStringFromUntil(10,20) -> () <br>
		 * 
		 * @param from posición desde la que se empieza a considerar la lista (incluida)
		 * @param until posición hasta la que se incluyen elementos (incluida)
		 *  
		 * @return String de la sublista formada por los elementos en el rango establecido por los dos parámetros.
		 *
		 *@throws IllegalArgumentException si from o until son <=0 ; o si until < from
		 *@throws NullPointerException other es null
		 *
		 */
		public String toStringFromUntil(int from, int until);
	    
		/**
		* Devuelve un iterador que recorre la lista en orden inverso. <br>
		*
		* Por ejemplo, para una lista x con elementos (A B C D E)
		*
		* el iterador creado con x.reverseIterator() devuelve en sucesivas llamadas a next(): E, D, C, B y A.
		*
		* @return iterador para orden inverso.
		*/
		public Iterator<T> reverseIterator();
		
		/**
		* Devuelve un iterador que recorre los elementos con posición par de la lista. <br>
		*
		* Por ejemplo, para una lista x con elementos (A B C D E )
		*
		* el iterador creado con x.evenPositionIterator() devuelve en sucesivas llamadas a next(): B y D.
		*
		* @return iterador para recorrer elementos en posiciones pares.
		*/
	    public Iterator<T> evenPositionsIterator();
		
	    /**
		* Devuelve un iterador que recorre los elementos saltando progresivamente i posiciones de la lista.
		*
		* <br> Es decir, en cada llamada a next() se salta i posiciones, la i empieza en 1 y va incrementandose en cada llamada a next.
		* 
		* Por ejemplo, para una lista x con elementos (1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 )
		* 
		* el iterador creado con x.progressIterator() devuelve en sucesivas llamadas a next(): 1, 2, 4, 7, 11 y 16.
		*
		* @return iterador para recorrer ciertos elementos de la lista como se indica anteriormente.
		*/
	    public Iterator<T> progressIterator();	
	}
	