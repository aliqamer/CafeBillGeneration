package com.crest.billgeneration.util;

import com.crest.billgeneration.dto.Discount;

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
     * @param total
     * @param discounts
     */
    @Override
    public void calculateDiscount(double total, List<Discount> discounts) {

        if(total > 100){

            double discountAboveOneHundred = total * 0.10;
            discounts.add(getDiscount(discountAboveOneHundred, 10));

        }
        //no discount below 100 so chain stop here
    }
}
