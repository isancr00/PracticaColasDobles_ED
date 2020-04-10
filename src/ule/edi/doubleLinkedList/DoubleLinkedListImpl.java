package ule.edi.doubleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.w3c.dom.Element;

import ule.edi.exceptions.EmptyCollectionException;

public class DoubleLinkedListImpl<T> implements DoubleList<T> {


	// referencia al primer nodo de la lista
	private DoubleNode<T> front;

	// referencia al Ãšltimo nodo de la lista
	private DoubleNode<T> last;


	private class DoubleNode<T> {

		DoubleNode(T element) {
			this.elem = element;
			this.next = null;
			this.prev = null;
		}

		T elem;

		DoubleNode<T> next;
		DoubleNode<T> prev;
	}

	///// ITERADOR normal //////////

	@SuppressWarnings("hiding")
	private class DobleLinkedListIterator<T> implements Iterator<T> {
		DoubleNode<T> current;

		public DobleLinkedListIterator(DoubleNode<T> node) {
			this.current = node;

		}

		@Override
		public boolean hasNext() {
			return(this.current != null);

		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}

			T result = current.elem;
			current = current.next;
			return result;
		}


	}

	////// FIN ITERATOR



	/// TODO :  AÃ‘ADIR OTRAS CLASES PARA LOS OTROS 3 ITERADORES


	/////

	@SuppressWarnings("hiding")
	private class DobleLinkedListIteratorReverse<T> implements Iterator<T> {
		DoubleNode <T>current;





		public DobleLinkedListIteratorReverse(DoubleNode<T> node) {
			this.current = node;

		}

		@Override
		public boolean hasNext() {
			return(this.current != null);

		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}

			T result = current.elem;
			current = current.prev;
			return result;
		}


	}

	@SuppressWarnings("hiding")
	private class DobleLinkedListIteratorEven<T> implements Iterator<T> {
		DoubleNode <T>current;





		public DobleLinkedListIteratorEven(DoubleNode<T> node) {
			this.current = node;

		}

		@Override
		public boolean hasNext() {
			return(this.current != null);

		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}

			T result = current.elem;
			if(this.current.prev == null) {
				this.current = this.current.next;
			}else {
				this.current = this.current.next.next;
			}
			return result;
		}


	}

	@SafeVarargs
	public DoubleLinkedListImpl(T...v ) {
		for (T elem:v) {
			this.insertLast(elem);
		}
	}


	@Override
	public boolean isEmpty() {
		return (this.front == null);
	}

	//No va
	@Override
	public void clear() {
		DoubleNode<T> node = front;
		DoubleNode<T> aux = null;
		node = front;
		while(node != null) {
			node.elem = null;
			node.prev = null;
			node = node.next;
		}
		
		front = last= null;
		
	}


	@Override
	public void insertFirst(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}else if(isEmpty()){
			DoubleNode<T> node = new DoubleNode<T> (elem);
			front = last = node;	
		}else {
			DoubleNode<T> node = new DoubleNode<T> (elem);
			node.next = front;
			node.next.prev = node;
			node.prev = null;
			front = node;
		}

	}


	@Override
	public void insertLast(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}else if(this.isEmpty()){
			DoubleNode<T> node = new DoubleNode<T> (elem);
			front = last = node;						
		}else {
			DoubleNode<T> node = new DoubleNode<T> (elem);
			node.prev = last;
			node.prev.next = node;
			node.next = null;
			last = node;
		}

	}


	@Override
	public T removeFirst() throws EmptyCollectionException{
		T elem = front.elem;
		if(isEmpty()) {
			throw new EmptyCollectionException("DoubleLinkedList");
		}else{
			front.elem = null;
			front = front.next;
		}

		return elem;
	}


	@Override
	public T removeLast()  throws EmptyCollectionException{
		T elem = last.elem;
		if(isEmpty()) {
			throw new EmptyCollectionException("DoubleLinkedList");
		}else{
			last.elem = null;
			last = last.prev;
		}

		return elem;
	}


	@Override
	public void insertPos(T elem, int position) {
		if(elem == null) {
			throw new NullPointerException();
		}else if(position == 0) {
			throw new IllegalArgumentException();
		}else {
			int contador = 1;
			DoubleNode<T> node = front;
			DoubleNode<T> nodeInsertar = new DoubleNode<T> (elem);
			while(node != null) {
				if(contador == position) {
					node.prev = nodeInsertar;
					nodeInsertar.next = node;
				}
				node = node.next;
				contador++;
			}
		}

	}


	@Override
	public void insertBefore(T elem, T target) {
		if(elem == null || target == null) {
			throw new NullPointerException();
		}else {
			DoubleNode<T> node = front;
			DoubleNode<T> nodeInsertar = new DoubleNode<T> (elem);
			while(node != null) {
				if(node.elem == target) {
					node.prev.next = nodeInsertar;
					nodeInsertar.prev = node.prev;
					node.prev = nodeInsertar;
					nodeInsertar.next = node;
				}
				node = node.next;
			}

		}

	}


	@Override
	public T getElemPos(int position) {
		T element = null;
		if(position <= 0) {
			throw new IllegalArgumentException();
		}else {
			int contador = 1;
			DoubleNode<T> node = front;
			while(node != null) {
				if(contador == position) {
					element = node.elem;
				}

				node = node.next;
				contador++;
			}
		}

		return element;
	}


	@Override
	public int getPosFirst(T elem) {

		int contador = 1;

		if(elem == null) {
			throw new NullPointerException();
		}else {
			DoubleNode<T> node = front;
			while(node != null) {
				if(node.elem.equals(elem)) {
					return contador;
				}

				contador++;
				node = node.next;
			}

		}

		return contador;
	}


	@Override
	public int getPosLast(T elem) {

		int contador = 1;

		if(elem == null) {
			throw new NullPointerException();
		}else {
			DoubleNode<T> node = last;
			while(node != null) {
				if(node.elem.equals(elem)) {
					return contador;
				}

				contador++;
				node = node.prev;
			}

		}

		return contador;

	}


	@Override
	public T removePos(int pos) {

		int contador = 1;
		T element = null;

		if(pos < 1 || pos > size()) {
			throw new IllegalArgumentException();
		}else {
			DoubleNode <T> node = front;

			while(node != null) {
				if(contador == 1 && pos == 1) {
					node.elem=null;
					front = node.next;

				}else if(contador == pos) {
					node.elem=null;
					node.prev.next = node.next;
					node.next.prev = node.prev;
					node.prev = null;
				}
				contador++;
				node = node.next;
			}
		}

		return element;
	}


	@Override
	public int removeAll(T elem) {

		int contador = 0;

		if(elem == null) {
			throw new NullPointerException();
		}else if(isEmpty()){

			return 0;

		}else {
			DoubleNode<T> node = front;
			while(node != null) {
				if(node.elem.equals(elem)) {
					contador++;
					removePos(getPosFirst(elem));					
				}

				node = node.next;
			}

		}



		return contador;
	}


	@Override
	public boolean contains(T elem) {

		if(elem == null) {
			throw new NullPointerException();
		}else {
			DoubleNode<T> node = front;
			while(node != null) {
				if(node.elem.equals(elem)) {
					return true;			
				}

				node = node.next;
			}

		}

		return false;
	}


	@Override
	public int size() {

		int contador = 0;
		DoubleNode<T> node = front;
		while(node != null) {

			contador++;

			node = node.next;
		}

		return contador;
	}


	@Override
	public String toStringReverse() {

		StringBuffer aux = new StringBuffer();
		DoubleNode<T> node = last;

		aux.append("(");

		if(this.isEmpty()) {
			aux.append("");
		}else {

			while(node != null) {
				aux.append(node.elem);
				aux.append(" ");
				node = node.prev;
			}

		}
		aux.append(")");

		return aux.toString();
	}

	@Override
	public DoubleList<T> reverse() {

		DoubleList<T> aux = new DoubleLinkedListImpl<T>();
		DoubleNode<T> node = last;

		while(node != null) {
			aux.insertLast(node.elem);
			node = node.prev;
		}

		return aux;
	}


	@Override
	public int maxRepeated() {

		int max=0,repeated=1;

		for(int i=1;i<size()+1;i++) {
			for(int j=i+1;j<size()+1;j++) {
				if(getElemPos(i).equals(getElemPos(j))) {
					repeated++;
					if(repeated > max) {
						max = repeated;
					}
				}
			}

			repeated = 0;
		}


		return max;
	}


	@Override
	public boolean isEquals(DoubleList<T> other) {

		boolean resultado = false;


		if(other == null) {
			throw new NullPointerException();
		}else if(this.size() != other.size()){
			//Si el tamaño es distinto, las listas no pueden ser iguales

			return false;			
		}else {
			for(int i=1;i<size()+1;i++) {
				if(this.getElemPos(i).equals(other.getElemPos(i))) {
					resultado = true;
				}else {
					return false;
				}
			}
		}


		return resultado;
	}


	@Override
	public boolean containsAll(DoubleList<T> other) {

		boolean resultado = false;


		if(other == null) {
			throw new NullPointerException();
		}else if(this.isEquals(other)) {
			return true;
		}else {

			for(int i=1;i<other.size()+1;i++) {
				if(this.contains(other.getElemPos(i))) {
					resultado = true;
				}else {
					return false;
				}
			}

		}


		return resultado;
	}

	//Está mal, mirar correo
	@Override
	public boolean isSubList(DoubleList<T> other) {

		boolean resultado = false;
		if(other == null) {
			throw new NullPointerException();
		}else if (this.isEquals(other)){
			return true;
		}else if(this.size()<other.size()) {
			return false;
		}if(other.isEmpty()){
			return true;
		}else {	
			for(int i=this.getPosFirst(other.getElemPos(1)); i<other.size()+1;i++) {
				if(this.getElemPos(i).equals(other.getElemPos(i))){
					resultado = true;
				}else {
					resultado = false;
					int aux=0;
					for(int j= this.getPosLast(other.getElemPos(1));j<other.size();j++) {
						aux++;
						if(this.getElemPos(j).equals(other.getElemPos(aux))){
							resultado = true;
						}else {
							return false;
						}
					}
				}
			}
		}

		return resultado;
	}


	@Override
	public String toStringFromUntil(int from, int until) {

		StringBuffer aux = new StringBuffer();
		aux.append("(");

		if(from<=0||until<=0||until<from) {
			throw new IllegalArgumentException();
		}else {

			for(int i=1;i<until+1;i++) {
				aux.append(this.getElemPos(i));
				aux.append(" ");
			}

		}

		aux.append(")");

		return aux.toString();
	}

	@Override
	public String toString() {

		StringBuffer aux = new StringBuffer();
		DoubleNode<T> node = front;

		aux.append("(");

		while(node != null) {
			aux.append(node.elem);
			aux.append(" ");
			node = node.next;
		}

		aux.append(")");


		return aux.toString();

	}

	@Override
	public Iterator<T> iterator() {

		return new DobleLinkedListIterator<T>(front);
	}

	@Override
	public Iterator<T> reverseIterator() {

		return new DobleLinkedListIteratorReverse<T>(front);
	}


	@Override
	public Iterator<T> evenPositionsIterator() {

		return new DobleLinkedListIteratorEven<T>(front);
	}


	@Override
	public Iterator<T> progressIterator() {

		return null;
	}


}