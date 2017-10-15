package com.crest.billgeneration.domain;

/**
 * Offer is immutable object used to add discount(Offer) per item
 * @author Ali
 * @since 08/10/17
 */

//This class is optional for user story 2
public final class Offer {

    private final String beverage;
    private final int count;
    private final double discountPercentage;

    public Offer(String beverage, int count, double discountPercentage) {
        this.beverage = beverage;
        this.count = count;
        this.discountPercentage = discountPercentage;
    }

    public String getBeverage() {
        return beverage;
    }

    public int getCount() {
        return count;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

}
