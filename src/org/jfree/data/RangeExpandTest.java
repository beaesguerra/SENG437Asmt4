package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandTest {

	private Range range; 
	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void RangeIsNullTest() {
		range = null; 
		double lowerMargin = 0.2; 
		double upperMargin = 0.5;
		Range.expand(range, lowerMargin, upperMargin); 
	}
	@Test
	public void RangeLengthZeroTest() {
		range = new Range(2,2); 
		double lowerMargin = 0.2; 
		double upperMargin = 0.5;
		Range actual = Range.expand(range, lowerMargin, upperMargin); 
		Range expected = new Range(2,2);
		assertEquals("RangeLengthZeroTest", expected, actual);
	}
	@Test
	public void PositiveDecimalLessThanOneMarginsTest() {
		range = new Range(2,6); 
		double lowerMargin = 0.25; 
		double upperMargin = 0.5;
		Range actual = Range.expand(range, lowerMargin, upperMargin); 
		Range expected = new Range(1,8);
		assertEquals("PositiveDecimalLessThanOneMarginsTest",expected, actual);
	}

	@Test
	public void PositiveDecimalGreaterThanOneMarginsTest() {
		range = new Range(2,6); 
		double lowerMargin = 2; 
		double upperMargin = 1.5;
		Range actual = Range.expand(range, lowerMargin, upperMargin); 
		Range expected = new Range(-6,12);
		assertEquals("PositiveDecimalGreaterThanOneMarginsTest",expected, actual);
	}
	@Test
	public void NegativePercentagesMarginTest() {
		range = new Range(2,6); 
		double lowerMargin = -0.25; 
		double upperMargin = -0.5;
		Range actual = Range.expand(range, lowerMargin, upperMargin); 
		Range expected = new Range(3,7);
		assertEquals("NegativePercentagesMarginTest",expected, actual);
	}
	

}
