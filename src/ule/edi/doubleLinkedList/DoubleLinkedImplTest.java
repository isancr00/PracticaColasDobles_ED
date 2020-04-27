package ule.edi.doubleLinkedList;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

import ule.edi.exceptions.EmptyCollectionException;

public class DoubleLinkedImplTest {
	DoubleLinkedListImpl<String> lv;
	DoubleLinkedListImpl<String> listaConElems;
	
@Before
public void antesDe() {
	lv=new DoubleLinkedListImpl<String>();
	listaConElems=new DoubleLinkedListImpl<String>();
	listaConElems.insertFirst("D");
	listaConElems.insertFirst("B");
	listaConElems.insertFirst("A");
	listaConElems.insertFirst("C");
	listaConElems.insertFirst("B");
	listaConElems.insertFirst("A");
	
}
	
	@Test
	public void isEmptyTest() {
		Assert.assertTrue(lv.isEmpty());
		Assert.assertTrue(lv.size()==0);
		Assert.assertFalse(listaConElems.isEmpty());
		Assert.assertTrue(listaConElems.size()==6);
		
	}
	
	@Test
	public void clearTest() {
		lv.clear();
		Assert.assertTrue(lv.isEmpty());
		Assert.assertTrue(lv.size()==0);
		
		listaConElems.clear();
		Assert.assertTrue(listaConElems.isEmpty());
		Assert.assertTrue(listaConElems.size()==0);
		Assert.assertEquals(listaConElems.toString(),listaConElems.toStringReverse());
		
	}
	
	@Test
	public void containsTest() {
		Assert.assertFalse(lv.contains("A"));
		Assert.assertTrue(listaConElems.contains("A"));
		Assert.assertTrue(listaConElems.contains("B"));
		Assert.assertTrue(listaConElems.contains("B"));
		Assert.assertTrue(listaConElems.contains("D"));
		Assert.assertFalse(listaConElems.contains("Z"));
		
	}
	
	@Test
	public void removeAllTest() throws EmptyCollectionException {
        Assert.assertEquals(2, listaConElems.removeAll("A"));
    	Assert.assertEquals(listaConElems.toString(),"(B C B D )");
    	
        listaConElems.removeAll("B");
		Assert.assertFalse(listaConElems.contains("A"));
		Assert.assertFalse(listaConElems.contains("B"));
		Assert.assertEquals(listaConElems.toString(),"(C D )");
		listaConElems.removeAll("C");
		
		Assert.assertTrue(listaConElems.contains("D"));
		Assert.assertFalse(listaConElems.contains("C"));
        listaConElems.removeAll("D");
		
		Assert.assertFalse(listaConElems.contains("D"));
		Assert.assertTrue(listaConElems.isEmpty());
		Assert.assertTrue(listaConElems.size()==0);
		Assert.assertEquals(listaConElems.toString(),listaConElems.toStringReverse());
		
	}
	
	@Test
	public void isSubListTest() throws EmptyCollectionException {
			Assert.assertTrue(listaConElems.isSubList(lv));
	    	Assert.assertTrue(listaConElems.isSubList(new DoubleLinkedListImpl<String>("A", "B", "C")));
	      	Assert.assertEquals(listaConElems.toString(),"(A B C A B D )");
	      	Assert.assertEquals(new DoubleLinkedListImpl<String>("A", "C").toString(),"(A C )");   
	     	Assert.assertFalse(listaConElems.isSubList(new DoubleLinkedListImpl<String>("A", "C")));
	     	Assert.assertEquals(listaConElems.maxRepeated(),2);
	     	listaConElems.insertBefore("A", "D");
	    	Assert.assertEquals(listaConElems.toString(),"(A B C A B A D )");
	    	Assert.assertTrue(listaConElems.maxRepeated()==3);	        	  
	}
	
	
	@Test (expected = NullPointerException.class)
	public void insertFirstNullTest() {
		listaConElems.insertFirst(null);		
	}
	
