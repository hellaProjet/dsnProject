package com.advyteam.dsn.batch.writer;

import com.advyteam.dsn.dto.DsnFile;
import com.advyteam.dsn.service.impl.impl.DsnServiceImpl;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dsnWriter")
public class DsnWriter implements ItemWriter<DsnFile> {

    @Autowired
    private DsnServiceImpl dsnService;

    @Override
    public void write(List<? extends DsnFile> list) throws Exception {

        //TRAITEMENT DU FICHIER A GENERER
        System.out.println("writer starts");
        dsnService.generateDsnFile(list);

    }

}
