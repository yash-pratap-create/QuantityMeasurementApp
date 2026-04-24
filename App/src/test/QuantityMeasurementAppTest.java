package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        assertEquals(new Length(2, Length.LengthUnit.FEET),
                new Length(2, Length.LengthUnit.FEET));
    }

    @Test
    public void testInchesEquality() {
        assertEquals(new Length(12, Length.LengthUnit.INCHES),
                new Length(12, Length.LengthUnit.INCHES));
    }

    @Test
    public void testFeetInchesComparison() {
        assertEquals(new Length(1, Length.LengthUnit.FEET),
                new Length(12, Length.LengthUnit.INCHES));
    }

    @Test
    public void testFeetInequality() {
        assertNotEquals(new Length(2, Length.LengthUnit.FEET),
                new Length(3, Length.LengthUnit.FEET));
    }

    @Test
    public void testInchesInequality() {
        assertNotEquals(new Length(12, Length.LengthUnit.INCHES),
                new Length(10, Length.LengthUnit.INCHES));
    }

    @Test
    public void testCrossUnitInequality() {
        assertNotEquals(new Length(1, Length.LengthUnit.FEET),
                new Length(10, Length.LengthUnit.INCHES));
    }

    @Test
    public void testMultipleFeetComparison() {
        assertEquals(new Length(3, Length.LengthUnit.FEET),
                new Length(36, Length.LengthUnit.INCHES));
    }

    @Test
    public void yardEquals36Inches() {
        assertEquals(new Length(1, Length.LengthUnit.YARDS),
                new Length(36, Length.LengthUnit.INCHES));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        assertEquals(new Length(100, Length.LengthUnit.CENTIMETERS),
                new Length(39.3701, Length.LengthUnit.INCHES));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        assertEquals(new Length(3, Length.LengthUnit.FEET),
                new Length(1, Length.LengthUnit.YARDS));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        assertEquals(new Length(30.48, Length.LengthUnit.CENTIMETERS),
                new Length(1, Length.LengthUnit.FEET));
    }

    @Test
    public void yardNotEqualToInches() {
        assertNotEquals(new Length(1, Length.LengthUnit.YARDS),
                new Length(35, Length.LengthUnit.INCHES));
    }

    @Test
    public void referenceEqualitySameObject() {
        Length l = new Length(1, Length.LengthUnit.FEET);
        assertEquals(l, l);
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length l = new Length(1, Length.LengthUnit.FEET);
        assertNotEquals(l, null);
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length a = new Length(1, Length.LengthUnit.YARDS);
        Length b = new Length(3, Length.LengthUnit.FEET);
        Length c = new Length(36, Length.LengthUnit.INCHES);

        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c);
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        assertNotEquals(new Length(1, Length.LengthUnit.YARDS),
                new Length(2, Length.LengthUnit.YARDS));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        Length yard = new Length(1, Length.LengthUnit.YARDS);
        Length feet = new Length(3, Length.LengthUnit.FEET);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(yard, feet));
    }
}