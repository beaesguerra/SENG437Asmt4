package org.jfree.data;

import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest_CreateNumberArray {
	
	double[] data;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}

	
	/**
	 * Testing empty array
	 */
	@Test (timeout = 1000)
	public void createEmptyArray(){
		
		data = new double[0]; //redefine data array to be of size 0
		
		Number[] result = DataUtilities.createNumberArray(data);
		
		//check whether the Number array is of the same length
		assertEquals("Length of Output array",  data.length, result.length);
		
		//check that all the values are correct
		for(int i = 0; i < result.length && i < data.length; i++){
		
			assertNotNull("The Number array at index " + i + "is null", result[i]);
			assertEquals("Output array value at index " + i, data[i], (double)result[i], .000000001d);
		}
	}
	
	
	
	/**
	 * Testing a simple array conversion with simple numbers (i.e. no decimals)
	 */
	@Test (timeout = 1000)
	public void createNoDecimalArray(){
		
		data = new double[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Number[] result = DataUtilities.createNumberArray(data);
		
		
		assertEquals("Length of Output array",  data.length, result.length);
		
		//check that all the values are correct
		for(int i = 0; i < result.length && i < data.length; i++){
		
			assertNotNull("The Number array at index " + i + "is null", result[i]);
			assertEquals("Output array value at index " + i, data[i], (double)result[i], .000000001d);
		}
		
	}
	
	

	/**
	 * Testing array with more complicated values  (i.e. longer decimal values) 
	 */
	@Test (timeout = 1000)
	public void createDecimalArray(){
		data = new double[]{21.432, 3.232, 4.5433, 6.77, 8.99};
		
		Number[] result = DataUtilities.createNumberArray(data);
		
		
		assertEquals("Length of Output array",  data.length, result.length);
		
		
		//check that all the values are correct
		for(int i = 0; i < result.length && i < data.length; i++){
			assertNotNull("The Number array at index " + i + "is null", result[i]);
			assertEquals("Output array value at index " + i, data[i], (double)result[i], .000000001d);
		}
		
	}
	
	
	/**
	 * Tests an array containing some negative values
	 */
	@Test (timeout = 1000)
	public void createNegativeValueArray(){
		data = new double[]{-21.432, -3.232, 4.5433, -6.77, 10.99};
		
		Number[] result = DataUtilities.createNumberArray(data);
		
		
		assertEquals("Length of Output array",  data.length, result.length);
		
		
		//check that all the values are correct
		for(int i = 0; i < result.length && i < data.length; i++){
			assertNotNull("The Number array at index " + i + "is null", result[i]);
			assertEquals("Output array value at index " + i, data[i], (double)result[i], .000000001d);
		}
	}
	
	@Test (timeout = 1000, expected=IllegalArgumentException.class)
	public void createNullArray(){
		DataUtilities.createNumberArray(null);
	}
	
	

}
