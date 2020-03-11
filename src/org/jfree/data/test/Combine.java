package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

import java.lang.Double;

public class Combine {
	
	@Test
	public void nullNull()
	{
		final Range base1 = null;
		final Range base2 = null;
		Range result = Range.combine( base1, base2 );
		assertEquals( result, null );
	}
	
	@Test
	public void validNull()
	{
		final Range base1 = new Range( -1.0, 1.0);
		final Range base2 = null;
		Range result = Range.combine( base1, base2 );
		assertEquals( result, base1 );
	}
	
	@Test
	public void validRanges()
	{
		final Range base1 = new Range( -10.0, -1.2 );
		final Range base2 = new Range( -4.5, 6.5 );
		Range result = Range.combine( base1, base2 );
		assertEquals( result.getLowerBound(), -10.0, 0.00001 );
		assertEquals( result.getUpperBound(), 6.5, 0.00001 );
	}
	
}
