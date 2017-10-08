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

        System.out.println("Item Name\t\tCount\tPrice (INR)");

        List<ItemResult> itemResults = billResponse.getItemResults();

        itemResults.stream().forEach(item -> System.out.println(item.getBeverage().getName()+"\t\t"
        +item.getCount()+"\t"+item.getPrice()));

        System.out.println("Total\t\t"+billResponse.getTotal());

        List<Discount> discounts = billResponse.getDiscounts();

        if(!discounts.isEmpty()){

            discounts.stream().forEach(discount -> System.out.println("Discount - "+
                    discount.getDiscountPercentage()+"%\t\t"+discount.getDiscountAmount() ));

            System.out.println("Final Amount\t\t"+billResponse.getFinalAmount());

        }

    }
}
