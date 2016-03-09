package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Range_Intersects_Method {

	Range testRange;
	boolean actual;
	boolean expected;
	double lower;
	double upper;
	
	@Before
	public void setUp() {
		testRange = new Range(-5,5);		
	}
	
	@Test (timeout = 1000)
	public void Intersect_BothValuesInteriorToRange_test() {
		lower = -5;		upper = 5;
		actual = testRange.intersects(lower, upper);
		expected = true;
		assertEquals("Testing intersects returns true when both bounds are within range", expected, actual);
	}
	
	@Test (timeout = 1000)
	public void Intersect_LowerBoundOut_UpperBoundIn_test() {
		lower = -6; 	upper = 0;
		actual = testRange.intersects(lower, upper);
		expected = true;
		assertEquals("Testing intersects returns true when lower bound is out of range and upper bound is within range", expected, actual);
	}
	
	@Test (timeout = 1000)
	public void Intersect_BothValuesLessThanRange_test() {
		lower = -7;		upper = -8;
		actual = testRange.intersects(lower, upper);
		expected = false;
		assertEquals("Testing intersects returns false when both bounds are less than the lower bound of the range", expected, actual);
	}
	
	@Test (timeout = 1000)
	public void Intersect_LowerBoundIn_UpperBoundOut_test() {	
		lower = -4;		upper = 6;
		actual = testRange.intersects(lower, upper);
		expected = true;
		assertEquals("Testing intersects returns true when the lower bound is within range and upper bound is above range", expected, actual);
	}
	
	@Test (timeout = 1000)
	public void Intersect_BothValuesGreaterThanRange_test() {
		lower = 6;		upper = 7;
		actual = testRange.intersects(lower, upper);
		expected = false;
		assertEquals("Testing intersects returns false when both bounds are above range's upper bound", expected, actual);
	}
}
