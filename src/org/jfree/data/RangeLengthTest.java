package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeLengthTest {

	private Range range; 
	private double positiveInfinity = Double.POSITIVE_INFINITY;
	private double negativeInfinity = (double) Double.NEGATIVE_INFINITY; 
	
	@Test (timeout = 1000)
	public void NegativeInfinityLowerAndPositiveInfinityUpperBounds() {
		range = new Range(negativeInfinity, positiveInfinity);
		double actualLength = range.getLength();
		double expectedLength = positiveInfinity;
		assertEquals("Testing negative infinity lower bound and positive infinity upper bound",expectedLength, actualLength, 0);
		
	}
	@Test (timeout = 1000)
	public void InfinityUpperBounds() {
		range = new Range(0, positiveInfinity);
		double actualLength = range.getLength();
		double expectedLength = positiveInfinity;
		assertEquals("Testing zero lower bound and positive infinity upper bound",expectedLength, actualLength, 0);
		
	}
	@Test (timeout = 1000)
	public void InfinityLowerBounds() {
		range = new Range(negativeInfinity, 0);
		double actualLength = range.getLength();
		double expectedLength = positiveInfinity; 
		assertEquals("Testing negative infinity lower bound and zero upper bound",expectedLength, actualLength, 0);
		
	}
	@Test (timeout = 1000)
	public void PositiveInfinityBounds() {
		range = new Range(positiveInfinity, positiveInfinity);
		double actualLength = range.getLength(); 
		double expectedLength = Double.NaN; 
		assertEquals("Testing positive infinity lower and upper bounds", expectedLength, actualLength, 0);
	}
	@Test (timeout = 1000)
	public void EqualLowerUpperBounds() {
		range = new Range(1,1);
		double actualLength = range.getLength();
		double expectedLength = 0; 
		assertEquals("Testing equal lower and upper bounds",expectedLength, actualLength, 0);
		
	}
	
	@Test (timeout = 1000)
	public void NegativeBounds() {
		range = new Range(-5,-3); 
		double actualLength = range.getLength();
		double expectedLength = 2;
		assertEquals("Testing negative lower and upper bounds",expectedLength, actualLength, 0);
		
	}
	
	@Test (timeout = 1000)
	public void PositiveBounds() { 
		range = new Range(3,10); 
		double actualLength = range.getLength();
		double expectedLength = 7; 
		assertEquals("Testing positive lower and upper bounds",expectedLength, actualLength, 0);
		
	}
	
	@Test (timeout = 1000)
	public void NegativeLowerPositiveUpper() {
		range = new Range(-2,5);
		double actualLength = range.getLength();
		double expectedLength = 7; 
		assertEquals("Testing equal lower and upper bounds", expectedLength, actualLength, 0);
		
	}
	
	@Test (timeout = 1000)
	public void DecimalValues() {
		range = new Range(2.34247, 4.234782); 
		double actualLength = range.getLength();
		double expectedLength = 1.892312; 
		assertEquals("Testing equal lower and upper bounds",expectedLength, actualLength, 0);
		
	}

}
