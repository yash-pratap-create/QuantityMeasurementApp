package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1,
                                                      double v2, Length.LengthUnit u2) {
        return new Length(v1, u1).equals(new Length(v2, u2));
    }

    public static Length demonstrateLengthConversion(double value,
                                                     Length.LengthUnit fromUnit,
                                                     Length.LengthUnit toUnit) {

        if (!Double.isFinite(value) || fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        return new Length(value, fromUnit).convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length,
                                                     Length.LengthUnit toUnit) {

        if (length == null || toUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        return length.convertTo(toUnit);
    }

    // ✅ UC6 ADDITION METHOD
    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        return l1.add(l2);
    }

    public static void main(String[] args) {

        System.out.println(demonstrateLengthAddition(
                new Length(1, Length.LengthUnit.FEET),
                new Length(12, Length.LengthUnit.INCHES)
        ));

        System.out.println(demonstrateLengthAddition(
                new Length(1, Length.LengthUnit.YARDS),
                new Length(3, Length.LengthUnit.FEET)
        ));
    }
}