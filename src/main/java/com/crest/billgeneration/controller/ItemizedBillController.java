package com.crest.billgeneration.controller;

import com.crest.billgeneration.dto.BillResponse;
import com.crest.billgeneration.dto.ItemRequest;
import com.crest.billgeneration.domain.BillFormat;
import com.crest.billgeneration.service.BillCalculator;
import com.crest.billgeneration.service.DisplayFormatService;
import com.crest.billgeneration.service.impl.BillCalculatorImpl;
import com.crest.billgeneration.util.DisplayFactory;
import com.crest.billgeneration.validate.ItemValidator;

import java.util.List;

/**
 * @author Ali
 * @since  08/10/17
 * This class is starting point for bill generation of cafe system
 *
 */
public class ItemizedBillController {

    private ItemValidator itemValidator = new ItemValidator();

    private BillCalculator billCalculator = new BillCalculatorImpl();

    private DisplayFormatService displayFormatService;

    /**
     * This method takes list of items & their quantity & output format as request &
     * display output in given format
     * @param itemRequest
     * @param billFormat
     * @throws Exception
     */
    public void calculateBill(List<ItemRequest> itemRequest, BillFormat billFormat) throws Exception {

        itemValidator.validate(itemRequest);

        BillResponse billResponse = billCalculator.calculateBill(itemRequest);

        displayFormatService = DisplayFactory.getDisplayFormatter(billFormat);

        displayFormatService.display(billResponse);

    }

    public void setItemValidator(ItemValidator itemValidator) {
        this.itemValidator = itemValidator;
    }

    public void setBillCalculator(BillCalculator billCalculator) {
        this.billCalculator = billCalculator;
    }
}
