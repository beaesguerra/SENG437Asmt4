package org.jfree.data;

import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest_CalculateColumnTotal {
	
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

	@Test (timeout = 1000)
	public void calculateColumnTotalForInvalidData() {
		
	}
	
	@Test (timeout = 1000)
	public void calculateColumnTotalForTwoPositiveValues() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(10.0, result, .000000001d);
		// tear-down: NONE in this test method
	}
	
	/**
	 * Testing with negative values
	 */ 
	@Test (timeout = 1000)
	public void calculateColumnTotalForTwoNegativeValues() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(-2.5));
				one(values).getValue(1, 0);
				will(returnValue(1.5));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(-1.0, result, .000000001d);
		// tear-down: NONE in this test method
	}
	
	
	/**
	 * Testing an invalid Values2D data object (no rows)
	 */
	@Test (timeout = 1000)
	public void calculateColumnTotalWithInvalidValues2D() {
		mockingContext.checking(new Expectations() 
		{
			{
				one(values).getRowCount();
				will(returnValue(0));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0.0, result, .000000001d);
	}
	
	
	/**
	 * Test when column specified is negative 
	 */
	@Test (timeout = 1000)
	public void calculateColumnTotalForNegativeColumn() {
		
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));

				allowing(values).getColumnCount();
				will(returnValue(2));
				
				//if there is an invalid call to getValue throw getValue's exception  
				allowing(values).getValue(0, -1);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(1, -1);
				will(throwException(new IndexOutOfBoundsException()));
			}
		});
		
		double result = -1; //set default value for result 
		
		try{
			result = DataUtilities.calculateColumnTotal(values, -1);
			
		}catch(IndexOutOfBoundsException e){
			//if there was an invalid call to getValue this exception will be thrown
			fail("A call to 'getValue' of 2DValues was made with out-of-bounds parameters");
		}
		
	
		// verify
		assertEquals(0.0, result,.000000001d);
		// tear-down: NONE in this test method
	}
	
	/**
	 * Test when column specified is above the table range
	 */
	@Test (timeout = 1000)
	public void calculateColumnTotalForOutOfRangeColumn() {
		
		mockingContext.checking(new Expectations() {{
			
			allowing(values).getRowCount();
			will(returnValue(2));

			allowing(values).getColumnCount();
			will(returnValue(2));
			
			allowing(values).getValue(0, 3);
			will(throwException(new IndexOutOfBoundsException()));
			allowing(values).getValue(1, 3);
			will(throwException(new IndexOutOfBoundsException()));

		}});
		
		double result = -1;
		
		try{
			result = DataUtilities.calculateColumnTotal(values, 3);	
			
		}catch(IndexOutOfBoundsException e){
			//if there was an invalid call to getValue this exception will be thrown
			fail("A call to 'getValue' of 2DValues was made with out-of-bounds parameters");
		}			
		
		// verify
		assertEquals(0.0, result, .000000001d);
		// tear-down: NONE in this test method
	}

}
