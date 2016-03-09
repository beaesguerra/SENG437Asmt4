package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class Range_Contains_Method {

	private static Range range;
	private static boolean ActualResult;
	
	
	/*
	 * Testing contains returns true for upper bounds exact value
	 */
	@Test (timeout = 1000)
	public void BasicBoundsTest_ExactUpperBounds() {
		range = new Range(2.0,5.0);
		ActualResult = range.contains(5.0);
		assertEquals("Testing contains returns true for upper bounds exact value", true, ActualResult);
	}
	
	/*
	 * Testing contains returns false for values greater than the upper bounds
	 */
	@Test (timeout = 1000)
	public void BasicBoundsTest_GreaterThanUpperBounds() {
		range = new Range(2.0,5.0);
		ActualResult = range.contains(6.0);
		assertEquals("Testing contains returns false for values greater than the upper bounds", false, ActualResult);		
	}
	
	/*
	 * Testing contains returns true for values less than the upper bounds but greater than lower bounds
	 */
	@Test (timeout = 1000)
	public void BasicBoundsTest_DecimalWithinRange() {
		range = new Range(2.0,5.0);
		ActualResult = range.contains(4.2342123);
		assertEquals("Testing contains returns true for values less than the upper bounds but greater than lower bounds",
				true, ActualResult);
	}
	
	/*
	 * Testing contains returns true for lower bounds exact value
	 */
	@Test (timeout = 1000)
	public void BasicBoundsTest_ExactLowerBounds() {
		range = new Range(2.0,5.0);
		ActualResult = range.contains(2.0);
		assertEquals("Testing contains returns true for lower bounds exact value", true, ActualResult);
	}
	
	/*
	 * Testing contains returns true for values greater than the lower bound but less than upper bound
	 */
	@Test (timeout = 1000)
	public void BasicBoundsTest_NormalValueWithinRange() {
		range = new Range(2.0,5.0);	
		ActualResult = range.contains(3.5);
		assertEquals("Testing contains returns true for values greater than the lower bound but less than upper bound", 
				true, ActualResult);		
	}
	
	@Test (timeout = 1000)
	public void BasicBoundsTest_LessThanLowerBounds() {
		range = new Range(2.0,5.0);
		ActualResult = range.contains(1.0);
		assertEquals("Testing contains returns false for values less than the lower bounds", false, ActualResult);

	}
	
	/*
	 * Testing true case for negative lower bound and positive upperbound functions as signed values
	 */
	@Test (timeout = 1000)
	public void NegativeLowerBoundPositiveUpperBound_WithinRange() {
		range = new Range(-5.0, 5.0);
		ActualResult = range.contains(0);
		assertEquals("Testing true case for negative lower bound and positive upperbound functions as signed values", true, ActualResult);
	}

	/*
	 * Testing case where contains method is used for a value less than the lower bound
	 */
	@Test (timeout = 1000)
	public void NegativeLowerBoundPositiveUpperBound_LowerThanRange() {
		range = new Range(-5.0, 5.0);
		ActualResult = range.contains(-5.1);
		assertEquals("Testing case where contains method is used for a value less than the lower bound", false, ActualResult);
		
	}
	
	/*
	 * Testing case where contains method is used for a value greater than the upper bound
	 */
	@Test (timeout = 1000)
	public void NegativeLowerBoundPositiveUpperBound_GreaterThanRange() {
		range = new Range(-5.0, 5.0);
		ActualResult = range.contains(5.1);
		assertEquals("Testing case where contains method is used for a value greater than the upper bound", false, ActualResult);
	}
	
	
	
	/*
	 * Testing contains returns true when exact value of bounds is selected
	 */
	@Test (timeout = 1000)
	public void EquivalentUpperAndLowerBounds_WithinRange() {
		range = new Range(1.5,1.5);
		ActualResult = range.contains(1.5);
		assertEquals("Testing contains returns true when exact value of bounds is selected", true, ActualResult);				
	}
	
	/*
	 * Testing contains returns false when a value lower than the bounds is selected
	 */
	@Test (timeout = 1000)
	public void EquivalentUpperAndLowerBounds_LessThanLowerBound() {
		range = new Range(1.5,1.5);
		ActualResult = range.contains(1.4);
		assertEquals("Testing contains returns false when a value lower than the bounds is selected", false, ActualResult);
				
	}
	
	/*
	 * Testing contains returns false when a value greater than the bounds is selected
	 */
	@Test (timeout = 1000)
	public void EquivalentUpperAndLowerBounds_GreaterThanUpperBound() {
		range = new Range(1.5,1.5);
		ActualResult = range.contains(1.6);
		assertEquals("Testing contains returns false when a value greater than the bounds is selected", false, ActualResult);		
	}

}
