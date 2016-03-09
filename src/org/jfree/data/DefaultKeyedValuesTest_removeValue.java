package org.jfree.data;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesTest_removeValue {

	DefaultKeyedValues defKVal;
	
	@Before
	public void setUp() throws Exception {
		
		defKVal = new DefaultKeyedValues();
		defKVal.addValue((Comparable<Integer>)1, 16);
		defKVal.addValue((Comparable<Integer>)2, 4);
		defKVal.addValue((Comparable<Integer>)3, 8);
		
	}

	@After
	public void removeExistingKey() throws Exception {
	}

	
	/**
	 * Remove value at null key
	 */
	@Test
	public void removeWhenKeyIsNull() {
		
		//remove the key
		Comparable<Integer> itemKey = null;
		defKVal.removeValue(itemKey);
		
		//check that the list size is the same
		assertEquals("Number of items in the data list", 3, defKVal.getItemCount());
		
		//test that the current list is unaltered
		assertEquals(16.0, defKVal.getValue((Comparable<Integer>)1));
		assertEquals(4.0, defKVal.getValue((Comparable<Integer>)2));
		assertEquals(8.0, defKVal.getValue((Comparable<Integer>)3));
		
	}
	
	/**
	 * Remove value at non-existent key
	 */
	@Test
	public void removeWhenKeyIsInvalid() {
		
		//remove the key
		Comparable<Integer> itemKey = 9;
		defKVal.removeValue(itemKey);
		
		assertEquals("Number of items in the data list", 3, defKVal.getItemCount());
		
		//test that the current list is unaltered
		assertEquals(16.0, defKVal.getValue((Comparable<Integer>)1));
		assertEquals(4.0, defKVal.getValue((Comparable<Integer>)2));
		assertEquals(8.0, defKVal.getValue((Comparable<Integer>)3));
		
	}
	
	/**
	 * Remove value at valid key
	 */
	@Test
	public void removeWhenKeyIsValid() {
		
		//remove the key
		Comparable<Integer> itemKey = 2;
		defKVal.removeValue(itemKey);
		
		//check that the list size has changed
		assertEquals("Number of items in the data list", 2, defKVal.getItemCount());
		
		//test that the current list has changed
		assertEquals(16.0, defKVal.getValue((Comparable<Integer>)1));
		assertEquals(8.0, defKVal.getValue((Comparable<Integer>)3));
		
	}
	
	
}
