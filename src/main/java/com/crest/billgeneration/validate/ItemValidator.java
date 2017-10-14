package com.crest.billgeneration.validate;

import com.crest.billgeneration.domain.BeverageInventory;
import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.exception.InvalidItemCodeException;
import com.crest.billgeneration.exception.InvalidQuantityException;
import com.crest.billgeneration.util.InventoryInitializer;

import java.util.List;

import static java.util.Objects.isNull;

/**
 * @author Ali
 * @since 08/10/17
 */
public class ItemValidator {

    private BeverageInventory inventory = InventoryInitializer.inventory;

    /**
     * This method valids whether input has invalid quantity like 0 or negative
     * @param itemRequests
     * @throws InvalidQuantityException
     */
    public void validate(List<ItemRequest> itemRequests) throws Exception {

        for (ItemRequest request : itemRequests) {

            if(isNull(inventory.getItem(request.getBeverage()))){

                throw new InvalidItemCodeException("Invalid Item Code provided : "+request.getBeverage());
            }

            if(request.getQuantity() <= 0){

                throw new InvalidQuantityException("Invalid Quantity provided for : "+request.getBeverage());
            }
        }
    }

    public void setInventory(BeverageInventory inventory) {
        this.inventory = inventory;
    }
}
