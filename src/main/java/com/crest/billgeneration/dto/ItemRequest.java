package com.crest.billgeneration.dto;

/**
 * @author Ali
 * @since 08/10/17
 */
public final class ItemRequest {

    private final String code;
    private final int quantity;

    public ItemRequest(String item, int quantity){
        this.code = item;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }
}
