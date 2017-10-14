package com.crest.billgeneration.dto;

/**
 * @author Ali
 * @since 08/10/17
 */
public final class ItemRequest {

    private final String beverage;
    private final int quantity;

    public ItemRequest(String item, int quantity){
        this.beverage = item;
        this.quantity = quantity;
    }

    public String getBeverage() {
        return beverage;
    }

    public int getQuantity() {
        return quantity;
    }
}
