package com.crest.billgeneration.domain;

import static com.crest.billgeneration.domain.BeverageInventory.Code.*;

public class BeverageInventoryInitializer {

    private static BeverageInventory inventory = new BeverageInventory();

    public static BeverageInventory getInventory(){
        return inventory;
    }

    public static void initialize(){

        Beverage cold = new ColdCoffee("Coffee - Cold", COLD_COFFEE, 15);
        Beverage latte = new LatteCoffee("Coffee - Latte", LATTE_COFFEE, 30);
        Beverage mocha = new MochaCoffee("Coffee - Mocha", MOCHA_COFFEE, 40);

        Beverage coke = new Coke("Cold Drinks - Coke", COKE_COLD_DRINK, 20);
        Beverage pepsi = new Pepsi("Cold Drinks - Pepsi", PEPSI_COLD_DRINK, 20);
        Beverage sprite = new Sprite("Cold Drinks - Sprite", SPRITE_COLD_DRINK, 15);

        Beverage iceTea = new IceTea("Tea - Ice", ICE_TEA, 15);
        Beverage lemonTea = new IceTea("Tea - Lemon", LEMON_TEA, 15);
        Beverage masalaTea = new IceTea("Tea - Masala", MASALA_TEA, 10);

        inventory.addItem(COLD_COFFEE, cold);
        inventory.addItem(LATTE_COFFEE, latte);
        inventory.addItem(MOCHA_COFFEE, mocha);

        inventory.addItem(COKE_COLD_DRINK, coke);
        inventory.addItem(PEPSI_COLD_DRINK, pepsi);
        inventory.addItem(SPRITE_COLD_DRINK, sprite);

        inventory.addItem(ICE_TEA, iceTea);
        inventory.addItem(LEMON_TEA, lemonTea);
        inventory.addItem(MASALA_TEA, masalaTea);

        Offer offerOnLatteCoffee = new Offer(LATTE_COFFEE, 2, 25);
        Offer offerOnLemonTea = new Offer(LEMON_TEA, 2, 25);
        Offer offerOnSprite = new Offer(SPRITE_COLD_DRINK, 2, 25);

        inventory.addDiscount(LATTE_COFFEE, offerOnLatteCoffee);
        inventory.addDiscount(LEMON_TEA, offerOnLemonTea);
        inventory.addDiscount(SPRITE_COLD_DRINK, offerOnSprite);

    }

}
