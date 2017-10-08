package com.crest.billgeneration.service;

import com.crest.billgeneration.dto.BillResponse;
import com.crest.billgeneration.dto.ItemRequest;

import java.util.List;

/**
 * @author Ali
 * @since 08/10/17
 */
public interface BillCalculator {

    BillResponse calculateBill(List<ItemRequest> itemRequests);

}
