package com.crest.billgeneration.dto;

import com.crest.billgeneration.domain.Beverage;

/**
 * @author Ali
 * @since 08/10/17
 */
public final class ItemRequest {

    private final Beverage beverage;
    private final int quantity;

    public ItemRequest(Beverage beverage, int quantity){
        this.beverage = beverage;
        this.quantity = quantity;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public int getQuantity() {
        return quantity;
    }
}
