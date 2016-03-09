package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RangeHashCodeTest {
	private Range range1; 
	private Range range2;
	
	@Test
	public void SameRangesTest() {
		range1 = new Range(5,10);
		range2 = new Range(5,10); 
		int hashCode1 = range1.hashCode(); 
		int hashCode2 = range2.hashCode(); 
		assertEquals(hashCode1, hashCode2);
	}
	@Test
	public void DifferentRangesTest() {
		range1 = new Range(5,10);
		range2 = new Range(1,11); 
		int hashCode1 = range1.hashCode(); 
		int hashCode2 = range2.hashCode(); 
		assertNotSame(hashCode1, hashCode2);
		
	}

}
