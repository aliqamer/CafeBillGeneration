package com.crest.billgeneration.util;

/**
 * @author Ali
 * @since 08/10/17
 */
public class DiscountChainUtil {

    /**
     * This method create chain of responsibility for applying different discounts
     *
     * @return DiscountChain
     */
    public static DiscountChain getChain(){

        DiscountChain discountAboveOneHundred = new DiscountAboveOneHundred();
        DiscountChain discountAboveTwoHundred = new DiscountAboveTwoHundred();
        DiscountChain discountPerItem = new DiscountPerItem();

        discountAboveTwoHundred.setNextDiscount(discountAboveOneHundred);
        discountPerItem.setNextDiscount(discountAboveTwoHundred);

        return discountPerItem;
    }
}
