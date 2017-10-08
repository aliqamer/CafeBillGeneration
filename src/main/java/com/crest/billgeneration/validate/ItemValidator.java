package com.crest.billgeneration.validate;

import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.exception.InvalidQuantityException;

import java.util.List;

/**
 * @author Ali
 * @since 08/10/17
 */
public class ItemValidator {

    /**
     * This method valids whether input has invalid quantity like 0 or negative
     * @param itemRequests
     * @throws InvalidQuantityException
     */
    public void validate(List<ItemRequest> itemRequests) throws InvalidQuantityException {

        for (ItemRequest item : itemRequests) {

            if(item.getQuantity() <= 0){

                throw new InvalidQuantityException("Invalid Quantity provided for : "+item.getBeverage());
            }
        }
    }


}
