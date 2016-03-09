package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeEqualsTest {
	private Range range; 

	@Before
	public void setUp() throws Exception {
		range = new Range(5,10); 
	}

	@Test
	public void objectToEqualToNotRange() {
		Integer temp = new Integer(5); 
		boolean actual = range.equals(temp);
		boolean expected = false; 
		assertEquals("objectToEqualToNotRange",expected, actual);
	}
	@Test
	public void objectToEqualToRange() {
		Range temp = new Range(5, 10); 
		boolean actual = range.equals(temp);
		boolean expected = true; 
		assertEquals("objectToEqualToRange",expected, actual);
	}
	
	@Test
	public void objectUnequalLowerBoundRange() {
		Range temp = new Range(4, 10); 
		boolean actual = range.equals(temp);
		boolean expected = false; 
		assertEquals("objectUnequalLowerBoundRange",expected, actual);
	}
	@Test
	public void objectUnequalUpperBoundRange() {
		Range temp = new Range(5, 11); 
		boolean actual = range.equals(temp);
		boolean expected = false; 
		assertEquals("objectUnequalUpperBoundRange", expected, actual);
	}
	
	@Test
	public void objectUnequalBoundsRange() {
		Range temp = new Range(4, 11); 
		boolean actual = range.equals(temp);
		boolean expected = false; 
		assertEquals("objectUnequalBoundsRange", expected, actual);
	}

}
