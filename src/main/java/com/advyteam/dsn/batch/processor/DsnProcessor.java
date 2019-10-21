package com.advyteam.dsn.batch.processor;

import com.advyteam.dsn.dto.DsnFile;
import com.advyteam.dsn.service.impl.impl.DsnServiceImpl;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dsnProcessor")
public class DsnProcessor implements ItemProcessor<DsnFile, DsnFile> {

    @Autowired
    private DsnServiceImpl dsnService;

    @Override
    public DsnFile process(DsnFile dsnFileInput) {

        System.out.println("pro starts");
        DsnFile dsnFileOuput = dsnService.generateDsnExcel(dsnFileInput);

        return dsnFileOuput;
    }
}
