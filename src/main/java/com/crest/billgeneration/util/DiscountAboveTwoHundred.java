package com.crest.billgeneration.util;

import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemResult;

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
     * @param itemResults
     * @param discounts
     */
    @Override
    public void calculateDiscount(List<ItemResult> itemResults, List<Discount> discounts) {

        double totalAmount = getRemainingTotalAmount(itemResults, discounts);

        if(totalAmount > 200){

            double amountAboveTwoHundred = totalAmount - 200;
            double discountAboveTwoHundred = amountAboveTwoHundred * 0.20;
            discounts.add(getDiscount(discountAboveTwoHundred, 20));

            nextDiscount.calculateDiscount(itemResults, discounts);

        } else{
            nextDiscount.calculateDiscount(itemResults, discounts);
        }
    }
}
