package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

import java.lang.Double;

public class Shift {
	
	@Test
	public void posRangePosDelta()
	{
		final Range base = new Range( 1.2, 7.4 );
		double delta = 2.5;
		Range result = Range.shift( base, delta, true );
		assertEquals( Double.compare( base.getLowerBound() + delta, result.getLowerBound() ), 0 );
		assertEquals( Double.compare( base.getUpperBound() + delta, result.getUpperBound() ), 0 );
	}
	
	@Test
	public void negToPosRangeZeroDelta()
	{
		final Range base = new Range( -1.2, 7.4 );
		double delta = 3;
		Range result = Range.shift( base, delta, true );
		assertEquals( Double.compare( base.getLowerBound() + delta, result.getLowerBound() ), 0 );
		assertEquals( Double.compare( base.getUpperBound() + delta, result.getUpperBound() ), 0 );
	}
	
	@Test
	public void negRangeNegDelta()
	{
		final Range base = new Range( -11.2, -7.4 );
		double delta = 0.0d;
		Range result = Range.shift( base, delta, true );
		assertEquals( Double.compare( base.getLowerBound() + delta, result.getLowerBound() ), 0 );
		assertEquals( Double.compare( base.getUpperBound() + delta, result.getUpperBound() ), 0 );
	}
	
	@Test
	public void posRangePosDeltaFalse()
	{
		final Range base = new Range( 1.2, 7.4 );
		double delta = 2.5;
		Range result = Range.shift( base, delta, false );
		assertEquals( Double.compare( base.getLowerBound() + delta, result.getLowerBound() ), 0 );
		assertEquals( Double.compare( base.getUpperBound() + delta, result.getUpperBound() ), 0 );
	}
	
	@Test
	public void negToPosRangeZeroDeltaFalse()
	{
		final Range base = new Range( -1.2, 7.4 );
		double delta = 3;
		Range result = Range.shift( base, delta, false );
		assert( Double.compare( base.getLowerBound(), result.getLowerBound() ) != 0 );
		assert( Double.compare( base.getUpperBound(), result.getUpperBound() ) != 0 );
	}
	
	@Test
	public void negRangeNegDeltaFalse()
	{
		final Range base = new Range( -11.2, 0.0 );
		double delta = -13.2;
		Range result = Range.shift( base, delta, false );
		assertEquals( Double.compare( base.getLowerBound() + delta, result.getLowerBound() ), 0 );
		assertEquals( Double.compare( base.getUpperBound() + delta, result.getUpperBound() ), 0 );
	}
	
	/*
	@Test
	public void posRangePosDelta()
	{
		Mockery mockingContext = new Mockery();
		final Range base = mockingContext.mock(Range.class);
		
		mockingContext.checking(new Expectations() {
			{
				one( base ).getLowerBound();
				will( returnValue( 1.2 ) );
				one( base ).getUpperBound();
				will( returnValue( 7.5 ) );
			}
		});
		
		double delta = 2.4 + 1.2;
		Range result = Range.shift( base, delta );
		assertEquals( result.getLowerBound(), base.getLowerBound() + delta );
		assertEquals( result.getUpperBound(), base.getUpperBound() + delta );
	}
	*/
	
}
