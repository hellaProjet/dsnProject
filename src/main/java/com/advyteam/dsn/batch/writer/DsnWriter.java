package com.advyteam.dsn.batch.writer;

import com.advyteam.dsn.dto.DsnFile;
import com.advyteam.dsn.dto.retour.GeneratedDsn;
import com.advyteam.dsn.utils.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dsnWriter")
public class DsnWriter implements ItemWriter<DsnFile>,Constants {

    @Override
    public void write(List<? extends DsnFile> list) throws Exception {

        //TRAITEMENT DU FICHIER A GENERER

        System.out.println("writer starts");
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
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(currRow);
        createStringCell(row, generatedDsn.getPerpai(), 0);
        createStringCell(row, generatedDsn.getSociety(), 1);
        createStringCell(row, generatedDsn.getEstablisment(), 2);




       /* for (DsnFile data : list) {
            System.out.println("result of items are "+data);
            for (int i = 0; i < 300; i++) {
                currRow++;
                Row row = sheet.createRow(currRow);
                if(" S20.G00.05.005".equals(data.getKey())){
                    createStringCell(row, data.getValue(), 0);
                }
                if("S10.G00.00.006".equals(data.getKey())){
                    createStringCell(row, data.getValue(), 1);
                }
                if("S20.G00.05.003".equals(data.getKey())){
                    createStringCell(row, data.getValue(), 2);
                }
            }
        }*/
    }


    private void createStringCell(Row row, String val, int col) {
        Cell cell = row.createCell(col);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(val);
    }

}
