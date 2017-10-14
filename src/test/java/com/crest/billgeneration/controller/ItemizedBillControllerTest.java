package com.crest.billgeneration.controller;

import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.domain.*;
import com.crest.billgeneration.service.BillCalculator;
import com.crest.billgeneration.service.impl.BillCalculatorImpl;
import com.crest.billgeneration.domain.BeverageInventoryInitializer;
import com.crest.billgeneration.validate.ItemValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.crest.billgeneration.domain.BeverageInventory.Code.*;
import static java.util.Arrays.asList;

public class ItemizedBillControllerTest {

    private ItemizedBillController controller = new ItemizedBillController();

    private ItemValidator itemValidator = new ItemValidator();

    private BillCalculator billCalculator = new BillCalculatorImpl();

    @Before
    public void setUp() throws Exception {

        BeverageInventoryInitializer.initialize();
        controller.setItemValidator(itemValidator);
        controller.setBillCalculator(billCalculator);
    }

    @Test
    public void calculateBill_shouldApply10PercentDiscount_whenAmountGreaterThan100() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(LATTE_COFFEE, 1),
                getItemRequest(ICE_TEA, 3), getItemRequest(PEPSI_COLD_DRINK, 2));

        controller.calculateBill(itemRequests, BillFormat.TEXT);

    }

    @Test
    public void calculateBill_shouldApply10PercentDiscount_whenAmountGreaterThan100_HtmlFormat() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(LATTE_COFFEE, 1),
                getItemRequest(ICE_TEA, 3), getItemRequest(PEPSI_COLD_DRINK, 2));

        controller.calculateBill(itemRequests, BillFormat.HTML);

    }

    @Test
    public void calculateBill_shouldApply20PercentDiscount_whenAmountGreaterThan200() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(LATTE_COFFEE, 3),
                getItemRequest(ICE_TEA, 3), getItemRequest(PEPSI_COLD_DRINK, 2),
                getItemRequest(COLD_COFFEE, 3), getItemRequest(SPRITE_COLD_DRINK, 3),
                getItemRequest(LEMON_TEA, 5));

        controller.calculateBill(itemRequests, BillFormat.TEXT);

    }

    @Test
    public void calculateBill_shouldNotApplyDiscount_whenAmountLessThan100() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(LATTE_COFFEE, 1),
                getItemRequest(ICE_TEA, 3), getItemRequest(PEPSI_COLD_DRINK, 1));

        controller.calculateBill(itemRequests, BillFormat.TEXT);

    }

    private ItemRequest getItemRequest(String beverage, int quantity) {
        return new ItemRequest(beverage, quantity);
    }

}