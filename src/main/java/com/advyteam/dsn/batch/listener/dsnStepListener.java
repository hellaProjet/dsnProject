package com.advyteam.dsn.batch.listener;
import com.advyteam.dsn.dto.retour.GeneratedDsn;
import com.advyteam.dsn.utils.Constants;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Component("dsnStepListener")
public class dsnStepListener implements StepExecutionListener {

  @Autowired
  Constants constants;

  String outputFilename;
  int currRow = 0;

  private static final String[] HEADERS = { "PERPAI", "Société", "Etablissement" };
  private CellStyle dataCellStyle;

  @Override
  public void beforeStep(StepExecution stepExecution) {
    String dateTime = DateFormatUtils.format(Calendar.getInstance(),
            "yyyyMMdd_HHmmss");
    outputFilename = "GeneratedDsn" + "_" + dateTime + ".xlsx";

    Sheet sheet = constants.workbook.createSheet("Etablissement");
    sheet.createFreezePane(0, 3, 0, 3);
    sheet.setDefaultColumnWidth(20);

    addTitleToSheet(sheet);
    currRow++;
    addHeaders(sheet);
    initDataStyle();

  }

  private void addTitleToSheet(Sheet sheet) {

    Workbook wb = sheet.getWorkbook();

    CellStyle style = wb.createCellStyle();
    Font font = wb.createFont();

    font.setFontHeightInPoints((short) 14);
    font.setFontName("Arial");
    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setFont(font);

    Row row = sheet.createRow(currRow);
    row.setHeightInPoints(16);

    String currDate = DateFormatUtils.format(Calendar.getInstance(),
            DateFormatUtils.ISO_DATETIME_FORMAT.getPattern());

    Cell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
    cell.setCellValue("DSN of " + currDate);
    cell.setCellStyle(style);

    CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
    sheet.addMergedRegion(range);
    currRow++;

  }


  private void addHeaders(Sheet sheet) {

    Workbook wb = sheet.getWorkbook();

    CellStyle style = wb.createCellStyle();
    Font font = wb.createFont();

    font.setFontHeightInPoints((short) 10);
    font.setFontName("Arial");
    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setFont(font);

    Row row = sheet.createRow(2);
    int col = 0;

    for (String header : HEADERS) {
      Cell cell = row.createCell(col);
      cell.setCellValue(header);
      cell.setCellStyle(style);
      col++;
    }
    currRow++;
  }

  private void initDataStyle() {
    dataCellStyle = constants.workbook.createCellStyle();
    Font font = constants.workbook.createFont();

    font.setFontHeightInPoints((short) 10);
    font.setFontName("Arial");
    dataCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
    dataCellStyle.setFont(font);
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {
    try {
      closeExcel();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;

  }

  // fin du traitement de la création du fichier excel
  public void closeExcel() throws IOException {
    FileOutputStream fos = null;
    fos = new FileOutputStream(outputFilename);
    constants.workbook.write(fos);
    fos.close();
  }


}
