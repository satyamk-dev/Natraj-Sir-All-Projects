package com.nt.service;

import java.util.List;

import com.nt.entity.Politician;

public interface IPoliticianMgmtService {
    public  String savePolitician(Politician politician);
    public  List<Politician>  showAllPoliiticians();
    public   double   showPoliticianAgeById(int id);
}
