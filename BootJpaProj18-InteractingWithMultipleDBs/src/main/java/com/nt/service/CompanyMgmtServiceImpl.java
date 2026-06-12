package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.repository.offers.IOffersRepository;
import com.nt.repository.prod.IProductRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyMgmtServiceImpl implements ICompanyMgmtService {
	@Autowired
	private   IProductRepository  prodRepo;
	@Autowired
	private   IOffersRepository  offersRepo;

	@Override
	@Transactional
	public String saveProductAndOffers(Product prod, Offers offrs) {
		//save Product
		int idVal1=prodRepo.save(prod).getPid();
		int idVal2=offersRepo.save(offrs).getOfferId();
	
		return "Product , Offers are saved with id values "+idVal1+"..."+idVal2;
	}

}
