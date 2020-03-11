package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.*;


public class HashCode_Range {
	@Test
	public void testNominalInputs() {
		Range range = new Range(-10, 10);
		int hash = range.hashCode();
		assertEquals(70778880, hash);
	}
	
}
