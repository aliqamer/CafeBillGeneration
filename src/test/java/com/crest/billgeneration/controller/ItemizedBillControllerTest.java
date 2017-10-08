package com.crest.billgeneration.controller;

import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.domain.*;
import com.crest.billgeneration.service.BillCalculator;
import com.crest.billgeneration.service.impl.BillCalculatorImpl;
import com.crest.billgeneration.validate.ItemValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class ItemizedBillControllerTest {

    private ItemizedBillController controller = new ItemizedBillController();

    private ItemValidator itemValidator = new ItemValidator();

    private BillCalculator billCalculator = new BillCalculatorImpl();

    @Before
    public void setUp() throws Exception {

        controller.setItemValidator(itemValidator);
        controller.setBillCalculator(billCalculator);
    }

    @Test
    public void calculateBill_shouldApply10PercentDiscount_whenAmountGreaterThan100() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(Coffee.LATTE, 1),
                getItemRequest(Tea.ICE, 3), getItemRequest(ColdDrink.PEPSI, 2));

        controller.calculateBill(itemRequests, BillFormat.TEXT);

    }

    @Test
    public void calculateBill_shouldApply10PercentDiscount_whenAmountGreaterThan100_HtmlFormat() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(Coffee.LATTE, 1),
                getItemRequest(Tea.ICE, 3), getItemRequest(ColdDrink.PEPSI, 2));

        controller.calculateBill(itemRequests, BillFormat.HTML);

    }

    @Test
    public void calculateBill_shouldApply20PercentDiscount_whenAmountGreaterThan200() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(Coffee.LATTE, 3),
                getItemRequest(Tea.ICE, 3), getItemRequest(ColdDrink.PEPSI, 2),
                getItemRequest(Coffee.COLD, 3), getItemRequest(ColdDrink.SPRITE, 3),
                getItemRequest(Tea.LEMON, 5));

        controller.calculateBill(itemRequests, BillFormat.TEXT);

    }

    @Test
    public void calculateBill_shouldNotApplyDiscount_whenAmountLessThan100() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(Coffee.LATTE, 1),
                getItemRequest(Tea.ICE, 3), getItemRequest(ColdDrink.PEPSI, 1));

        controller.calculateBill(itemRequests, BillFormat.TEXT);

    }

    private ItemRequest getItemRequest(Beverage beverage, int quantity) {
        return new ItemRequest(beverage, quantity);
    }

}