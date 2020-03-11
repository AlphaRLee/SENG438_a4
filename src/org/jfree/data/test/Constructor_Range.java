package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.*;


public class Constructor_Range {
	/**
	 * Test range with nominal inputs
	 */
	@Test
	public void testNominalInputs() {
		Range range = new Range(-10, 10);
		assertEquals(-10, range.getLowerBound(), 0.00001);
		assertEquals(10, range.getUpperBound(), 0.00001);
	}

	/**
	 * Test range with inverted inputs (i.e. upper bound is less than lower bound)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvertedInputs() {
		Range range = new Range(10, -10);
	}
	
}
