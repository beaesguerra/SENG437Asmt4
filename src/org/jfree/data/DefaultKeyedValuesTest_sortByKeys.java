package org.jfree.data;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.jfree.util.SortOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesTest_sortByKeys {

	DefaultKeyedValues defKVal;
	
	@Before
	public void setUp() throws Exception{
		defKVal = new DefaultKeyedValues();
		defKVal.addValue((Comparable<Integer>)5, 16);
		defKVal.addValue((Comparable<Integer>)2, 4);
		defKVal.addValue((Comparable<Integer>)300, 8);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test for ASCENDING sort 
	 */
	@Test(timeout = 1000)
	public void sortValidListInAscendingOrder() {
		
		defKVal.sortByKeys(SortOrder.ASCENDING); //TODO How to use this ?!?!
		
		assertEquals(0, defKVal.getIndex((Comparable<Integer>)2));
		assertEquals(1, defKVal.getIndex((Comparable<Integer>)5));
		assertEquals(2, defKVal.getIndex((Comparable<Integer>)300));
	}
	
	/**
	 * Test for DESCENDING sort 
	 */
	@Test(timeout = 1000)
	public void sortValidListInDescendingOrder() {
		
		defKVal.sortByKeys(SortOrder.DESCENDING); //TODO How to use this ?!?!
		
		assertEquals(0, defKVal.getIndex((Comparable<Integer>)300));
		assertEquals(1, defKVal.getIndex((Comparable<Integer>)5));
		assertEquals(2, defKVal.getIndex((Comparable<Integer>)2));

	}
}
