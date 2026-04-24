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
    public void testFeetInchesComparison() {
        assertEquals(new Length(1, Length.LengthUnit.FEET),
                new Length(12, Length.LengthUnit.INCHES));
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
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                3.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

        assertEquals(new Length(36.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length yards = new Length(2.0, Length.LengthUnit.YARDS);

        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                yards, Length.LengthUnit.INCHES);

        assertEquals(new Length(72.0, Length.LengthUnit.INCHES), result);
    }
}