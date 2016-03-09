package org.jfree.data;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesTest_getValue {

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
	 * Test for when the key is null
	 */
	@Test(timeout = 1000, expected=UnknownKeyException.class)
	public void keyIsNull() {
		
		Comparable<Integer> itemKey = null;
		defKVal.getValue(itemKey); //don't need to check return value because an exception is expected
	}
	
	/**
	 * Test for when the key is invalid
	 */
	@Test(timeout = 1000, expected=UnknownKeyException.class)
	public void keyisInvalid(){
		
		Comparable<Integer> itemKey = 5;
		defKVal.getValue(itemKey); //don't need to check return value because an exception is expected
	}
	
	/**
	 * Test for when the key is valid
	 */
	@Test (timeout = 1000)
	public void keyisValid(){
		
		Comparable<Integer> itemKey = 3;
		Number returnValue = defKVal.getValue(itemKey); 
		
		assertEquals("The return value", 8.0, returnValue);
	}
	

}
