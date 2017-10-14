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

    private BeverageInventory inventory = BeverageInventoryInitializer.inventory;

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

        double totalAmount = itemResults.stream().mapToDouble(item -> item.getPrice()).sum();

        List<Discount> discounts = new ArrayList<>();

        discountChain.calculateDiscount(totalAmount, discounts);

        double totalDiscountAmount = discounts.stream().mapToDouble(discount -> discount.getDiscountAmount()).sum();

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

        return itemRequests.stream().map(itemRequest -> {

            final Beverage beverage = inventory.getItem(itemRequest.getBeverage());
            ItemResult itemResult = new ItemResult();
            itemResult.setBeverage(itemRequest.getBeverage());
            itemResult.setCount(itemRequest.getQuantity());
            itemResult.setPrice(beverage.getCost() * itemRequest.getQuantity());

            return itemResult;

        }).collect(toList());
    }
}
