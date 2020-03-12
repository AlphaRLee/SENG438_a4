package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpandToInclude_Range {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}



	@Before
	public void setUp() throws Exception {
		
	}


	/*
	 * Testing if range is null statement
	 * 
	 */
	@Test
	public void testNullCase() 
	{
		double definedVal = 15;
		Range definedRange = null;
		Range testRange = Range.expandToInclude(definedRange, definedVal);
		Range actualRange = new Range(15,15);
		assertEquals(testRange.getLength(),actualRange.getLength(),0.0000001d);
		
	}
	/*
	 * Testing if lower bound is returned correctly
	 * 
	 */
	@Test
	public void lowerBoundCase() 
	{
		double definedVal = 15;
		Range definedRange = new Range(16,16);
		Range testRange = Range.expandToInclude(definedRange, definedVal);
		Range actualRange = new Range(15,16);
		assertEquals(testRange.getLength(),actualRange.getLength(),0.0000001d);
		
	}
	/*
	 * Testing if upper bound is returned correctly
	 * 
	 */	
	@Test
	public void upperBoundCase() 
	{
		double definedVal = 16;
		Range definedRange = new Range(15,15);
		Range testRange = Range.expandToInclude(definedRange, definedVal);
		Range actualRange = new Range(15,16);
		assertEquals(testRange.getLength(),actualRange.getLength(),0.0000001d);
		
	}
	
	/*
	 * Testing if bounds are matching with value
	 * 
	 */	
	@Test
	public void nominalBounds() 
	{
		double definedVal = 15;
		Range definedRange = new Range(15,15);
		Range testRange = Range.expandToInclude(definedRange, definedVal);
		Range actualRange = new Range(15,15);
		assertEquals(testRange.getLength(),actualRange.getLength(),0.0000001d);
		
	}

	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
