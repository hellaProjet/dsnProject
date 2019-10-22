package com.advyteam.dsn.batch.listener;

import com.advyteam.dsn.dto.DsnFile;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component("dsnreaderListener")
public class CustomItemReaderListener implements ItemReadListener<DsnFile> {

  @Override
  public void beforeRead() {
    System.out.println("ItemReadListener - beforeRead");
  }

  @Override
  public void afterRead(DsnFile item) {
    System.out.println("ItemReadListener - afterRead");
  }

  @Override
  public void onReadError(Exception ex) {
    System.out.println("ItemReadListener - onReadError");
  }

}
