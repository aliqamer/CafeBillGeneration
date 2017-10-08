package com.crest.billgeneration;

import com.crest.billgeneration.controller.ItemizedBillController;
import com.crest.billgeneration.domain.*;
import com.crest.billgeneration.dto.ItemRequest;

import java.util.List;

import static java.util.Arrays.asList;

public class BillCalculatorMain {

    private ItemizedBillController controller = new ItemizedBillController();

    public static void main(String args[]) throws Exception {

        BillCalculatorMain billCalculatorMain = new BillCalculatorMain();
        billCalculatorMain.calculator();
    }

    private void calculator() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(Coffee.LATTE, 1),
                getItemRequest(Tea.ICE, 3), getItemRequest(ColdDrink.PEPSI, 2));

        controller.calculateBill(itemRequests, BillFormat.HTML);

        //for text format use below call
        //controller.calculateBill(itemRequests, BillFormat.TEXT);
    }

    private ItemRequest getItemRequest(Beverage beverage, int quantity) {
        return new ItemRequest(beverage, quantity);
    }

}
