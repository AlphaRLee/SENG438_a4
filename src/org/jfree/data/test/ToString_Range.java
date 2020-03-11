package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ToString_Range {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
	}


	/*
	 * General test for rangeVal.toString
	 */
	@Test
	public void test() 
	{
		Range rangeVal = new Range(12,12);
		String actual = rangeVal.toString();
		String expected = "Range[12.0,12.0]";
		assertEquals(expected, actual);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
