package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class createNumberArray2D_DataUtilities extends DataUtilities {

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
		Number [][] expected = { {1,2,3,4},{1,2,3,4} };
		double [][] manipulate = { {1,2,3,4},{1,2,3,4} };
		Number [][] actual = DataUtilities.createNumberArray2D(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
		
	}
	//Test a single array value (1 array cell, other array is empty)
	@Test
	public void array_Of_One()
	{
		Number [][] expected = {{6},{6}};
		double [][] manipulate = {{6},{6}};
		Number [][] actual = DataUtilities.createNumberArray2D(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}
	
	//Test an array where it is empty and null
	@Test(expected = InvalidParameterException.class)
	public void one_empty_Array() throws InvalidParameterException
	{
		try {
			double [][] manipulate = null;
			Number [][] actual = DataUtilities.createNumberArray2D(manipulate);
		}
		catch (Exception e)
		{
			//fail("Testing the InvalidParameterException");
		}
		
	}
	
	//Test a empty array (should fail), may require changes done
	@Test
	public void emptyArray()
	{
		Number [][] expected = {{6,-7,34,1456,77},{}};
		double [][] manipulate = {{6,-7,34,1456,77,56.7},{}};
		Number [][] actual = DataUtilities.createNumberArray2D(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}
	
	//Test an array with many values
	@Test
	public void veryBigArray()
	{
		Number [][] expected = {{1,2,3,4,1,2,3,4,1,2,3,4,1,2,3},{4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4}};
		double [][] manipulate = {{1,2,3,4,1,2,3,4,1,2,3,4,1,2,3},{4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4}};
		Number [][] actual = DataUtilities.createNumberArray2D(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}
	
	//Test an array with a very big value stored
	@Test
	public void largeValues()
	{
		Number [][] expected = {{1.79e308,8,2},{1.79e308,8,2}};
		double [][] manipulate =  {{1.79e308,8,2},{1.79e308,8,2}};
		Number [][] actual = DataUtilities.createNumberArray2D(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}
	
	@Test
	//Test an array with a very small value stored
	public void smallValues()
	{
		Number [][] expected = {{-2.225e307,-8,-2},{-2.225e307,-8,-2}};
		double [][] manipulate = {{-2.225e307,-8,-2},{-2.225e307,-8,-2}};
		Number [][] actual = DataUtilities.createNumberArray2D(manipulate);
		assertArrayEquals("createNumberArray should create the correct value",expected,actual);
	}

	
	
	@After
	public void tearDown() throws Exception {
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
}
