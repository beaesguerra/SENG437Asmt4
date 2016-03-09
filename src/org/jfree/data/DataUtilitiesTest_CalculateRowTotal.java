package org.jfree.data;

import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest_CalculateRowTotal {
	
	Mockery mockingContext;
	Values2D values;
	
	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
	}

	@After
	public void tearDown() throws Exception {
		mockingContext = null;
		values = null;
	}
	
	/**
	 * Test that row total works with normal values 
	 */
	@Test (timeout = 1000)
	public void calculateRowTotalForTwoPositiveValues() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0);
		// verify
		assertEquals("return value", 10.0, result, .000000001d);
		// tear-down: NONE in this test method
	}
	
	
	/**
	 * Test that row total works with negative values
	 */
	@Test (timeout = 1000)
	public void calculateRowTotalForTwoNegativeValues() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(-7.5));
				one(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0);
		// verify
		assertEquals("return value", -5.5, result, .000000001d);
		// tear-down: NONE in this test method
	}
	
	
	/**
	 * Testing an invalid Values2D data object (no cols)
	 */
	@Test (timeout = 1000)
	public void calculateRowTotalWithInvalidValues2D() {
		mockingContext.checking(new Expectations() 
		{
			{
				one(values).getColumnCount();
				will(returnValue(0));
				
				allowing(values).getRowCount();
				will(returnValue(0));
				
				allowing(values).getValue(0,0);
				will(returnValue(-1));
			}
		});
		
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("return value", 0.0,result, .000000001d);
	}
	
	
	/**
	 * Test when column specified is negative 
	 */
	@Test (timeout = 1000)
	public void calculateRowTotalForNegativeRow() {
		
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));

				allowing(values).getColumnCount();
				will(returnValue(2));
				
				// ignoring(values).getValue(arg0, arg1);//TODO finish this
				allowing(values).getValue(-1,0);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(-1,1);
				will(throwException(new IndexOutOfBoundsException()));
			}
		});

		double result = -1;
		
		try{
			result = DataUtilities.calculateRowTotal(values, -1);
			
		}catch(IndexOutOfBoundsException e){
			//if there was an invalid call to getValue this exception will be thrown
			fail("A call to 'getValue' of 2DValues was made with out-of-bounds parameters");
		}
		
		
		// verify
		assertEquals("return value", 0.0,result, .000000001d);
	}
	
	/**
	 * Test when column specified is above the table range
	 */
	@Test (timeout = 1000)
	public void calculateRowTotalForOutOfRangeRow() {
		
		mockingContext.checking(new Expectations() {{
			
			allowing(values).getRowCount();
			will(returnValue(2));

			allowing(values).getColumnCount();
			will(returnValue(2));
			
			// ignoring(values).getValue(arg0, arg1);//TODO finish this
			allowing(values).getValue(3,0);
			will(throwException(new IndexOutOfBoundsException()));
			allowing(values).getValue(3,1);
			will(throwException(new IndexOutOfBoundsException()));
		}});
		
		double result = -1;
		
		try{
			result = DataUtilities.calculateRowTotal(values, 3);	
			
		}catch(IndexOutOfBoundsException e){
			//if there was an invalid call to getValue this exception will be thrown
			fail("A call to 'getValue' of 2DValues was made with out-of-bounds parameters");
		}		
		
		// verify
		assertEquals("return value", result, 0.0, .000000001d);
		// tear-down: NONE in this test method
	}
	
}
