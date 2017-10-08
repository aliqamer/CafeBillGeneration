package com.crest.billgeneration.util;

import com.crest.billgeneration.domain.Beverage;
import com.crest.billgeneration.domain.Discounts;
import com.crest.billgeneration.domain.Offer;
import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemResult;
import com.crest.billgeneration.service.DiscountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ali
 * @since 08/10/17
 */

//This class is optional for user story 2
public class DiscountPerItem implements DiscountService {

    private Discounts discountsOnItem = new Discounts();

    @Override
    public List<Discount> calculateDiscount(List<ItemResult> itemResults) {

        Map<Beverage, Offer> discountsPerItemMap = discountsOnItem.getDiscountsPerItemMap();

        List<Discount> discounts = new ArrayList<>();

        itemResults.stream().forEach(item -> {

            if (discountsPerItemMap.containsKey(item.getBeverage())) {

                //calculate discount for each item
                Offer offer = discountsPerItemMap.get(item.getBeverage());
                if (item.getCount() >= offer.getCount()) {

                    double discountAmount = item.getPrice() * (offer.getDiscountPercentage() / 100);

                    Discount discount = new Discount();
                    discount.setDiscountAmount(discountAmount);
                    discount.setDiscountPercentage(offer.getDiscountPercentage());

                    discounts.add(discount);
                }
            }
        });

        return discounts;

    }

}
