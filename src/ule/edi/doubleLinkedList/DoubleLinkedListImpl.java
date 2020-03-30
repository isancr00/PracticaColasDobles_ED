package ule.edi.doubleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.w3c.dom.Element;

import ule.edi.exceptions.EmptyCollectionException;

public class DoubleLinkedListImpl<T> implements DoubleList<T> {


	// referencia al primer nodo de la lista
	private DoubleNode<T> front;

	// referencia al Último nodo de la lista
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



	/// TODO :  AÑADIR OTRAS CLASES PARA LOS OTROS 3 ITERADORES


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


	@Override
	public void clear() {
		DoubleNode<T> node = front;
		node = front;
		while(node != null) {
			node.elem = null;
			node.prev = null;
			node = node.next;
		}

	}


	@Override
	public void insertFirst(T elem) {
		if(front.elem == null) {
			throw new NullPointerException();
		}else {
			DoubleNode<T> node = new DoubleNode<T> (elem);
			node.next = front;
			node.prev = null;
			front.prev = node;
			front = node;
		}

	}


	@Override
	public void insertLast(T elem) {
		if(front.elem == null) {
			throw new NullPointerException();
		}else {
			DoubleNode<T> node = new DoubleNode<T> (elem);
			node.prev = last;
			node.next = null;
			last.prev = node;
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
			int contador = 0;
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
			int contador = 0;
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

		return 0;
	}


	@Override
	public int getPosLast(T elem) {

		return 0;
	}


	@Override
	public T removePos(int pos) {

		return null;
	}


	@Override
	public int removeAll(T elem) {

		return 0;
	}


	@Override
	public boolean contains(T elem) {

		return false;
	}


	@Override
	public int size() {

		return 0;
	}


	@Override
	public String toStringReverse() {

		return null;
	}

	@Override
	public DoubleList<T> reverse() {

		return null;
	}


	@Override
	public int maxRepeated() {

		return 0;
	}


	@Override
	public boolean isEquals(DoubleList<T> other) {

		return false;
	}


	@Override
	public boolean containsAll(DoubleList<T> other) {

		return false;
	}


	@Override
	public boolean isSubList(DoubleList<T> other) {

		return false;
	}


	@Override
	public String toStringFromUntil(int from, int until) {

		return null;
	}

	@Override
	public String toString() {

		return null;
	}

	@Override
	public Iterator<T> iterator() {

		return null;
	}

	@Override
	public Iterator<T> reverseIterator() {

		return null;
	}


	@Override
	public Iterator<T> evenPositionsIterator() {

		return null;
	}


	@Override
	public Iterator<T> progressIterator() {

		return null;
	}


}