package com.crest.billgeneration.service;

import com.crest.billgeneration.dto.BillResponse;

/**
 * @author Ali
 * @since 08/10/17
 */
public interface DisplayFormatService {

    //it follows SRP & OCP
    void display(BillResponse billResponse);
}
