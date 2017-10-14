package com.crest.billgeneration.service.impl;

import com.crest.billgeneration.dto.BillResponse;
import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemResult;
import com.crest.billgeneration.service.DisplayFormatService;

import java.util.List;

/**
 * @author Ali
 * @since 08/10/17
 */
public class TextFormatServiceImpl implements DisplayFormatService {

    @Override
    public String display(BillResponse billResponse) {

        StringBuilder response = new StringBuilder("***************** TEXT Format *****************");

        response.append(NEW_LINE).append(String.format("%-25s","Item Name")).append(String.format("%-10s","Count"))
                .append(String.format("%-15s","Price (INR)"));

        List<ItemResult> itemResults = billResponse.getItemResults();

        itemResults.stream().forEach(item -> response.append(NEW_LINE).
                append(String.format("%-25s",item.getBeverage().getName())).
                append(String.format("%-10s",item.getCount())).
                append(String.format("%-15s",item.getPrice())));

        response.append(NEW_LINE).append(String.format("%-35s","Total")).append(billResponse.getTotal());

        List<Discount> discounts = billResponse.getDiscounts();

        if(!discounts.isEmpty()){

            discounts.stream().forEach(discount -> response.append(NEW_LINE).
                    append("Discount - ").
                    append(discount.getDiscountPercentage()).append(String.format("%-20s","%")).
                    append(discount.getDiscountAmount()));

            response.append(NEW_LINE).append(String.format("%-35s","Final Amount")).append(billResponse.getFinalAmount());

        }

        return response.toString();

    }
}
