package org.jfree.data;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesTest_getKeys {

	DefaultKeyedValues defKVal;
	

	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test for valid list
	 */
	@Test(timeout = 1000)
	public void getKeysWithValidList() {
		
		defKVal = new DefaultKeyedValues();
		defKVal.addValue((Comparable<Integer>)1, 16);
		defKVal.addValue((Comparable<Integer>)2, 4);
		defKVal.addValue((Comparable<Integer>)3, 8);
		
		ArrayList<Integer> result = (ArrayList<Integer>) defKVal.getKeys(); 
		
		//check size of the list 
		assertEquals("The size of get key result list", 3, result.size());
		
		//check that the values are unaltered
		assertEquals((Integer)1, result.get(0));
		assertEquals((Integer)2, result.get(1));
		assertEquals((Integer)3, result.get(2));
	}
	
	/**
	 * Test for empty list
	 */
	@Test(timeout = 1000)
	public void getKeysWithEmptyList() {
		
		defKVal = new DefaultKeyedValues();
		
		ArrayList<Integer> result = (ArrayList<Integer>) defKVal.getKeys(); 
		
		assertEquals("The size of get key result list", 0, result.size());
		
	}

	
	
	

}
