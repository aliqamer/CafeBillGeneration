package com.crest.billgeneration.domain;

/**
 * @author Ali
 * @since 08/10/17
 */
public enum Tea implements Beverage {

    LEMON("Lemon", 15), ICE("Ice", 15), MASALA("Masala", 10);

    private String name;
    private Integer cost;

    Tea(String name, int cost) {
        this.name = "Tea - " + name;
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
