package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesTest_getIndex {
	
	DefaultKeyedValues dkvs;

	@Before
	public void setUp() throws Exception {
		dkvs = new DefaultKeyedValues();
		dkvs.addValue((Comparable<Integer>)1, 25);
		dkvs.addValue((Comparable<Integer>)3, 26);
	}

	@After
	public void tearDown() throws Exception {
		dkvs = null;
	}

	@Test (timeout = 1000)
	public void testUnrecognizedKey() {
		int result = dkvs.getIndex(5);
		assertEquals(-1, result);
	}
	
	@Test (timeout = 1000)
	public void testRecognizedKey() {
		int result = dkvs.getIndex(3);
		assertEquals(1, result);
	}

}
