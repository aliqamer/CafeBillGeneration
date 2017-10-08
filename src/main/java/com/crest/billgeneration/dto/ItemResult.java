package com.crest.billgeneration.dto;

import com.crest.billgeneration.domain.Beverage;

/**
 * @author Ali
 * @since 08/10/17
 */
public class ItemResult {

    private Beverage beverage;
    private int count;
    private double price;

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemResult)) return false;

        ItemResult that = (ItemResult) o;

        if (count != that.count) return false;
        if (Double.compare(that.price, price) != 0) return false;
        return beverage.equals(that.beverage);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = beverage.hashCode();
        result = 31 * result + count;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
