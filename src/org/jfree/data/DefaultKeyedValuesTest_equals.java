package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesTest_equals {

	DefaultKeyedValues dkvs;
	
	@Before
	public void setUp() throws Exception {
		dkvs = new DefaultKeyedValues();
		dkvs.addValue((Comparable<Integer>)1, 25);
		dkvs.addValue((Comparable<Integer>)3, 26);
		dkvs.addValue((Comparable<Integer>)4, 2);
		dkvs.addValue((Comparable<Integer>)6, 7);
		dkvs.addValue((Comparable<Integer>)5, null);
	}

	@After
	public void tearDown() throws Exception {
		dkvs = null;
	}

	@Test (timeout = 1000)
	public void testSameObject() {
		boolean result = dkvs.equals(dkvs);
		assertEquals("Testing equals with the same object returns true", true, result);
	}
	
	@Test (timeout = 1000)
	public void testDifferentObject() {
		boolean result = dkvs.equals(10);
		assertEquals("Testing equals with different objects that are not the same returns fale", false, result);
	}
	
	@Test (timeout = 1000)
	public void testSameValues() {
		DefaultKeyedValues defKeyValues = new DefaultKeyedValues();
		defKeyValues.addValue((Comparable<Integer>)1, 25);
		defKeyValues.addValue((Comparable<Integer>)3, 26);
		defKeyValues.addValue((Comparable<Integer>)4, 2);
		defKeyValues.addValue((Comparable<Integer>)6, 7);
		defKeyValues.addValue((Comparable<Integer>)5, null);
		boolean result = dkvs.equals(defKeyValues);
		assertEquals("Testing equals with objects with the same values returns true", true, result);
	}
	
	@Test (timeout = 1000)
	public void testDifferentObjectSize() {
		DefaultKeyedValues defKeyValues = new DefaultKeyedValues();
		defKeyValues.addValue((Comparable<Integer>)1, 25);
		defKeyValues.addValue((Comparable<Integer>)3, 26);
		defKeyValues.addValue((Comparable<Integer>)4, 2);
		boolean result = dkvs.equals(defKeyValues);
		assertEquals("Testing equals with objects of different sizes returns false", false, result);
	}
	
	@Test (timeout = 1000)
	public void testSomeSimmilarValues() {
		DefaultKeyedValues defKeyValues = new DefaultKeyedValues();
		defKeyValues.addValue((Comparable<Integer>)1, 25);
		defKeyValues.addValue((Comparable<Integer>)3, 26);
		defKeyValues.addValue((Comparable<Integer>)4, 2);
		defKeyValues.addValue((Comparable<Integer>)6, 7);
		defKeyValues.addValue((Comparable<Integer>)5, 10);
		boolean result = dkvs.equals(defKeyValues);
		assertEquals(false, result);
	}
	
	@Test (timeout = 1000)
	public void testSomeNullValues() {
		DefaultKeyedValues defKeyValues = new DefaultKeyedValues();
		defKeyValues.addValue((Comparable<Integer>)1, 25);
		defKeyValues.addValue((Comparable<Integer>)3, null);
		defKeyValues.addValue((Comparable<Integer>)4, 2);
		defKeyValues.addValue((Comparable<Integer>)6, 7);
		defKeyValues.addValue((Comparable<Integer>)5, 10);
		boolean result = dkvs.equals(defKeyValues);
		assertEquals(false, result);
	}
	
	@Test (timeout = 1000)
	public void testSomeSimmilarKeys() {
		DefaultKeyedValues defKeyValues = new DefaultKeyedValues();
		defKeyValues.addValue((Comparable<Integer>)1, 25);
		defKeyValues.addValue((Comparable<Integer>)3, 26);
		defKeyValues.addValue((Comparable<Integer>)2, 2);
		defKeyValues.addValue((Comparable<Integer>)6, 7);
		defKeyValues.addValue((Comparable<Integer>)5, 10);
		boolean result = dkvs.equals(defKeyValues);
		assertEquals(false, result);
	}
	
}
