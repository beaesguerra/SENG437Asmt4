package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeLowerBoundTest{

	private Range range; 
	private double positiveInfinity = Double.POSITIVE_INFINITY;
	private double negativeInfinity = Double.NEGATIVE_INFINITY; 
	

	@Test (timeout = 1000)
	public void NegativeInfinityLowerBound() {
		range = new Range(negativeInfinity,0);
		double actualLowerValue = range.getLowerBound();
		double expectedLowerValue = negativeInfinity; 
		assertEquals("Testing negative infinity for lower bound", expectedLowerValue, actualLowerValue, 0);
	}
	@Test (timeout = 1000)
	public void PositiveInfinityLowerBound() {
		range = new Range(positiveInfinity, positiveInfinity); 
		double actualLowerValue = range.getLowerBound();
		double expectedLowerValue = positiveInfinity; 
		assertEquals("Testing positive infinity for lower bound", expectedLowerValue, actualLowerValue, 0);
	}
	@Test (timeout = 1000)
	public void PositiveLowerBound() {
		range = new Range(1.5,4.5);
		double actualLowerValue = range.getLowerBound();
		double expectedLowerValue = 1.5;
		assertEquals("Testing when the lower bound is positive and less than upper bound", expectedLowerValue, actualLowerValue, 0);
	}
	
	@Test (timeout = 1000)
	public void NegativeLowerBound() {
		range = new Range(-5,-2);
		double actualLowerValue = range.getLowerBound();
		double expectedLowerValue = -5;
		assertEquals("Testing when the lower bound is negative and less than upper bound", expectedLowerValue , actualLowerValue, 0);
	}
	
	@Test (timeout = 1000)
	public void ZeroLowerBound() {
		range = new Range(0,5); 
		double actualLowerValue = range.getLowerBound();
		double expectedLowerValue = 0;
		assertEquals("Testing when the lower bound is zero and less than upper bound", expectedLowerValue, actualLowerValue, 0);
	}
	
	@Test (timeout = 1000)
	public void SameLowerUpperBounds() {
		range = new Range(1,1);
		double actualLowerValue = range.getLowerBound();
		double expectedLowerValue = 1;
		assertEquals("Testing when the lower bound is equal to the upper bound", expectedLowerValue, actualLowerValue, 0);
	}
	
}

