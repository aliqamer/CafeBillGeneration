package com.crest.billgeneration.dto;

import java.util.List;

/**
 * @author Ali
 * @since 08/10/17
 */
public class BillResponse {

    private List<ItemResult> itemResults;
    private double total;
    private List<Discount> discounts;
    private double finalAmount;

    public List<ItemResult> getItemResults() {
        return itemResults;
    }

    public void setItemResults(List<ItemResult> itemResults) {
        this.itemResults = itemResults;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillResponse)) return false;

        BillResponse that = (BillResponse) o;

        if (Double.compare(that.total, total) != 0) return false;
        if (Double.compare(that.finalAmount, finalAmount) != 0) return false;
        if (!itemResults.equals(that.itemResults)) return false;
        return discounts.equals(that.discounts);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = itemResults.hashCode();
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + discounts.hashCode();
        temp = Double.doubleToLongBits(finalAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
