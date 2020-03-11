package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateNumberArray_DataUtilities {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
	}
	
	//Test a regular array of numbers(4 array cells)
	@Test
	public void safe_array_of_four() 
	{
		Number [] expected = {1,2,3,4};
		double [] manipulate = {1,2,3,4};
		Number [] actual = DataUtilities.createNumberArray(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
		
	}
	//Test a single array value (1 array cell)
	@Test
	public void array_Of_One()
	{
		Number [] expected = {6};
		double [] manipulate = {6};
		Number [] actual = DataUtilities.createNumberArray(manipulate);
		
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}
	
	//Test a empty array (should fail), may require changes done
	@Test(expected = InvalidParameterException.class)
	public void emptyArray() throws InvalidParameterException
	{
		try 
		{
			double [] manipulate = null;
			Number [] actual = DataUtilities.createNumberArray(manipulate);
		}
		
		catch (Exception e)
		{
			//fail("Testing the InvalidParameterException");
		}
		
		//fail("Testing the InvalidParameterException");
	}
	
	//Test an array with many values
	@Test
	public void veryBigArray()
	{
		Number [] expected = {1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4};
		double [] manipulate = {1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4};
		Number [] actual = DataUtilities.createNumberArray(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}
	
	//Test an array with a very big value stored
	@Test
	public void largeValues()
	{
		Number [] expected = {1.79e308,8,2};
		double [] manipulate = {1.79e308,8,2};
		Number [] actual = DataUtilities.createNumberArray(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}
	
	@Test
	//Test an array with a very small value stored
	public void smallValues()
	{
		Number [] expected = {-2.225e307,-8,-2};
		double [] manipulate = {-2.225e307,-8,-2};
		Number [] actual = DataUtilities.createNumberArray(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}

	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}



}
