package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Range_Shift_ZeroCrossingOption {

	Range range;
	Range expected;	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (timeout = 1000)
	public void Shift_Positivebounds_With_ZC_Test() {
		range = new Range(2,5);
		range = Range.shift(range, 3, true);
		expected = new Range(5,8);
		assertEquals("Testing that the bounds are both shifted to the right", expected, range);
	}

	@Test (timeout = 1000)
	public void Shift_NegativeBounds_To_PositiveBounds_With_ZC_Test() {
		range = new Range(-5,-2);
		range = Range.shift(range, 10, true);
		expected = new Range(5,8);
		assertEquals("Testing that the bounds are properly shifted from negative to positive", expected, range);
	}
	
	@Test (timeout = 1000)
	public void Shift_PositiveBounds_To_NegativeBounds_With_ZC_Test() {
		range = new Range(1,2);
		range = Range.shift(range, -5, true);
		expected = new Range(-4,-3);
		assertEquals("Testing that the bounds are properly shifted from positive to negative", expected, range);
	}

	@Test (timeout = 1000)
	public void Shift_ShiftingByZero_With_ZC_Test() {
		range = new Range(1,2);
		range = Range.shift(range, 0, true);
		expected = new Range(1,2);
		assertEquals("Testing that the bounds are not changed when shifted by zero", expected, range);
	}
	
	@Test (timeout = 1000)
	public void Shift_Right_BoundEqualToZero_Without_ZC_Test() {
		range = new Range(0,1);
		range = Range.shift(range, 1, false);
		expected = new Range(1,2);
		assertEquals("Testing that bounds equal to zero shift to the right", expected, range);
	}

	@Test (timeout = 1000)
	public void Shift_Left_BoundEqualToZero_Without_ZC_Test() {
		range = new Range(-1,0);
		range = Range.shift(range, -1, false);
		expected = new Range(-2,-1);
		assertEquals("Testing that bounds equal to zero shift to the left", expected, range);
	}	
	
	@Test (timeout = 1000)
	public void Shift_NegativeBounds_To_PositiveBounds_Without_ZC_Test() {
		range = new Range(-5,-2);
		range = Range.shift(range, 4, false);
		expected = new Range(-1,0);
		assertEquals("Testing that the bounds are properly shifted from negative to positive when no zero crossing", expected, range);
	}
	
	@Test (timeout = 1000)
	public void Shift_PositiveBounds_To_NegativeBounds_Without_ZC_Test() {
		range = new Range(1,2);
		range = Range.shift(range, -2, false);
		expected = new Range(0,1);
		assertEquals("Testing that the bounds are properly shifted from positive to negative when no zero crossing", expected, range);
	}
	
	
}
