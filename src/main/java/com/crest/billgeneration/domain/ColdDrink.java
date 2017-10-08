package com.crest.billgeneration.domain;

/**
 * @author Ali
 * @since 08/10/17
 */
public enum ColdDrink implements Beverage {

    COKE("Coke", 20), PEPSI("Pepsi", 20), SPRITE("Sprite", 15);

    private String name;
    private Integer cost;

    ColdDrink(String name, int cost) {
        this.name = "Cold Drinks - " +name;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getCost() {
        return this.cost;
    }
}
