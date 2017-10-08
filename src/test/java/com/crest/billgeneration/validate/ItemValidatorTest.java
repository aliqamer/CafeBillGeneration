package com.crest.billgeneration.validate;

import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.domain.Beverage;
import com.crest.billgeneration.domain.Coffee;
import com.crest.billgeneration.domain.Tea;
import com.crest.billgeneration.exception.InvalidQuantityException;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class ItemValidatorTest {

    private ItemValidator itemValidator = new ItemValidator();

    @Test(expected = InvalidQuantityException.class)
    public void validateItems_shouldThrowException_WhenInvalidQuantityIsGiven() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(Coffee.LATTE, -1),getItemRequest(Tea.ICE, 3));

        itemValidator.validate(itemRequests);

    }

    @Test
    public void validateItems_shouldNotThrowException_WhenValidQuantityIsGiven() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(Coffee.LATTE, 1),getItemRequest(Tea.ICE, 3));

        itemValidator.validate(itemRequests);

    }

    private ItemRequest getItemRequest(Beverage beverage, int quantity ) {
        return new ItemRequest(beverage, quantity);
    }

}