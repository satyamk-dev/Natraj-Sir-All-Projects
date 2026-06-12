//ICompanyMgmtService.java
package com.nt.service;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;

public interface ICompanyMgmtService {
    public  String   saveProductAndOffers(Product prod,Offers offrs);
}
