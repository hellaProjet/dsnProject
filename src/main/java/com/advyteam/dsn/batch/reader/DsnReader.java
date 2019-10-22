package com.advyteam.dsn.batch.reader;

import com.advyteam.dsn.dto.DsnFile;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DsnReader  {

    private static final Logger LOGGER = LoggerFactory.getLogger(DsnReader.class);

    @Bean(name="dsnreaderDsn")
    public FlatFileItemReader < DsnFile > csvDsnReader() {
        FlatFileItemReader<DsnFile> reader = new FlatFileItemReader<DsnFile>();
        reader.setResource(new ClassPathResource("input/inputcsv.csv"));
        reader.setLineMapper(new DefaultLineMapper<DsnFile>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{
                            "key",
                            "value"
                        });
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<DsnFile>() {
                    {
                        setTargetType(DsnFile.class);
                    }
                });
            }
        });
        return reader;
    }
}
