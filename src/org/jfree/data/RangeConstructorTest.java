package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeConstructorTest {

	private Range range; 
	
	@Test (timeout = 1000)
	public void ProperConstruction() {
		range = new Range(1,3);
	}
	@Test(timeout = 1000, expected=IllegalArgumentException.class)
	public void ImproperConstruction() {
		range = new Range(3,1);
	}

}
