package com.advyteam.dsn.batch.reader;

import com.advyteam.dsn.dto.DsnFile;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component("dsnreaderDsn")
public class DsnReader implements ItemReader< FlatFileItemReader<DsnFile>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DsnReader.class);

    @Override
    public FlatFileItemReader<DsnFile> read(){

        LOGGER.info("*** PREPARATION DE LA LECTURE DU DOCUMENT ***");
        System.out.println("reader starts");

        //Create reader instance
        FlatFileItemReader<DsnFile> reader = new FlatFileItemReader<DsnFile>();

        //Set input file location
        //on peut le passer en paramétre
        reader.setResource(new FileSystemResource("input/inputcsv.csv"));

        //Configure how each line will be parsed and mapped to different values
        reader.setLineMapper(new DefaultLineMapper<DsnFile>() {
            {
                //3 columns in each row
                setLineTokenizer(new DelimitedLineTokenizer(",") {
                    {
                        setNames(new String[] { "key", "value" });
                    }
                });
                //Set values in Employee class
                setFieldSetMapper(new BeanWrapperFieldSetMapper<DsnFile>() {
                    {
                        setTargetType(DsnFile.class);
                    }
                });
            }
        });

        LOGGER.info("*** FIN DU TRAITEMENT DU FICHIER  ***",reader);
        System.out.println("reader ends "+reader);

        return reader;
    }
}
