package com.mindtree.garmentshop.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.garmentshop.entity.Brand;
import com.mindtree.garmentshop.entity.Shop;
import com.mindtree.garmentshop.repository.BrandRepo;
import com.mindtree.garmentshop.repository.ShopRepo;
import com.mindtree.garmentshop.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	BrandRepo brandRepo;
	@Autowired
	ShopRepo shopRepo;

	@Override
	public Object addBrand(Brand brand) {
		brandRepo.save(brand);
		return brand;
	}

	@Override
	public Object addBrandToShop(long brandId, long shopId) {
		Shop shop=shopRepo.findById(shopId).orElse(null);
		//long id=shop.getId();
		Brand brand=brandRepo.findById(brandId).orElse(null);
		brand.setShop(shop);
		brandRepo.save(brand);
		return brand;
	}

	@Override
	public List<Brand> getBrand(long shopId) {
		Shop shop=shopRepo.findById(shopId).get();
		List<Brand> listBrand=shop.getListBrand();
		return listBrand;
				
	}

}
