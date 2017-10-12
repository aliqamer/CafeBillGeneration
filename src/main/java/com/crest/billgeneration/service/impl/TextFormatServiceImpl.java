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
    public void display(BillResponse billResponse) {

        System.out.println("***************** TEXT Format *****************");

        System.out.println(String.format("%-25s","Item Name") + String.format("%-10s","Count")
                + String.format("%-15s","Price (INR)"));

        List<ItemResult> itemResults = billResponse.getItemResults();

        itemResults.stream().forEach(item -> System.out.println(String.format("%-25s",item.getBeverage().getName())+
                String.format("%-10s",item.getCount())+String.format("%-15s",item.getPrice())));

        System.out.println(String.format("%-35s","Total")+billResponse.getTotal());

        List<Discount> discounts = billResponse.getDiscounts();

        if(!discounts.isEmpty()){

            discounts.stream().forEach(discount -> System.out.println(String.format("%-35s","Discount - "+
                    discount.getDiscountPercentage()+"%")+discount.getDiscountAmount() ));

            System.out.println(String.format("%-35s","Final Amount")+billResponse.getFinalAmount());

        }

    }
}
