package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(2.0, Length.LengthUnit.FEET)
        );

        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_SameUnit_InchesPlusInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(6.0, Length.LengthUnit.INCHES),
                new Length(6.0, Length.LengthUnit.INCHES)
        );

        assertEquals(new Length(12.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_InchesPlusFeet() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.FEET)
        );

        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );

        assertEquals(new Length(2.0, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES)
        );

        assertEquals(new Length(5.08, Length.LengthUnit.CENTIMETERS), result);
    }

    @Test
    public void testAddition_WithZero() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(0.0, Length.LengthUnit.INCHES)
        );

        assertEquals(new Length(5.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NegativeValues() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET)
        );

        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_Commutativity() {
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        Length result1 = QuantityMeasurementApp.demonstrateLengthAddition(a, b);
        Length result2 = QuantityMeasurementApp.demonstrateLengthAddition(b, a);

        assertEquals(result1.convertTo(Length.LengthUnit.INCHES),
                result2.convertTo(Length.LengthUnit.INCHES));
    }

    @Test
    public void testAddition_NullSecondOperand() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstrateLengthAddition(
                    new Length(1.0, Length.LengthUnit.FEET),
                    null
            );
        });
    }
}