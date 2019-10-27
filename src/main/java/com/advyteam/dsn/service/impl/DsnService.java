package com.advyteam.dsn.service.impl;

import com.advyteam.dsn.dto.DsnFile;

import java.util.List;

/**
 * Created by hboulahia on 20/10/19.
 */
public interface DsnService {

  DsnFile enregistrerDsnInformation(DsnFile dsnFileInput);

  void generateDsnFile(List<? extends DsnFile> list);
}
