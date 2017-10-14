package com.crest.billgeneration.service.impl;

import com.crest.billgeneration.dto.BillResponse;
import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemResult;
import com.crest.billgeneration.service.DisplayFormatService;

/**
 * @author Ali
 * @since 08/10/17
 */
import java.util.List;

public class HtmlFormatServiceImpl implements DisplayFormatService {


    @Override
    public String display(BillResponse billResponse) {

        StringBuilder response = new StringBuilder("********************** <html> **********************");

        response.append(NEW_LINE).append(spaceAppender("Item Name",30))
                .append(spaceAppender("Count",10))
                .append(spaceAppender("Price (INR)",15));

        List<ItemResult> itemResults = billResponse.getItemResults();

        itemResults.stream().forEach(item -> response.append(NEW_LINE)
                .append(spaceAppender(item.getBeverage().getName(),30))
                .append(spaceAppender(String.valueOf(item.getCount()),10))
                .append(spaceAppender(String.valueOf(item.getPrice()),15)));

        response.append(NEW_LINE).append(spaceAppender("Total",40)).append(billResponse.getTotal());

        List<Discount> discounts = billResponse.getDiscounts();

        if(!discounts.isEmpty()){

            discounts.stream().forEach(discount -> response.append(NEW_LINE)
                    .append("Discount - ")
                    .append(discount.getDiscountPercentage())
                    .append(spaceAppender("%",25))
                    .append(discount.getDiscountAmount() ));

            response.append(NEW_LINE).append(spaceAppender("Final Amount",40)).append(billResponse.getFinalAmount());

        }

        response.append(NEW_LINE).append("********************** </html> *********************");
        return response.toString();
    }

    private String spaceAppender(String str, int length) {

        int spacesToAppend = length - str.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < spacesToAppend; i++) {
            sb.append(" ");
        }


        return str + sb;
    }
}
