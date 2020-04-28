package com.mindtree.garmentshop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.garmentshop.entity.Shop;
import com.mindtree.garmentshop.repository.ShopRepo;
import com.mindtree.garmentshop.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	ShopRepo shopRepo;
	@Override
	public Object addShop(Shop shop) {
		shopRepo.save(shop);
		return shop;
	}
}
