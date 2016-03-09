package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class Range_getCentralValue_Method {

	private Range range;
	private double delta;
	
	@Before
	public void setUp() throws Exception
	{
		delta = 0.0000000000001d;
	}
	
	/*
	 * Testing getCentralValue returns the proper value for positive bounds
	 */
	@Test (timeout = 1000)
	public void GetCentralValue_Positive_Bounds() {
		range = new Range(1,3);
		assertEquals("Testing getCentralValue returns the proper value for positive bounds",
				2, range.getCentralValue(), delta);
	}
	
	/*
	 * Testing getCentralValue returns the proper value for a negative lower bound and positive upper bound
	 */
	@Test (timeout = 1000)
	public void GetCentralValue_Negative_LowerBound_Positive_UpperBound() {
		range = new Range(-1,1);
		assertEquals("Testing getCentralValue returns the proper value for a negative lower bound and positive upper bound",
				 0, range.getCentralValue(), delta); 
	}

	/*
	 * Testing getCentralValue returns the proper value for negative bounds
	 */
	@Test (timeout = 1000)
	public void GetCentralValue_Negative_Bounds() {
		range = new Range(-3,-1);
		assertEquals("Testing getCentralValue returns the proper value for negative bounds",
				-2, range.getCentralValue(), delta);
	}
	
	/*
	 * Testing getCentralValue returns the proper value for equivalent bounds
	 */
	@Test (timeout = 1000)
	public void GetCentralValue_EquivalentBounds() {
		range = new Range (2,2);
		assertEquals("Testing getCentralValue returns the proper value for equivalent bounds",
				2, range.getCentralValue(), delta);
	}
	
}
