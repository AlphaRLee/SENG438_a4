package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

public class CalculateRowTotal_DataUtilities {

    // testNominalCaseWithValidValuesAndValidIndex
    // Test for valid Values2D object and non boundary index value.
    @Test
    public void testNominalCaseWithValidValuesAndValidIndex() {
        // Arrange
        Values2D values = TestHelpers.createValues2DMock(3, 3, 1.0, 3, 3);
        
        // Act
        double rowOneTotal = DataUtilities.calculateRowTotal(values, 1);

        // Assert
        double epsilon = TestHelpers.EPSILON;
        assertEquals(3.0, rowOneTotal, epsilon);
    }

    // testBoundaryCaseWithValidValuesAndValidIndex
    // Test for valid Values2D object and boundary index value.
    @Test
    public void testBoundaryCaseWithValidValuesAndValidIndex() {
        // Arrange
        Values2D values = TestHelpers.createValues2DMock(3, 3, 1.0, 3, 3);

        // Act
        double rowTwoTotal = DataUtilities.calculateRowTotal(values, 2);

        // Assert
        double epsilon = TestHelpers.EPSILON;
        assertEquals(3.0, rowTwoTotal, epsilon);
    }
    
    // testNominalCaseWithInvalidValuesAndValidIndex
    // Test for valid Values2D object (i.e., non-null) that contains null references. Non
    // boundary index value is used as per the weak-equivalence class test plan.
    @Test
    public void testNominalCaseWithInvalidValuesAndValidIndex() {
        // Arrange
        Values2D values = TestHelpers.createValues2DMock(3, 3, null, 3, 3);

        // Act
        double rowOneTotal = DataUtilities.calculateRowTotal(values, 1);

        // Arrange
        double epsilon = TestHelpers.EPSILON;
        assertEquals(0.0, rowOneTotal, epsilon);
    }

    // testBoundaryCaseWithValidValuesAndInvalidIndex
    // Test for valid Values2D object (i.e., non-null) with invalid index value.
    @Test(expected = IndexOutOfBoundsException.class)
    public void testBoundaryCaseWithValidValuesAndInvalidIndex() {
        // Arrange
        Values2D values = TestHelpers.createValues2DMock(3, 3, 1.0, 3, 3);

        // Act
        double rowThreeTotal = DataUtilities.calculateRowTotal(values, 3);
    }


    // testLowerBoundaryCaseWithValidValuesAndInvalidIndex
    // Test for valid Values2D object (i.e., non-null) with invalid index value on the lower
    // portion of the boundary.
    @Test(expected = IndexOutOfBoundsException.class) 
    public void testLowerBoundaryCaseWithValidValuesAndInvalidIndex() {
        // Arrange
        Values2D values = TestHelpers.createValues2DMock(3, 3, 1.0, 3, 3);

        // Act
        double rowNegativeOneTotal = DataUtilities.calculateRowTotal(values, -1);
    }

    // testWithNullReference
    // Test for invalid (i.e., null) Values2D object. 
    @Test(expected = NullPointerException.class)
    public void testWithNullReference() {
        // Arrange
        Values2D values = null;

        // Act
        double rowZeroTotal = DataUtilities.calculateRowTotal(values, 0);
    }
}
