package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void addFeetAndInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void addFeetAndInchesWithTargetUnitFeet() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.FEET
        );

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.INCHES
        );

        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void addFeetAndInchesWithTargetUnitYards() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS
        );

        assertEquals(new Length(0.67, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void addNegativeValuesWithTargetUnit() {
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET),
                Length.LengthUnit.INCHES
        );

        assertEquals(new Length(36.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void addWithNullTargetUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstrateLengthAddition(
                    new Length(1.0, Length.LengthUnit.FEET),
                    new Length(12.0, Length.LengthUnit.INCHES),
                    null
            );
        });
    }
}