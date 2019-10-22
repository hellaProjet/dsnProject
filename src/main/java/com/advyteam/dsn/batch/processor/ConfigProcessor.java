package com.advyteam.dsn.batch.processor;

import com.advyteam.dsn.dto.DsnFile;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;


public class ConfigProcessor {

  @Bean(name = "processor")
  ItemProcessor<DsnFile, DsnFile> dsnProcessor() {
    return new DsnProcessor();
  }


}
