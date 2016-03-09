package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class Range_Shift_NoZeroCrossingOption_Method {

	Range actual;
	Range expected;
	
	@Test (timeout = 1000)
	public void Shift_PositiveBounds_To_PositiveBounds_test() {
		actual = new Range(1,2);
		actual = Range.shift(actual, 5);
		expected = new Range(6,7);
		assertEquals("Testing that shift correctly shifts positive bounds to the right", expected, actual);
	}

	@Test (timeout = 1000)
	public void Shift_NegativeBounds_To_PositiveBounds_test() {
		actual = new Range(-3,-1);
		actual = Range.shift(actual, 2);
		expected = new Range(-1,0);
		assertEquals("Testing that shift correctly shifts negative values to the right but stop at zero", expected, actual);
	}
	
	@Test (timeout = 1000)
	public void Shift_PositiveBounds_To_NegativeBounds_test() {
		actual = new Range(1,3);
		actual = Range.shift(actual, -2);
		expected = new Range(0,1);
		assertEquals("Testing that shift correctly shifts positive values to the left but stops at zero", expected, actual);
	}
	
	@Test (timeout = 1000)
	public void Shift_NegativeBounds_To_NegativeBounds_test() {
		actual = new Range(-3,-1);
		actual = Range.shift(actual, -2);
		expected = new Range(-5,-3);
		assertEquals("Testing that shift correctly shifts negative values to the left", expected, actual);
	}
}
