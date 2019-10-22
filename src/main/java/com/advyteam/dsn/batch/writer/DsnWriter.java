package com.advyteam.dsn.batch.writer;

import com.advyteam.dsn.dto.DsnFile;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dsnWriter")
public class DsnWriter implements ItemWriter<DsnFile> {

    @Override
    public void write(List<? extends DsnFile> list) throws Exception {

        System.out.println("writer starts");

        for (DsnFile item : list) {
            System.out.println("result of items are "+item);
        }
    }
}
