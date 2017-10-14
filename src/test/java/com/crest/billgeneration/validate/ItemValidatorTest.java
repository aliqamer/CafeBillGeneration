package com.crest.billgeneration.validate;

import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.exception.InvalidItemCodeException;
import com.crest.billgeneration.exception.InvalidQuantityException;
import com.crest.billgeneration.util.InventoryInitializer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.crest.billgeneration.domain.BeverageInventory.Code.ICE_TEA;
import static com.crest.billgeneration.domain.BeverageInventory.Code.LATTE_COFFEE;
import static java.util.Arrays.asList;

public class ItemValidatorTest {

    private ItemValidator itemValidator = new ItemValidator();

    @Before
    public void setUp() throws Exception {

        InventoryInitializer.initialize();
    }

    @Test(expected = InvalidItemCodeException.class)
    public void validateItems_shouldThrowException_WhenInvalidItemCodeIsGiven() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest("ANY_CODE", 1),
                getItemRequest(ICE_TEA, 3));

        itemValidator.validate(itemRequests);

    }

    @Test(expected = InvalidQuantityException.class)
    public void validateItems_shouldThrowException_WhenInvalidQuantityIsGiven() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(LATTE_COFFEE, -1),
                getItemRequest(ICE_TEA, 3));

        itemValidator.validate(itemRequests);

    }

    @Test
    public void validateItems_shouldNotThrowException_WhenValidQuantityAndItemCodeIsGiven() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(LATTE_COFFEE, 1),
                getItemRequest(ICE_TEA, 3));

        itemValidator.validate(itemRequests);

    }

    private ItemRequest getItemRequest(String itemCode, int quantity ) {
        return new ItemRequest(itemCode, quantity);
    }

}