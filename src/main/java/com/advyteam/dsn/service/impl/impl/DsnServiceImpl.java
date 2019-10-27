package com.advyteam.dsn.service.impl.impl;

import com.advyteam.dsn.dto.DsnFile;
import com.advyteam.dsn.dto.retour.GeneratedDsn;
import com.advyteam.dsn.service.impl.DsnService;
import com.advyteam.dsn.utils.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hboulahia on 20/10/19.
 */
@Component("dsnService")
public class DsnServiceImpl implements DsnService {

  @Autowired
  Constants constants;



  @Override
  public DsnFile enregistrerDsnInformation(DsnFile dsnFileInput) {

    System.out.println("processor  starts");
    DsnFile dsnFileOuput = new DsnFile();

    dsnFileOuput.setKey(dsnFileInput.getKey());
    dsnFileOuput.setValue(dsnFileInput.getValue());

    // enregistrer les données dans la base mongo

    return dsnFileOuput;
  }


  @Override
  public void generateDsnFile(List<? extends DsnFile> list){
    GeneratedDsn generatedDsn = new GeneratedDsn();

    int currRow = 4;

    for (DsnFile item : list) {
      generatedDsn.setPerpai("201906");
      if("S10.G00.00.001".equals(item.getKey())){
        generatedDsn.setSociety(item.getValue());
      }
      if("S10.G00.00.002".equals(item.getKey())){
        generatedDsn.setEstablisment(item.getValue());
      }
      System.out.println("result of items are "+item);
    }
    Sheet sheet = constants.workbook.getSheetAt(0);
    Row row = sheet.createRow(currRow);
    createStringCell(row, generatedDsn.getPerpai(), 0);
    createStringCell(row, generatedDsn.getSociety(), 1);
    createStringCell(row, generatedDsn.getEstablisment(), 2);

  }


  private void createStringCell(Row row, String val, int col) {
    Cell cell = row.createCell(col);
    cell.setCellType(Cell.CELL_TYPE_STRING);
    cell.setCellValue(val);
  }
}
