package com.crest.billgeneration.domain;

/**
 * @author Ali
 * @since 08/10/17
 */
public abstract class Coffee implements Beverage {

    private final String name;
    private final String code;
    private final double cost;

    public Coffee(String name, String code, double cost){
        this.name = name;
        this.code = code;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public double getCost() {
        return cost;
    }

}
