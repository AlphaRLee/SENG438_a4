package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class getLength {

	@Test
	public void test()
	{
		Range r = new Range(-5, 5);
		double length = r.getLength();
		assertEquals( length, 10, 0.0000001 );
	}
	
}