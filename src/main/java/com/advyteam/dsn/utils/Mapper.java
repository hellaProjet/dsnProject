package com.advyteam.dsn.utils;

import com.advyteam.dsn.dto.DsnFile;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class Mapper implements FieldSetMapper<DsnFile> {


  @Override
  public DsnFile mapFieldSet(FieldSet fieldSet)  {

    DsnFile report = new DsnFile();
    report.setKey(fieldSet.readString(0));
    report.setValue(fieldSet.readString(1));


    return report;

  }

}