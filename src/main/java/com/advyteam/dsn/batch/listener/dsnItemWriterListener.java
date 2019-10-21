package com.advyteam.dsn.batch.listener;

import com.advyteam.dsn.dto.DsnFile;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dsnItemWriterListener")
public class dsnItemWriterListener implements ItemWriteListener<DsnFile> {

  @Override
  public void beforeWrite(List<? extends DsnFile> items) {
    //before write
  }

  @Override
  public void afterWrite(List<? extends DsnFile> items) {

  }

  @Override
  public void onWriteError(Exception exception, List<? extends DsnFile> items) {
    //gestion des erreurs
  }

}
