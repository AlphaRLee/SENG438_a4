package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.*;


public class Expand_Range {
	@Test
	public void testNominalInputs() {
		Range range = new Range(-10, 10);
		Range r = Range.expand(range, 1.1, 1.1);
		
		assertEquals(-11, r.getLowerBound(), 0.000001);
		assertEquals(11, r.getUpperBound(), 0.000001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullInput() {
		Range range = null;
		Range.expand(range, 1.1, 1.1);
	}
}