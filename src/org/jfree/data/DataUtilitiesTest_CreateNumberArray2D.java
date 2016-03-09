package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest_CreateNumberArray2D {
	
	double[][] data;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}
	
	
	@Test (timeout = 1000)
	public void createEmptyArray() {
		
		data = new double[0][0];
		
		Number[][] result = DataUtilities.createNumberArray2D(data);
		
		//check whether the Number array is of the same length
		assertEquals("Length of Output array",  data.length, result.length);
		
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				
				assertNotNull("The Number array at index " + i +", " + j + " is null", result[i][j]);
				assertEquals("Output array value at index " + i, data[i][j], (double)result[i][j], 0.0 );
				
			}			
		}
	}
	
	@Test (timeout = 1000)
	public void createNoDecimal2DArray() {
		
		data = new double[][]{
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
		    { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
			{ 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }
		};
		
		Number[][] result = DataUtilities.createNumberArray2D(data);
		
		assertEquals("Length of Output array",  data.length, result.length);
		
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				
				assertNotNull("The Number array at index " + i +", " + j + " is null", result[i][j]);
				assertEquals("Output array value at index " + i, data[i][j], (double)result[i][j], 0.0 );
				
			}
			
		}
	}
	
	@Test (timeout = 1000)
	public void createDecimal2DArray() {
		
		data = new double[][]{
			{ 1.23, 2.44, 3.536, 4.444, 5.99, 6.23, 7.45, 8.123, 9.124, 10.1212 },
		    { 10.2345, 9.654, 8, 7.567, 6, 5.7675, 4.123, 3.12344, 2.3456, 1.12345 },
			{ 11.0987, 12.00, 13, 14.999, 15.006, 16.0101, 17.2345, 18.6578, 19, 20 }
		};
		
		Number[][] result = DataUtilities.createNumberArray2D(data);
		
		assertEquals("Length of Output array",  data.length, result.length);
		
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				
				assertNotNull("The Number array at index " + i +", " + j + " is null", result[i][j]);
				assertEquals("Output array value at index " + i, data[i][j], (double)result[i][j], 0.0 );
				
			}
			
		}
		
	}
	
	@Test (timeout = 1000)
	public void createNegativeValues2DArray() {

		data = new double[][]{
			{ -1.23, 2.44, -3.536, -4.444, 5.99, 6.23, 7.45, 8.123, -9.124, 10.1212 },
		    { -10.2345, -9.654, 8, -7.567, 6, -5.7675, 4.123, 3.12344, -2.3456, 1.12345 },
			{ 11.0987, -12.00, 13, 14.999, -15.006, -16.0101, 17.2345, -18.6578, -19, 20 }
		};
		
		Number[][] result = DataUtilities.createNumberArray2D(data);
		
		assertEquals("Length of Output array",  data.length, result.length);
		
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				
				assertNotNull("The Number array at index " + i +", " + j + " is null", result[i][j]);
				assertEquals("Output array value at index " + i, data[i][j], (double)result[i][j], 0.0 );
				
			}
			
		}
		
	}
	
	
	/**
	 * Test a 1 dimensional array
	 */
	@Test (timeout = 1000)
	public void create1DArray() {
		data = new double[][]{{1,2,3,4,5,6,7,8,9,10}};
		
		Number[][] result = DataUtilities.createNumberArray2D(data);
		
		//check whether the Number array is of the same length
		assertEquals("Length of Output array",  data.length, result.length);
				
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				assertNotNull("The Number array at index " + i +", " + j + " is null", result[i][j]);
				assertEquals("Output array value at index " + i, data[i][j], (double)result[i][j], 0.0 );
			}			
		}
	}	
	@Test (timeout = 1000, expected=IllegalArgumentException.class)
	public void createNull2DArray(){
		DataUtilities.createNumberArray2D(null);
	}

}