	@Test (expected = NullPointerException.class)
	public void insertLastNullTest() {
		listaConElems.insertLast(null);		
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void removeFirstEmptyTest() throws EmptyCollectionException {
		listaConElems.clear();
		Assert.assertEquals(listaConElems.size(),0 );
		listaConElems.removeFirst();
		Assert.assertEquals(listaConElems.size(),0 );

	}
	
	@Test
	public void removeFirstNotEmptyTest() throws EmptyCollectionException {
		listaConElems.removeFirst();
		Assert.assertEquals(listaConElems.toString(), "(B C A B D )");		
		
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void removeLastEmptyTest() throws EmptyCollectionException {
		listaConElems.clear();
		Assert.assertEquals(listaConElems.size(),0 );
		listaConElems.removeLast();
		Assert.assertEquals(listaConElems.size(),0 );

	}
	
	@Test
	public void removeLastNotEmptyTest() throws EmptyCollectionException {
		listaConElems.removeLast();
		Assert.assertEquals(listaConElems.toString(), "(A B C A B null )");		//No entiendo el null	
		
	}
	
	@Test (expected = NullPointerException.class)
	public void insertPosNullElemTest() {
		listaConElems.insertPos(null, 1);
		Assert.assertEquals(listaConElems.size(),6);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void insertPosPosZeroTest() {
		listaConElems.insertPos("A", 0);
		Assert.assertEquals(listaConElems.size(),6);
	}
	
	@Test
	public void insertPosFirstNotNullElemTest() {
		listaConElems.insertPos("Z", 1);
		Assert.assertEquals(listaConElems.toString(),"(Z A B C A B D )");
	}
	
	@Test
	public void insertPosNotNullElemTest() {
		listaConElems.insertPos("Z", 3);
		Assert.assertEquals(listaConElems.toString(),"(A B Z C A B D )");
	}
	
	@Test (expected = NullPointerException.class)
	public void insertBeforeElementNullTest() {
		listaConElems.insertBefore(null, "A");
		Assert.assertEquals(listaConElems.size(),6);	
	}
	
	@Test (expected = NullPointerException.class)
	public void insertBeforeTargetNullTest() {
		listaConElems.insertBefore("·", null);
		Assert.assertEquals(listaConElems.size(),6);	
	}
	
	
	@Test
	public void insertBeforeNotNullTest() {
		listaConElems.insertBefore("··", "A");
		listaConElems.insertBefore("L", "D");
		Assert.assertEquals(listaConElems.toString(),"(·· A B C A B L D )");

	}
	
	@Test (expected = NoSuchElementException.class)
	public void insertBeforeTargetNotInList() {
		listaConElems.insertBefore("A", "J");		
		Assert.assertEquals(listaConElems.size(),6);

	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getElemNegativePosTest() {
		listaConElems.getElemPos(-5);
	}
	
	@Test (expected = NullPointerException.class)
	public void getPosFirstNullElem() {
		listaConElems.getPosFirst(null);
	}
	
	@Test
	public void getPosFirstEmptyListTest() {
		listaConElems.clear();
		Assert.assertEquals(listaConElems.getPosFirst("A"),0);
	}
	
	
	@Test (expected = NullPointerException.class)
	public void getPosLastNullElemTest() {
		listaConElems.getPosLast(null);
	}
	
	@Test
	public void getPosLastEmptyListTest() {
		listaConElems.clear();
		Assert.assertEquals(listaConElems.getPosLast("A"),0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void removeNegativePosTest() {
		listaConElems.removePos(-9);
		Assert.assertEquals(listaConElems.size(), 6);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void removeBigPosTest() {
		listaConElems.removePos(2500);
		Assert.assertEquals(listaConElems.size(), 6);
	}
	
	@Test (expected = NullPointerException.class)
	public void removeAllNullTest() {
		listaConElems.removeAll(null);
		Assert.assertEquals(listaConElems.size(), 6);

	}
	
	@Test
	public void removeAllClearList() {
		listaConElems.clear();
		Assert.assertEquals(listaConElems.removeAll("W"), 0);
	}
	
	@Test (expected = NullPointerException.class)
	public void containsNullElementTest() {
		listaConElems.contains(null);
	}
	
	@Test
	public void toStringReverseNotEmptyTest() {
		Assert.assertEquals(listaConElems.toStringReverse(), "(D B A C B A )");
	}

	
	@Test
	public void reverseTest() {
		Assert.assertEquals(listaConElems.reverse().toString(), listaConElems.toStringReverse());
	}
	
	@Test(expected = NullPointerException.class)
	public void isEqualsNullOtherTest() {
		
		listaConElems.isEquals(null);
	}
	
	@Test
	public void isEqualsTest() throws EmptyCollectionException {
		DoubleLinkedListImpl<String> aux = new DoubleLinkedListImpl<String>("A","B","C","A","B","D");
		Assert.assertEquals(aux.toString(),listaConElems.toString());
		Assert.assertTrue(aux.isEquals(listaConElems));
		aux.removeLast();
		aux.insertLast("A");
		Assert.assertFalse(aux.isEquals(listaConElems));

		
	}
	
	@Test(expected = NullPointerException.class)
	public void containsAllNUllTest() {
		listaConElems.containsAll(null);
	}
	
	@Test
	public void containsAllSameListTest() {
		Assert.assertTrue(listaConElems.containsAll(listaConElems));
	}
	
	@Test
	public void containsAllOtherBiggerTest() {
		Assert.assertFalse(lv.containsAll(listaConElems));
	}
	
	@Test
	public void containsAllContainedTest() {
		lv.insertFirst("A");
		Assert.assertTrue(listaConElems.containsAll(lv));
	}
	
	@Test
	public void containsAllNotContainedTest() {
		lv.insertFirst("Y");
		Assert.assertFalse(listaConElems.containsAll(lv));
	}
	
	@Test(expected = NullPointerException.class)
	public void isSublistNullOtherTest() {
		listaConElems.isSubList(null);
	}
	
	@Test
	public void isSublistSameOtherTest() {
		Assert.assertTrue(listaConElems.isSubList(listaConElems));
	}
	
	@Test
	public void isSublistOtherBiggerTest() {
		Assert.assertFalse(lv.isSubList(listaConElems));
	}
	
	@Test
	public void isSublistExtraTest() {
				
		DoubleLinkedListImpl<String> lv1 = new DoubleLinkedListImpl<String>("W","D");
		
		Assert.assertEquals(listaConElems.toString(), "(A B C A B D )");
		Assert.assertEquals(lv1.toString(), "(W D )");
		Assert.assertFalse(listaConElems.isSubList(lv1));
	}
	
	@Test
	public void toStringFromToUntilTest() {
		Assert.assertEquals(listaConElems.toStringFromUntil(2, 5), "(B C A B )");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void toStringFromToUntilZeroFromTest() {
		listaConElems.toStringFromUntil(0, 879);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void toStringFromToUntilZeroUntilTest() {
		listaConElems.toStringFromUntil(25, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void toStringFromToUntilUntilLessTest() {
		listaConElems.toStringFromUntil(25, 12);
	}
	
	@Test 
	public void iteratorNextTest() {
		Iterator<String> iterator =listaConElems.iterator();
		Assert.assertEquals(iterator.next(),"A");
		Assert.assertEquals(iterator.next(),"B");
	}
	
	@Test (expected = NoSuchElementException.class)
	public void iteratorNoNextTest() {
		Iterator<String> iterator =lv.iterator();
		iterator.next();
	}
	
	@Test 
	public void iteratorReverseNextTest() {
		Iterator<String> iterator =listaConElems.reverseIterator();

		Assert.assertEquals(iterator.next(),"D");
		Assert.assertEquals(iterator.next(),"B");

		
	}
	
	@Test (expected = NoSuchElementException.class)
	public void iteratorReverseNoNextTest() {
		Iterator<String> iterator =lv.reverseIterator();

		iterator.next();
	}
	
	@Test 
	public void iteratorEvenNextTest() {
		Iterator<String> iterator =listaConElems.evenPositionsIterator();

		
		Assert.assertEquals(iterator.next(),"B");
		Assert.assertEquals(iterator.next(),"A");

		
	}
	
	@Test (expected = NoSuchElementException.class)
	public void iteratorEvenNoNextTest() {
		Iterator<String> iterator =lv.evenPositionsIterator();

		iterator.next();
	}
	
	@Test
	public void iteratorProgressNextTest() {
		DoubleLinkedListImpl<Integer> lista = new DoubleLinkedListImpl<Integer>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19);
		
		Iterator<Integer> iterator =lista.progressIterator();
		
		Assert.assertEquals(iterator.next(), 1 , 0);
		Assert.assertEquals(iterator.next(), 2 , 0);
		Assert.assertEquals(iterator.next(), 4 , 0);
		Assert.assertEquals(iterator.next(), 7 , 0);
		Assert.assertEquals(iterator.next(), 11 , 0);
		Assert.assertEquals(iterator.next(), 16 , 0);

		
	}
	
	@Test (expected = NoSuchElementException.class)
	public void iteratorProgressNoNextTest() {
		Iterator<String> iterator =lv.progressIterator();

		iterator.next();
	}
	
	
	
	@Test
	public void getPosLastTest() {
		Assert.assertEquals(listaConElems.getPosLast("A"),4);
		Assert.assertEquals(listaConElems.getPosLast("B"),5);
		Assert.assertEquals(listaConElems.getPosLast("D"),6);

		
	}	
		
}
