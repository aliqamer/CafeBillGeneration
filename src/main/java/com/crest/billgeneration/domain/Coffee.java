package com.crest.billgeneration.domain;

/**
 * @author Ali
 * @since 08/10/17
 */
public enum Coffee implements Beverage {
    COLD("Cold", 15), LATTE("Latte", 30), MOCHA("Mocha", 40);

    private String name;
    private Integer cost;

    Coffee(String name, int cost) {
        this.name = "Coffee - " + name;
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
