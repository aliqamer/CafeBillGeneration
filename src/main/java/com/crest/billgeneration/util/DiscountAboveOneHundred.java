package com.crest.billgeneration.util;

import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemResult;

import java.util.List;

/**
 * @author Ali
 * @since 08/10/17
 */
public class DiscountAboveOneHundred implements DiscountChain {

    private DiscountChain nextDiscount;

    @Override
    public void setNextDiscount(DiscountChain nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    /**
     * This method apply discount if total amount is > 100 else does nothing
     * @param itemResults
     * @param discounts
     */
    @Override
    public void calculateDiscount(List<ItemResult> itemResults , List<Discount> discounts) {

        double finalAmount = getRemainingTotalAmount(itemResults, discounts);

        if(finalAmount > 100){

            double discountAboveOneHundred = finalAmount * 0.10;
            discounts.add(getDiscount(discountAboveOneHundred, 10));

        }
        //no discount below 100 so chain stop here
    }
}
