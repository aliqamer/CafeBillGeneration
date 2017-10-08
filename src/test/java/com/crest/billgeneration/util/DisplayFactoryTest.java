package com.crest.billgeneration.util;

import com.crest.billgeneration.domain.BillFormat;
import com.crest.billgeneration.service.DisplayFormatService;
import com.crest.billgeneration.service.impl.HtmlFormatServiceImpl;
import com.crest.billgeneration.service.impl.TextFormatServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayFactoryTest {

    @Test
    public void getDisplayFormatter_shouldReturnInstanceOfHtmlFormatter() throws Exception {

        DisplayFormatService displayFormatter = DisplayFactory.getDisplayFormatter(BillFormat.HTML);

        assertTrue(displayFormatter instanceof HtmlFormatServiceImpl);

    }

    @Test
    public void getDisplayFormatter_shouldReturnInstanceOfTextFormatter() throws Exception {

        DisplayFormatService displayFormatter = DisplayFactory.getDisplayFormatter(BillFormat.TEXT);

        assertTrue(displayFormatter instanceof TextFormatServiceImpl);

    }

}