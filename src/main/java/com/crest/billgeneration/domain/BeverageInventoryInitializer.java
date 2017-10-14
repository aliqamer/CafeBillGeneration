package com.crest.billgeneration.domain;

import static com.crest.billgeneration.domain.BeverageInventory.Code.*;

public class BeverageInventoryInitializer {

    public static BeverageInventory inventory = new BeverageInventory();

    public static void initialize(){

        Beverage cold = new ColdCoffee("Cold Coffee", COLD_COFFEE, 15);
        Beverage latte = new LatteCoffee("Latte Coffee", LATTE_COFFEE, 30);
        Beverage mocha = new MochaCoffee("Mocha Coffee", MOCHA_COFFEE, 40);

        Beverage coke = new Coke("Cold Drinks - Coke", COKE_COLD_DRINK, 20);
        Beverage pepsi = new Pepsi("Cold Drinks - Pepsi", PEPSI_COLD_DRINK, 20);
        Beverage sprite = new Sprite("Cold Drinks - Sprite", SPRITE_COLD_DRINK, 15);

        Beverage iceTea = new IceTea("Ice Tea", ICE_TEA, 15);
        Beverage lemonTea = new IceTea("Lemon Tea", LEMON_TEA, 15);
        Beverage masalaTea = new IceTea("Masala Tea", MASALA_TEA, 10);

        inventory.addItem(COLD_COFFEE, cold);
        inventory.addItem(LATTE_COFFEE, latte);
        inventory.addItem(MOCHA_COFFEE, mocha);

        inventory.addItem(COKE_COLD_DRINK, coke);
        inventory.addItem(PEPSI_COLD_DRINK, pepsi);
        inventory.addItem(SPRITE_COLD_DRINK, sprite);

        inventory.addItem(ICE_TEA, iceTea);
        inventory.addItem(LEMON_TEA, lemonTea);
        inventory.addItem(MASALA_TEA, masalaTea);

    }

}
