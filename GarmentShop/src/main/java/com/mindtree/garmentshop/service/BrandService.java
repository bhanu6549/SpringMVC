package com.mindtree.garmentshop.service;

import java.util.List;

import com.mindtree.garmentshop.entity.Brand;

public interface BrandService {

	Object addBrand(Brand brand);

	Object addBrandToShop(long brandId, long shopId);

	List<Brand> getBrand(long shopId);

}
