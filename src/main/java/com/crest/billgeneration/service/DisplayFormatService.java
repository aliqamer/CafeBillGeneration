package com.crest.billgeneration.service;

import com.crest.billgeneration.dto.BillResponse;

/**
 * @author Ali
 * @since 08/10/17
 */
public interface DisplayFormatService {

    String NEW_LINE = "\n";

    //it follows SRP & OCP
    String display(BillResponse billResponse);
}
