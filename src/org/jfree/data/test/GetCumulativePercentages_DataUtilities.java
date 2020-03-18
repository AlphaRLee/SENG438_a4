/*
 *  INCOMPLETE
 *  INCOMPLETE
 *  INCOMPLETE
 * 
 */


package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetCumulativePercentages_DataUtilities {

	private DataUtilities testDU;
	private Mockery mockingContext;
	private KeyedValues values;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
		values = mockingContext.mock(KeyedValues.class);
	}
	
	
	/*
	 * 	key		values
	 * 	0		5
	 * 	1		9
	 * 	2		2
	 * Expected output: 0.3125		
	 */
	@Test
	public void testNominalCaseWithValidValuesAndValidInput() {
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(values).getKey(0);
				will(returnValue(0));
				atLeast(1).of(values).getValue(0);
				will(returnValue(new Double(5)));
				
				atLeast(1).of(values).getKey(1);
				will(returnValue(1));
				atLeast(1).of(values).getValue(1);
				will(returnValue(new Double(9)));
				
				atLeast(1).of(values).getKey(2);
				will(returnValue(2));
				atLeast(1).of(values).getValue(2);
				will(returnValue(new Double(2)));
			}
		});
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		Number result = results.getValue(0);
		Number expected = 0.3125;
		assertEquals(expected, result);
	
		
	}	

	// Test keys out of order of index
	
	/**
	 * Test behaviour for divide-by-zero issues
	 */
	@Test
	public void testBoundaryCaseWithZeroValues() {
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(2));
				
				atLeast(1).of(values).getKey(0);
				will(returnValue(0));
				atLeast(1).of(values).getValue(0);
				will(returnValue(0));
				
				atLeast(1).of(values).getKey(1);
				will(returnValue(1));
				atLeast(1).of(values).getValue(1);
				will(returnValue(0));
			}
		});
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		assertEquals(Double.NaN, results.getValue(0));
		assertEquals(Double.NaN, results.getValue(1));
	}
	
	/**
	 * Test behavior for empty keyedValues object
	 */
	@Test
	public void testBoundaryCaseWithEmptyValues() {
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(0));
				
				never(values).getValue(0);
			}
		});
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		assertEquals(0, results.getItemCount());
	}
	
	/**
	 * Test behavior for keyedValues object with a null value
	 */
	@Test
	public void testBoundaryCaseWithNullValue() {
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(values).getKey(0);
				will(returnValue(0));
				atLeast(1).of(values).getValue(0);
				will(returnValue(1.0));
				
				atLeast(1).of(values).getKey(1);
				will(returnValue(1));
				atLeast(1).of(values).getValue(1);
				will(returnValue(null));
				
				atLeast(1).of(values).getKey(2);
				will(returnValue(2));
				atLeast(1).of(values).getValue(2);
				will(returnValue(1.0));
			}
		});
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		assertEquals(0.5, results.getValue(0).doubleValue(), 0.0000001);
	}
	
	/**
	 * Test behaviour for one entry in keyedValues object
	 */
	@Test
	public void testNominalCaseWithOneValue() {
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(1));
				
				atLeast(1).of(values).getKey(0);
				will(returnValue(0));
				atLeast(1).of(values).getValue(0);
				will(returnValue(1));
			}
		});
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		assertEquals(1.0, results.getValue(0));
	}
	
	/**
	 * Test that the ordering of the keys has no impact on the values
	 */
	@Test
	public void testNominalCaseWithIndependentKeys() {
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(values).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(values).getKey(0);
				will(returnValue(2));
				atLeast(1).of(values).getValue(0);
				will(returnValue(5));
				
				atLeast(1).of(values).getKey(1);
				will(returnValue(1));
				atLeast(1).of(values).getValue(1);
				will(returnValue(9));
				
				atLeast(1).of(values).getKey(2);
				will(returnValue(0));
				atLeast(1).of(values).getValue(2);
				will(returnValue(2));
			}
		});
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		assertEquals(0.3125, results.getValue(0));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testWithNullReference() {
		KeyedValues results = DataUtilities.getCumulativePercentages(null);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
