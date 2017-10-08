package com.crest.billgeneration.util;

import com.crest.billgeneration.domain.BillFormat;
import com.crest.billgeneration.service.DisplayFormatService;
import com.crest.billgeneration.service.impl.HtmlFormatServiceImpl;
import com.crest.billgeneration.service.impl.TextFormatServiceImpl;

/**
 * @author Ali
 * @since 08/10/17
 */
public class DisplayFactory {

    private static HtmlFormatServiceImpl htmlFormatService = new HtmlFormatServiceImpl();
    private static TextFormatServiceImpl textFormatService = new TextFormatServiceImpl();

    private DisplayFactory(){
    }

    /**
     * This method takes bill format as input and returns formatter instance based on input
     * @param billFormat
     * @return
     */
    public static DisplayFormatService getDisplayFormatter(BillFormat billFormat){

        DisplayFormatService displayFormatService = null;
        switch (billFormat){
            case TEXT:
                displayFormatService = textFormatService;
                break;
            case HTML:
                displayFormatService = htmlFormatService;
                break;
        }
        return displayFormatService;
    }

}
