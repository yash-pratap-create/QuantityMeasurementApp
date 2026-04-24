package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        assertTrue(new Length(1, LengthUnit.FEET).equals(new Length(1, LengthUnit.FEET)));
    }

    @Test
    public void testInchesEquality() {
        assertTrue(new Length(12, LengthUnit.INCHES).equals(new Length(12, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(new Length(1, LengthUnit.FEET).equals(new Length(12, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInequality() {
        assertFalse(new Length(1, LengthUnit.FEET).equals(new Length(2, LengthUnit.FEET)));
    }

    @Test
    public void testInchesInequality() {
        assertFalse(new Length(12, LengthUnit.INCHES).equals(new Length(24, LengthUnit.INCHES)));
    }

    @Test
    public void testCrossUnitInequality() {
        assertFalse(new Length(1, LengthUnit.FEET).equals(new Length(10, LengthUnit.INCHES)));
    }

    @Test
    public void testAddFeetAndInches() {
        Length result = new Length(1, LengthUnit.FEET)
                .add(new Length(12, LengthUnit.INCHES));
        assertEquals(new Length(2, LengthUnit.FEET), result);
    }

    @Test
    public void testAddWithTargetUnitInches() {
        Length result = new Length(1, LengthUnit.FEET)
                .add(new Length(12, LengthUnit.INCHES), LengthUnit.INCHES);
        assertEquals(new Length(24, LengthUnit.INCHES), result);
    }

    @Test
    public void testAddWithTargetUnitYards() {
        Length result = new Length(1, LengthUnit.FEET)
                .add(new Length(12, LengthUnit.INCHES), LengthUnit.YARDS);
        assertEquals(new Length(0.67, LengthUnit.YARDS), result);
    }

    @Test
    public void testConvertFeetToInches() {
        Length result = new Length(1, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES);
        assertEquals(new Length(12, LengthUnit.INCHES), result);
    }
}