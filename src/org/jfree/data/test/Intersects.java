package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.*;

public class Intersects {
	
	@Test
	public void negRangeBLB()
	{
		Range r = new Range( -5.5, -1.1 );
		assertFalse(r.intersects( -10.1, -6.2 ));
	}
	
	@Test
	public void negToZeroRangeOLB()
	{
		Range r = new Range( -5.4, 0.0 );
		assertFalse( r.intersects( -10.1, -5.4 ));
	}
	
	@Test
	public void negToPosRangeRangeOverlapLB()
	{
		Range r = new Range( -5.2, 5.6 );
		assertTrue( r.intersects( -7.3, 1.2));
	}
	
	@Test
	public void acrossZeroRangeInside()
	{
		Range r = new Range( -5.1, 5.7 );
		assertTrue( r.intersects( -4.9, 5.2 ));
	}
	
	@Test
	public void zeroToPosRangeSurround()
	{
		Range r = new Range( 0, 4.9 );
		assertTrue( r.intersects( -0.4, 5.2 ));
	}
	
	@Test
	public void posRangeOverlapUB()
	{
		Range r = new Range( 0.5, 5.3 );
		assertTrue( r.intersects( 2.3, 6.2 ) );
	}
	
	@Test
	public void negToPosRangeOUB()
	{
		Range r = new Range( -4.9, 3.8 );
		assertFalse( r.intersects( 3.8, 6.8 ));
	}
	
	@Test
	public void negRangeAUB()
	{
		Range r = new Range( -5.2, -1.1 );
		assertFalse(r.intersects( -0.2, 4.0 ));
	}
	
}
