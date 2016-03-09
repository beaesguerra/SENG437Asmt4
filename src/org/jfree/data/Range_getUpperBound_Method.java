package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class Range_getUpperBound_Method {

	private static Range range;
	private static double delta;
	private static double ActualValue;
	
	@Before
	public void setUp() throws Exception {
		delta = 0.00000001d;
	}
	
	/*
	 * Testing that proper upper bound is returned when using a decimal value
	 */
	@Test (timeout = 1000)
	public void SingleConstructionTest_PositiveDecimalUpperBound() {		
		range = new Range(2.65, 6.1234);
		ActualValue = range.getUpperBound();
		assertEquals("Testing that proper upper bound is returned when using a decimal value", 6.1234, ActualValue, delta);		
	}
	
	/*
	 * Testing that the proper upper bound is returned for negative integers when the lowerbound != upperbound
	 */
	@Test (timeout = 1000)
	public void SingleConstructionTest_NegativeUpperBound() {
		range = new Range(-4, -3);
		ActualValue = range.getUpperBound();
		assertEquals("Testing that the proper upper bound is returned for negative integers when the lowerbound != upperbound", -3, ActualValue, delta);
		
	}
	
	/*
	 * Testing that the proper bound is returned when using decimal values and lowerbound and upperbound are equivalent
	 */
	@Test (timeout = 1000)
	public void SingleConstructionTest_EquivalentUpperAndLowerBounds() {
		range = new Range(2.5, 2.5);
		ActualValue = range.getUpperBound();
		assertEquals("Testing that the proper bound is returned when using decimal values and lowerbound and upperbound are equivalent", 2.5, ActualValue, delta);

	}	
}
