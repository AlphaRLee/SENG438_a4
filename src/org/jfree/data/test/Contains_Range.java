package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Contains_Range {
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
	public void testNominalInRange() {
		assertTrue(range.contains(0));
	}
	
	@Test
	public void testNominalAboveRange() {
		assertFalse(range.contains(100));
	}
	
	@Test
	public void testNominalBelowRange() {
		assertFalse(range.contains(-100));
	}
	
	@Test
	public void testBoundaryAboveUpperBound() {
		assertFalse(range.contains(11));
	}
	
	@Test
	public void testBoundaryAtUpperBound() {
		assertTrue(range.contains(10));
	}
	
	@Test
	public void testBoundaryBelowUpperBound() {
		assertTrue(range.contains(9));
	}

	@Test
	public void testBoundaryAboveLowerBound() {
		assertTrue(range.contains(-9));
	}
	
	@Test
	public void testBoundaryAtLowerBound() {
		assertTrue(range.contains(-10));
	}
	
	@Test
	public void testBoundaryBelowLowerBound() {
		assertFalse(range.contains(-11));
	}
	
	@Test
	public void testUpperBoundaryMaxNumbers() {
		Range r = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
		assertTrue(r.contains(Double.MAX_VALUE));
	}
	
	@Test
	public void testLowerBoundaryMaxNumbers() {
		Range r = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
		assertTrue(r.contains(Double.MIN_VALUE));
	}
}
