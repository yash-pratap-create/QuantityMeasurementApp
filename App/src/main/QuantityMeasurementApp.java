package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Equality method
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    // Comparison method
    public static boolean demonstrateLengthComparison(double value1, Length.LengthUnit unit1,
                                                      double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        boolean result = l1.equals(l2);

        System.out.println("Comparing: " + value1 + " " + unit1 +
                " and " + value2 + " " + unit2 + " → " + result);

        return result;
    }

    public static void main(String[] args) {

        // Feet ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        // Yards ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        // CM ↔ Inches
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS,
                39.3701, Length.LengthUnit.INCHES);

        // Feet ↔ Yards
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.YARDS);

        // CM ↔ Feet
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);
    }
}