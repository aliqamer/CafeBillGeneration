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
    public void display(BillResponse billResponse) {

        System.out.println("<html>");
        String column1 = "Item Name";
        String column2 = "Count";
        String column3 = "Price (INR)";

        System.out.println(spaceAppender(column1,35)+ spaceAppender(column2,10)+ spaceAppender(column3,15));

        List<ItemResult> itemResults = billResponse.getItemResults();

        itemResults.stream().forEach(item -> System.out.println(spaceAppender(item.getBeverage().getName(),35)+
                spaceAppender(String.valueOf(item.getCount()),10)+ spaceAppender(String.valueOf(item.getPrice()),15)));

        System.out.println(spaceAppender("Total",45)+billResponse.getTotal());

        List<Discount> discounts = billResponse.getDiscounts();

        if(!discounts.isEmpty()){

            discounts.stream().forEach(discount -> System.out.println(spaceAppender("Discount - "+
                    discount.getDiscountPercentage()+"%",45)+discount.getDiscountAmount() ));

            System.out.println(spaceAppender("Final Amount",45)+billResponse.getFinalAmount());

        }

        System.out.println("</html>");
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
