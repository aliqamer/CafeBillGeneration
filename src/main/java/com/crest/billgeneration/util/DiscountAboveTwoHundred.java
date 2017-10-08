package com.crest.billgeneration.util;

import com.crest.billgeneration.dto.Discount;

import java.util.List;

/**
 * @author Ali
 * @since 08/10/17
 */
public class DiscountAboveTwoHundred implements DiscountChain {

    private DiscountChain nextDiscount;

    @Override
    public void setNextDiscount(DiscountChain nextDiscount) {
        this.nextDiscount =  nextDiscount;
    }

    /**
     * This method apply discount if total amount is > 200 and calls another discount service in chain
     * If total amount is < 200 it simply delegate the call to another discount service
     * @param total
     * @param discounts
     */
    @Override
    public void calculateDiscount(double total, List<Discount> discounts) {

        if(total > 200){

            double amountAboveTwoHundred = total - 200;
            double discountAboveTwoHundred = amountAboveTwoHundred * 0.20;
            discounts.add(getDiscount(discountAboveTwoHundred, 20));

            double remainingAmount = total - amountAboveTwoHundred;

            nextDiscount.calculateDiscount(remainingAmount, discounts);

        } else{
            nextDiscount.calculateDiscount(total, discounts);
        }
    }
}
