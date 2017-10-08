package com.crest.billgeneration.service.impl;

import com.crest.billgeneration.dto.BillResponse;
import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.dto.ItemResult;
import com.crest.billgeneration.domain.Beverage;
import com.crest.billgeneration.domain.Coffee;
import com.crest.billgeneration.domain.ColdDrink;
import com.crest.billgeneration.domain.Tea;
import com.crest.billgeneration.util.DiscountPerItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BillCalculatorImplTest {

    private BillCalculatorImpl billCalculator = new BillCalculatorImpl();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void calculateBill_shouldReturnValidBillResponse() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(Coffee.LATTE, 1),
        getItemRequest(Tea.ICE, 3), getItemRequest(ColdDrink.PEPSI, 2));

        BillResponse billResponse = billCalculator.calculateBill(itemRequests);

        BillResponse expectedBillResponse = getBillResponse();

        assertEquals(expectedBillResponse, billResponse);
    }

    private BillResponse getBillResponse() {

        BillResponse expectedBillResponse = new BillResponse();
        expectedBillResponse.setItemResults(getItemResults());
        expectedBillResponse.setTotal(115);
        expectedBillResponse.setFinalAmount(103.5);
        expectedBillResponse.setDiscounts(getDiscounts());

        return expectedBillResponse;
    }

    private List<ItemResult> getItemResults() {
        return asList(getItemResult(Coffee.LATTE,1,30),
                    getItemResult(Tea.ICE,3,45),
                    getItemResult(ColdDrink.PEPSI,2,40));
    }

    private List<Discount> getDiscounts() {
        List<Discount> discounts = new ArrayList<>();
        Discount discount = new Discount();
        discount.setDiscountAmount(11.5);
        discount.setDiscountPercentage(10);
        discounts.add(discount);
        return discounts;
    }

    private ItemRequest getItemRequest(Beverage beverage, int quantity) {
        return new ItemRequest(beverage, quantity);
    }

    private ItemResult getItemResult(Beverage beverage, int count, double price) {

        ItemResult itemResult = new ItemResult();
        itemResult.setBeverage(beverage);
        itemResult.setCount(count);
        itemResult.setPrice(price);

        return itemResult;
    }

}