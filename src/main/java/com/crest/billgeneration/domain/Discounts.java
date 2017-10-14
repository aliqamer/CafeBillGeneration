package com.crest.billgeneration.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Discounts is immutable object which holds a map with discount (Offer) per item
 * @author Ali
 * @since 08/10/17
 */

//This class is optional for user story 2
public final class Discounts {

    private final Map<Beverage, Offer> discountsPerItemMap = new HashMap<>();

    public Discounts(){

        /*Offer offerOnLatte = new Offer(Coffee.LATTE, 2, 25);
        discountsPerItemMap.put(Coffee.LATTE, offerOnLatte);

        Offer offerOnLemonTea = new Offer(Tea.LEMON, 2, 10);
        discountsPerItemMap.put(Tea.LEMON, offerOnLemonTea);

        Offer offerOnSprite = new Offer(ColdDrink.SPRITE, 3, 5);
        discountsPerItemMap.put(ColdDrink.SPRITE, offerOnSprite);*/

    }

    public Map<Beverage, Offer> getDiscountsPerItemMap() {
        return new HashMap<>(discountsPerItemMap);
    }
}
