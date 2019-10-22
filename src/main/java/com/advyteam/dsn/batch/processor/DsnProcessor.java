package com.advyteam.dsn.batch.processor;

import com.advyteam.dsn.batch.reader.DsnReader;
import com.advyteam.dsn.dto.DsnFile;
import com.advyteam.dsn.service.impl.impl.DsnServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class DsnProcessor implements ItemProcessor<DsnFile, DsnFile> {

    @Autowired
    private DsnServiceImpl dsnService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DsnReader.class);


    public DsnFile process(final DsnFile dsnFileInput) throws Exception {


        System.out.println("processor starts "+dsnFileInput);
        DsnFile dsnFileOuput = dsnService.generateDsnExcel(dsnFileInput);

        return dsnFileOuput;
    }

}
