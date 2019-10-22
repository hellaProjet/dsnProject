package com.advyteam.dsn.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * Created by hboulahia on 22/10/19.
 */
public interface Constants {

    final static Workbook workbook = new SXSSFWorkbook(100);;

}
