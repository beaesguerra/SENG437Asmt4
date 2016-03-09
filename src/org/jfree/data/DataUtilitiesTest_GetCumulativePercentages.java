package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest_GetCumulativePercentages {
	
	
	Mockery mockingContext;
	KeyedValues keyvalues;

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
		keyvalues = mockingContext.mock(KeyedValues.class);
	}

	@After
	public void tearDown() throws Exception {
		mockingContext = null;
		keyvalues = null;
	}
	
	/**
	 * All keys have positive values
	 */
	@Test (timeout = 1000)
	public void getCumulativePercentagesKeysHavePositiveValues() {
		
		mockingContext.checking(new Expectations() {
			{
				allowing(keyvalues).getItemCount();
				will(returnValue(3));
				
				allowing(keyvalues).getValue(0);
				will(returnValue(5));
				allowing(keyvalues).getValue(1);
				will(returnValue(9));
				allowing(keyvalues).getValue(2);
				will(returnValue(2));
				
				allowing(keyvalues).getKey(0);
				will(returnValue(0));
				allowing(keyvalues).getKey(1);
				will(returnValue(1));
				allowing(keyvalues).getKey(2);
				will(returnValue(2));
				
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);
		assertEquals("Key 0 value", 0.3125, (double)result.getValue(0), 0.000000001d);
		assertEquals("Key 2 value", 1.0, (double)result.getValue(2), 0.000000001d);
	}



	@Test (timeout = 1000)
	public void getCumulativePercentageSomeKeysHaveNegativeValues() {
		
		
		mockingContext.checking(new Expectations() {
			{
				allowing(keyvalues).getItemCount();
				will(returnValue(3));
				
				allowing(keyvalues).getValue(0);
				will(returnValue(-6));
				allowing(keyvalues).getValue(1);
				will(returnValue(0));
				allowing(keyvalues).getValue(2);
				will(returnValue(-10));
				
				allowing(keyvalues).getKey(0);
				will(returnValue(0));
				allowing(keyvalues).getKey(1);
				will(returnValue(1));
				allowing(keyvalues).getKey(2);
				will(returnValue(2));
				
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);
		assertEquals("Key 0 value", 0.375, (double)result.getValue(0), 0.000000001d);
		assertEquals("Key 2 value", 1.0, (double)result.getValue(2), 0.000000001d);
	}
	
	@Test (timeout = 1000)
	public void getCumulativePercentageWhereAllValuesAreZero() {

		mockingContext.checking(new Expectations() {
			{
				allowing(keyvalues).getItemCount();
				will(returnValue(3));
				
				allowing(keyvalues).getValue(0);
				will(returnValue(0));
				allowing(keyvalues).getValue(1);
				will(returnValue(0));
				allowing(keyvalues).getValue(2);
				will(returnValue(0));
				
				allowing(keyvalues).getKey(0);
				will(returnValue(0));
				allowing(keyvalues).getKey(1);
				will(returnValue(1));
				allowing(keyvalues).getKey(2);
				will(returnValue(2));
				
			}
		});
		
		
		//Dividing by zero should result in NaN value
		KeyedValues result = DataUtilities.getCumulativePercentages(keyvalues);
		assertEquals("Key 0 value", Double.NaN, (double)result.getValue(0), 0.000000001d);
		assertEquals("Key 2 value", Double.NaN, (double)result.getValue(2), 0.000000001d);

	}
	
	@Test (timeout = 1000, expected=IllegalArgumentException.class)
	public void accessNullData(){
		DataUtilities.getCumulativePercentages(null);
	}
	
	
}
