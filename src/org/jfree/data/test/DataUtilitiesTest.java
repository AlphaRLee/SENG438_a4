package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class DataUtilitiesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// ?? 
	}
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void calculateColumnTotalForTwoValues() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values,  0);
		assertEquals(result, 10.0, 0.000000001d);
	}
	
	@After
	public void tearDown() throws Exception {
		// ??
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// ??
	}
}
