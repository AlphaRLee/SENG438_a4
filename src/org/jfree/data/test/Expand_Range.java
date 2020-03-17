package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.*;


public class Expand_Range {
	@Test
	public void testNominalInputs() {
		Range range = new Range(-10, 10);
		Range r = Range.expand(range, 0.5, 1);
		
		System.out.println(r.getLowerBound());
		
		assertEquals(-20, r.getLowerBound(), 0.000001);
		assertEquals(30, r.getUpperBound(), 0.000001);
	}
	
	@Test
	public void testWithUpperBoundExpansion() {
		Range testRange = new Range(-1, 1);
		Range expandedRange = Range.expand(testRange, 0.0, 2.0);
		
		assertEquals(-1, expandedRange.getLowerBound(), TestHelpers.EPSILON);
		assertEquals(5, expandedRange.getUpperBound(), TestHelpers.EPSILON);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullInput() {
		Range range = null;
		Range.expand(range, 1.1, 1.1);
	}
}
