package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Range_ToStringMethod {

	Range range;
	String expected;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (timeout = 1000)
	public void PositiveBoundsTest() {
		range = new Range(2.0,5.0);
		expected = "Range[2.0,5.0]";
		String s = range.toString();
		assertEquals("Testing the proper string is ouputted when the ranges bounds are both positive", expected, s);
	}

	@Test (timeout = 1000)
	public void NegativeBoundsTest() {
		range = new Range(-5.0,-2.0);
		expected = "Range[-5.0,-2.0]";
		String s = range.toString();
		assertEquals("Testing the proper string is ouputted when the ranges bounds are both positive", expected, s);
	}
	
	@Test (timeout = 1000)
	public void longDecimalBoundsTest() {
		range = new Range(1.234567, 2.345678);
		expected = "Range[1.234567,2.345678]";
		String s = range.toString();
		assertEquals("Testing decimal values are retained", expected, s);
	}
	
	@Test (timeout = 1000)
	public void IntegerInputsForBoundsTest() {
		range = new Range(1,2);
		expected = "Range[1.0,2.0]";
		String s = range.toString();
		assertEquals("Testing that proper values are handled when range is instanciated using integers", expected, s);
	}
}

