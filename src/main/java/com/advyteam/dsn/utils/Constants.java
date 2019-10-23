package com.advyteam.dsn.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;

/**
 * Created by hboulahia on 22/10/19.
 */
@Component("listeConstantes")
public class Constants {

    public final static Workbook workbook = new SXSSFWorkbook(100);;

}
