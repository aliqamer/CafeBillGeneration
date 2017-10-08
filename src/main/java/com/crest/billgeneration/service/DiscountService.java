package com.crest.billgeneration.service;

import com.crest.billgeneration.dto.Discount;
import com.crest.billgeneration.dto.ItemResult;

import java.util.List;

/**
 * @author Ali
 * @since 08/10/17
 */
//This class is optional for user story 2
public interface DiscountService {

    List<Discount> calculateDiscount(List<ItemResult> itemResults);

}
