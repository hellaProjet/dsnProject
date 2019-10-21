package com.advyteam.dsn.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component("dsnStepListener")
public class dsnStepListener implements StepExecutionListener {

  @Override
  public void beforeStep(StepExecution stepExecution) {

  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {
   return null;
  }

}
