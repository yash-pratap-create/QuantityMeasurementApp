package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1,
                                                      double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(double value,
                                                     Length.LengthUnit fromUnit,
                                                     Length.LengthUnit toUnit) {

        if (!Double.isFinite(value) || fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length,
                                                     Length.LengthUnit toUnit) {

        if (length == null || toUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {

        System.out.println(demonstrateLengthConversion(1, Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES));

        System.out.println(demonstrateLengthConversion(2, Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES));

        System.out.println(demonstrateLengthConversion(100, Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES));
    }
}