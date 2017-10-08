package com.crest.billgeneration.dto;

/**
 * @author Ali
 * @since 08/10/17
 */
public class Discount {

    private double discountPercentage;
    private double discountAmount;

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount)) return false;

        Discount discount = (Discount) o;

        if (Double.compare(discount.discountPercentage, discountPercentage) != 0) return false;
        return Double.compare(discount.discountAmount, discountAmount) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(discountPercentage);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discountAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
