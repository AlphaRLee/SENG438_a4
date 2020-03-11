package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Equals_Range {
	Range range;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		range = new Range(-10, 10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNominalExactCopy() {
		Range r = new Range(-10, 10);
		assertTrue(range.equals(r));
	}
	
	@Test
	public void testTargetNotRange() {
		assertFalse(range.equals(new Object()));
	}
	
	@Test
	public void testTargetIsNull() {
		assertFalse(range.equals(null));
	}
	
	@Test
	public void testTargetToRight() {
		Range r = new Range(0, 20);
		assertFalse(range.equals(r));
	}
	
	@Test
	public void testTargetToLeft() {
		Range r = new Range(-20, 0);
		assertFalse(range.equals(r));
	}
	
	@Test
	public void testTargetTooWide() {
		Range r = new Range(-20, 20);
		assertFalse(range.equals(r));
	}
	
	@Test
	public void testTargetTooNarrow() {
		Range r = new Range(-5, 5);
		assertFalse(range.equals(r));
	}

	@Test
	public void testBoundaryTargetRightAboveUpperBound() {
		Range r = new Range(-10, 10.1);
		assertFalse(range.equals(r));
	}
	
	@Test
	public void testBoundaryTargetRightBelowUpperBound() {
		Range r = new Range(-10, 9.9);
		assertFalse(range.equals(r));
	}
	
	@Test
	public void testBoundaryTargetLeftAboveUpperBound() {
		Range r = new Range(-9.9, 10);
		assertFalse(range.equals(r));
	}
	
	@Test
	public void testBoundaryTargetLeftBelowUpperBound() {
		Range r = new Range(-10.1, 10);
		assertFalse(range.equals(r));
	}
}
