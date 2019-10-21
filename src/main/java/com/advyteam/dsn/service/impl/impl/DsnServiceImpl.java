package com.advyteam.dsn.service.impl.impl;

import com.advyteam.dsn.dto.DsnFile;
import com.advyteam.dsn.service.impl.DsnService;
import org.springframework.stereotype.Component;

/**
 * Created by hboulahia on 20/10/19.
 */
@Component("dsnService")
public class DsnServiceImpl implements DsnService {

  @Override
  public DsnFile generateDsnExcel(DsnFile dsnFileInput) {

    System.out.println("processor  starts");
    DsnFile dsnFileOuput = new DsnFile();

    dsnFileOuput.setKey(dsnFileInput.getKey());
    dsnFileOuput.setValue(dsnFileInput.getValue());

    return dsnFileOuput;
  }
}
