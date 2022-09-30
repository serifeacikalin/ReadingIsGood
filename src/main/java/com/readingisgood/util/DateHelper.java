package com.readingisgood.util;

import com.readingisgood.constant.Constant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DateHelper {

    private static final DateTimeFormatter LOCAL_DATE_FORMAT_YYMM = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT_YYMM).withResolverStyle(ResolverStyle.STRICT);

    private DateHelper(){

    }

    public static String toYYMM(LocalDate localDate){
        return localDate.format(LOCAL_DATE_FORMAT_YYMM);
    }
}
