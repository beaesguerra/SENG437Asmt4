package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Range_CombineMethod {

	Range range1;
	Range range2;
	Range ActualRange;
	Range expectedRange;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (timeout = 1000)
	public void Combine_BothRangesAreNull_Test() {
		range1 = null;	range2 = null;
		ActualRange = Range.combine(range1, range2);
		expectedRange = null;
		assertEquals("Testing that null is returned when both inputs are null", expectedRange, ActualRange);
	}
	
	@Test (timeout = 1000)
	public void Combine_Range1IsNull_Range2IsValid_Test() {
		range1 = null;	range2 = new Range(1,5);
		ActualRange = Range.combine(range1, range2);
		expectedRange = new Range(1,5);
		assertEquals("Testing that range2 is returned when range1 is null and range2 is valid", expectedRange, ActualRange);
	}

	@Test (timeout = 1000)
	public void Combine_Range2IsNull_Range1IsValid_Test() {
		range1 = new Range(1,2);	range2 = null;
		ActualRange = Range.combine(range1, range2);
		expectedRange = new Range(1,2);
		assertEquals("Testing that range1 is returned when range2 is null and range1 is valid", expectedRange, ActualRange);
	}
	
	@Test (timeout = 1000)
	public void Combine_Range1_Encompasses_Range2_Test() {
		range1 = new Range(1,5);	range2 = new Range(2,4);
		ActualRange = Range.combine(range1, range2);
		expectedRange = new Range(1,5);
		assertEquals("Testing that range1 is returned when range2 is completely encompassed by range1", expectedRange, ActualRange);
	}
	
	@Test (timeout = 1000)
	public void Combine_Range2_Encompasses_Range1_Test() {
		range1 = new Range(2,3);	range2 = new Range(1,5);
		ActualRange = Range.combine(range1, range2);
		expectedRange = new Range(1,5);
		assertEquals("Testing that range2 is returned when range1 is completely encompassed by range2", expectedRange, ActualRange);
	}
	
	@Test (timeout = 1000)
	public void Combine_Range1isLessthanRange2OnLowerbound_Range2isGreaterthanRange1onUpperbound_Test() {
		range1 = new Range(1,3);	range2 = new Range(2,4);
		ActualRange= Range.combine(range1, range2);
		expectedRange = new Range(1,4);
		assertEquals("Testing that the range returned is expanded on both sides given a lower bound decrease from range1 and an upperbound increase from range2"
				, expectedRange, ActualRange);
	}
}
