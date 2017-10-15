package com.crest.billgeneration.util;

import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemResult;

import java.util.List;

/**
 * This interface is meant for defining chain of responsibility for calculating discounts
 * @author Ali
 * @since 08/10/17
 */
public interface DiscountChain {

    void setNextDiscount(DiscountChain request);

    void calculateDiscount(List<ItemResult> itemResults, List<Discount> discounts);

    /**
     * This is common method for all subclasses
     * @param discountAmount
     * @param discountPercentage
     * @return Discount
     */
    default Discount getDiscount(double discountAmount, double discountPercentage) {

        Discount discount = new Discount();
        discount.setDiscountPercentage(discountPercentage);
        discount.setDiscountAmount(discountAmount);

        return discount;
    }

    default double getRemainingTotalAmount(List<ItemResult> itemResults, List<Discount> discounts) {
        return getTotalAmount(itemResults) - getTotalDiscountAmount(discounts);
    }

    default double getTotalDiscountAmount(List<Discount> discounts) {
        return discounts.stream().mapToDouble(discount -> discount.getDiscountAmount()).sum();
    }

    default double getTotalAmount(List<ItemResult> itemResults) {
        return itemResults.stream().mapToDouble(item -> item.getPrice()).sum();
    }
}
