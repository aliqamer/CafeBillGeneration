package com.crest.billgeneration.domain;

import java.util.HashMap;
import java.util.Map;

public class BeverageInventory {

    private final Map<String,Beverage> beveragesMap = new HashMap<>();

    private final Map<String,Offer> discountMap = new HashMap<>();

    public void addItem(String code, Beverage beverage){
        beveragesMap.put(code, beverage);
    }

    public void removeItem(String code){
        beveragesMap.remove(code);
    }

    public Beverage getItem(String code){
        return beveragesMap.get(code);
    }

    public void addDiscount(String code, Offer offer){
        discountMap.put(code, offer);
    }

    public void removeDiscount(String code){
        discountMap.remove(code);
    }

    public Offer getDiscount(String code){
        return discountMap.get(code);
    }

    public static class Code {

        public static final String COLD_COFFEE = "COLD_COFFEE";
        public static final String LATTE_COFFEE = "LATTE_COFFEE";
        public static final String MOCHA_COFFEE = "MOCHA_COFFEE";

        public static final String COKE_COLD_DRINK = "COKE_COLD_DRINK";
        public static final String PEPSI_COLD_DRINK = "PEPSI_COLD_DRINK";
        public static final String SPRITE_COLD_DRINK = "SPRITE_COLD_DRINK";

        public static final String ICE_TEA = "ICE_TEA";
        public static final String LEMON_TEA = "LEMON_TEA";
        public static final String MASALA_TEA = "MASALA_TEA";

    }
}
