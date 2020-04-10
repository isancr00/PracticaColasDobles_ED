package ule.edi.doubleLinkedList;

import static org.junit.Assert.*;

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
		Assert.assertEquals(listaConElems.toString(), "(A B C A B )");		
		
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
	

}
