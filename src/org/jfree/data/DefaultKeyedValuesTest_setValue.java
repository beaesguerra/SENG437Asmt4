package org.jfree.data;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesTest_setValue {

	DefaultKeyedValues defKVal;
	
	@Before
	public void setUp() throws Exception {
		
		defKVal = new DefaultKeyedValues();
		defKVal.addValue((Comparable<Integer>)1, 16);
		defKVal.addValue((Comparable<Integer>)2, 4);
		defKVal.addValue((Comparable<Integer>)3, 8);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Add to a null key
	 */
	@Test(timeout = 1000, expected=IllegalArgumentException.class)
	public void keyIsNull() {
		
		Comparable<Integer> itemKey = null;
		defKVal.setValue(itemKey, 12); 
	}
	
	/**
	 * Test for when the key is not in the data list 
	 */
	@Test (timeout = 1000)
	public void keyDoesNotExist(){
		
		Comparable<Integer> itemKey = 5;

		defKVal.setValue(itemKey, 12);
		
		//check that the key
		assertEquals("Value at key 5", 12.0, defKVal.getValue(itemKey));
	}
	
	/**
	 * Test for when the key is already in the data list
	 */
	@Test (timeout = 1000)
	public void keyExists(){
		
		Comparable<Integer> itemKey = 3;
		
		assertEquals("Value at key 3", 8.0, defKVal.getValue(itemKey));
		
		defKVal.setValue(itemKey, 69); 
		
		assertEquals("Value at key 3", 69.0, defKVal.getValue(itemKey));
	}
	

}
