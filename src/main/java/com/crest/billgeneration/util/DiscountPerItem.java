package com.crest.billgeneration.util;

import com.crest.billgeneration.domain.BeverageInventory;
import com.crest.billgeneration.domain.BeverageInventoryInitializer;
import com.crest.billgeneration.domain.Offer;
import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemResult;

import java.util.List;

import static java.util.Objects.nonNull;

/**
 * @author Ali
 * @since 08/10/17
 */

//This class is optional for user story 2
public class DiscountPerItem implements DiscountChain {

    private BeverageInventory inventory = BeverageInventoryInitializer.getInventory();

    private DiscountChain nextDiscount;

    @Override
    public void setNextDiscount(DiscountChain nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public void calculateDiscount(List<ItemResult> itemResults, List<Discount> discounts) {

        itemResults.stream().forEach(item -> {

            if (nonNull(inventory.getDiscount(item.getCode()))) {

                //calculate discount for each item
                Offer offer = inventory.getDiscount(item.getCode());
                if (item.getCount() >= offer.getCount()) {

                    double discountAmount = item.getPrice() * (offer.getDiscountPercentage() / 100);

                    Discount discount = new Discount();
                    discount.setDiscountAmount(discountAmount);
                    discount.setDiscountPercentage(offer.getDiscountPercentage());

                    discounts.add(discount);
                }
            }
        });

        nextDiscount.calculateDiscount(itemResults, discounts);

    }

}
