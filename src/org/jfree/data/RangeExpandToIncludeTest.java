package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandToIncludeTest {
	private Range range; 
	@Before
	public void setUp() throws Exception {
		range = new Range(5,10); 
	}

	@Test
	public void RangeIsNullTest() {
		range = null; 
		double value = 0;
		Range actual = Range.expandToInclude(range, value);
		Range expected = new Range(value,value);
		assertEquals("RangeIsNullTest",expected,actual); 
	}
	@Test 
	public void ValueLessThanLowerBoundTest() {
		double value = 1;
		Range actual = Range.expandToInclude(range, value);
		Range expected = new Range(1,10);
		assertEquals("ValueLessThanLowerBoundTest",expected,actual); 
	}
	@Test 
	public void ValueGreaterThanUpperBoundTest() {
		double value = 12;
		Range actual = Range.expandToInclude(range, value);
		Range expected = new Range(5,12);
		assertEquals("ValueGreaterThanUpperBoundTest",expected,actual); 
	}
	@Test 
	public void ValueWithinRangeTest() {
		double value = 7;
		Range actual = Range.expandToInclude(range, value);
		Range expected = new Range(5,10);
		assertEquals("ValueWithinRangeTest",expected,actual); 
	}

	

}
