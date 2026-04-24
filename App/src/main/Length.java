package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    private double convertFromBase(double baseValue, LengthUnit targetUnit) {
        return baseValue / targetUnit.getConversionFactor();
    }

    public boolean compare(Length that) {
        return Math.abs(this.convertToBaseUnit() - that.convertToBaseUnit()) < 0.0001;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length that = (Length) o;
        return this.compare(that);
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = convertToBaseUnit();
        double result = convertFromBase(base, targetUnit);

        result = Math.round(result * 100.0) / 100.0;

        return new Length(result, targetUnit);
    }

    // ✅ UC6 ADDITION METHOD
    public Length add(Length that) {
        if (that == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        double baseSum = this.convertToBaseUnit() + that.convertToBaseUnit();

        double result = convertFromBase(baseSum, this.unit);

        result = Math.round(result * 100.0) / 100.0;

        return new Length(result, this.unit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}