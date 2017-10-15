package com.crest.billgeneration.service.impl;

import com.crest.billgeneration.dto.BillResponse;
import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.dto.ItemResult;
import com.crest.billgeneration.domain.BeverageInventoryInitializer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.crest.billgeneration.domain.BeverageInventory.Code.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BillCalculatorImplTest {

    private BillCalculatorImpl billCalculator = new BillCalculatorImpl();

    @Before
    public void setUp() throws Exception {

        BeverageInventoryInitializer.initialize();
    }

    @Test
    public void calculateBill_shouldReturnValidBillResponse() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(LATTE_COFFEE, 1),
        getItemRequest(ICE_TEA, 3), getItemRequest(PEPSI_COLD_DRINK, 2));

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
        return asList(getItemResult("Coffee - Latte",LATTE_COFFEE,1,30),
                    getItemResult("Tea - Ice",ICE_TEA,3,45),
                    getItemResult("Cold Drinks - Pepsi",PEPSI_COLD_DRINK,2,40));
    }

    private List<Discount> getDiscounts() {
        List<Discount> discounts = new ArrayList<>();
        Discount discount = new Discount();
        discount.setDiscountAmount(11.5);
        discount.setDiscountPercentage(10);
        discounts.add(discount);
        return discounts;
    }

    private ItemRequest getItemRequest(String beverage, int quantity) {
        return new ItemRequest(beverage, quantity);
    }

    private ItemResult getItemResult(String name, String code, int count, double price) {

        ItemResult itemResult = new ItemResult();
        itemResult.setBeverage(name);
        itemResult.setCode(code);
        itemResult.setCount(count);
        itemResult.setPrice(price);

        return itemResult;
    }

}