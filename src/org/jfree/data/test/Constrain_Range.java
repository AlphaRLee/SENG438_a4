package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Constrain_Range {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	// Test for success when value is within range
	@Test
	public void inRange() {
		Range controlBody = new Range(-10, 10);
		assertEquals(2.0, controlBody.constrain(2.0), 0.0000001);
	}
	
	//Test for success when value is on upper boundary
	@Test
	public void correctRangeLarge() {
		Range controlBody = new Range(1, 6);
		double result = controlBody.constrain(6);
		double expected = 6;
		assertEquals(expected, result, 0.0000001d);
		
	}
	//Tests for success when value is on lower boundary
	@Test
	public void correctRangeSmall() {
		Range controlBody = new Range(1, 6);
		double result = controlBody.constrain(1);
		double expected = 1;
		assertEquals(expected, result,0.0000001d);
		
	}
	
	//If value inserted is greater then range
	@Test
	public void largerRange() {
		Range controlBody = new Range(1, 6);
		double result = controlBody.constrain(7);
		double expected = 6;
		assertEquals(expected, result,0.0000001d);
		
	}
	
	//If value inserted is smaller then range
	@Test
	public void smallerRange() {
		Range controlBody = new Range(1, 6);
		double result = controlBody.constrain(0);
		double expected = 1;
		assertEquals(expected, result,0.0000001d);
		
	}
	
	//If the actual range is very large and the value is smaller
	@Test
	public void OutOfBoundRange_smaller() {
		Range controlBody = new Range(-2.125e307, 1.69e308);
		double result = controlBody.constrain(-2.225e307);
		double expected = -2.125e307;
		System.out.println(expected);
		System.out.println(result);
		assertEquals(expected, result,0.0000001d);
		
	}
	//If the actual range is very large and the value is larger
	@Test
	public void OutOfBoundRange_larger() {
		Range controlBody = new Range(-2.125e307, 1.69e308);
		double result = controlBody.constrain(1.79e308);
		double expected = 1.69e308;
		System.out.println(expected);
		System.out.println(result);
		assertEquals(expected, result,0.0000001d);	
	}
	
	@Test
	public void testWithContainedValue() {
		double result = new Range(-1, 1).constrain(2.0);
		
		assertEquals(result, 1.0, TestHelpers.EPSILON);
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
