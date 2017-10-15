package com.crest.billgeneration.service.impl;

import com.crest.billgeneration.domain.Beverage;
import com.crest.billgeneration.domain.BeverageInventory;
import com.crest.billgeneration.domain.BeverageInventoryInitializer;
import com.crest.billgeneration.dto.BillResponse;
import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.dto.ItemResult;
import com.crest.billgeneration.service.BillCalculator;
import com.crest.billgeneration.util.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Ali
 * @since 08/10/17
 */
public class BillCalculatorImpl implements BillCalculator {

    private BeverageInventory inventory = BeverageInventoryInitializer.getInventory();

    private DiscountChain discountChain = DiscountChainUtil.getChain();

    /**
     * This method takes input as items (name and quantity) and calculate bill by applying discount
     * based on rules defined in discount chains
     * @param itemRequests
     * @return BillResponse
     */
    @Override
    public BillResponse calculateBill(List<ItemRequest> itemRequests) {

        List<ItemResult> itemResults = getItemResults(itemRequests);

        List<Discount> discounts = new ArrayList<>();

        discountChain.calculateDiscount(itemResults, discounts);

        double totalDiscountAmount = discounts.stream().mapToDouble(discount -> discount.getDiscountAmount()).sum();

        double totalAmount = itemResults.stream().mapToDouble(item -> item.getPrice()).sum();

        return getBillResponse(itemResults, totalAmount, discounts, totalDiscountAmount);
    }

    /**
     *
     * @param itemResults
     * @param total
     * @param discounts
     * @param totalDiscountAmount
     * @return
     */
    private BillResponse getBillResponse(List<ItemResult> itemResults, double total, List<Discount> discounts, double totalDiscountAmount) {

        BillResponse billResponse = new BillResponse();
        billResponse.setItemResults(itemResults);
        billResponse.setFinalAmount(total - totalDiscountAmount);
        billResponse.setDiscounts(discounts);
        billResponse.setTotal(total);

        return billResponse;
    }

    /**
     *
     * @param itemRequests
     * @return List<ItemResult>
     */
    private List<ItemResult> getItemResults(List<ItemRequest> itemRequests) {

        return itemRequests.stream().map(itemRequest ->
                getItemResult(itemRequest, inventory.getItem(itemRequest.getCode()))).collect(toList());
    }

    private ItemResult getItemResult(ItemRequest itemRequest, Beverage beverage) {

        ItemResult itemResult = new ItemResult();

        itemResult.setBeverage(beverage.getName());
        itemResult.setPrice(beverage.getCost() * itemRequest.getQuantity());
        itemResult.setCount(itemRequest.getQuantity());
        itemResult.setCode(itemRequest.getCode());

        return itemResult;
    }
}
