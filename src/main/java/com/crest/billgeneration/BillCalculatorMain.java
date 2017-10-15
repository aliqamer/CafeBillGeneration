package com.crest.billgeneration;

import com.crest.billgeneration.controller.ItemizedBillController;
import com.crest.billgeneration.domain.BillFormat;
import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.domain.BeverageInventoryInitializer;

import java.util.List;

import static com.crest.billgeneration.domain.BeverageInventory.Code.*;
import static java.util.Arrays.asList;

public class BillCalculatorMain {

    private ItemizedBillController controller = new ItemizedBillController();

    public static void main(String args[]) throws Exception {

        BillCalculatorMain billCalculatorMain = new BillCalculatorMain();

        BeverageInventoryInitializer.initialize();
        billCalculatorMain.calculator();
    }

    private void calculator() throws Exception {

        List<ItemRequest> itemRequests = asList(getItemRequest(LATTE_COFFEE, 1),
                getItemRequest(ICE_TEA, 3), getItemRequest(PEPSI_COLD_DRINK, 2));

        controller.calculateBill(itemRequests, BillFormat.HTML);
    }

    private ItemRequest getItemRequest(String code, int quantity) {
        return new ItemRequest(code, quantity);
    }

}
