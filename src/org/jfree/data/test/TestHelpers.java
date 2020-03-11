package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

import org.jmock.Expectations;
import org.jmock.Mockery;

public class TestHelpers {

    public static double EPSILON = 0.000000001d;

    public static Values2D createValues2DMock(
            int numberOfColumns, 
            int numberOfRows, 
            Number cellValue,
            int actualNumberOfColumns,
            int actualNumberOfRows) {
    	Mockery mockingContext = new Mockery();
        Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getRowCount();
                will(returnValue(numberOfRows));

                allowing(values).getColumnCount();
                will(returnValue(numberOfColumns));

                for (int rowIdx = 0; rowIdx < actualNumberOfRows; rowIdx++) {
                    for (int columnIdx = 0; columnIdx < actualNumberOfColumns; columnIdx++) {
                        allowing(values).getValue(rowIdx, columnIdx);
                        will(returnValue(cellValue));

                        allowing(values).getValue(rowIdx, numberOfColumns);
                        will(throwException(new IndexOutOfBoundsException("Invalid Values2D data access.")));

                        allowing(values).getValue(numberOfRows, columnIdx);
                        will(throwException(new IndexOutOfBoundsException("Invalid Values2D data access.")));

                        allowing(values).getValue(rowIdx, -1);
                        will(throwException(new IndexOutOfBoundsException("Invalid Values2D data access.")));

                        allowing(values).getValue(-1, columnIdx);
                        will(throwException(new IndexOutOfBoundsException("Invalid Values2D data access.")));
                    }
                }
            }
        });

        return values;
    }
}
