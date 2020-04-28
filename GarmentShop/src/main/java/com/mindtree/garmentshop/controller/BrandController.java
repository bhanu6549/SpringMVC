package com.mindtree.garmentshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.garmentshop.entity.Brand;
import com.mindtree.garmentshop.service.BrandService;

@RestController
public class BrandController {
	@Autowired
	BrandService brandService;

	@PostMapping("/addbrand")
	public ResponseEntity<?> AddBrand(@RequestBody Brand brand) {
		return new ResponseEntity<>(this.brandService.addBrand(brand), HttpStatus.OK);

	}

	@PostMapping("/addbrandtoshop/{brandId}/{shopId}")
	public ResponseEntity<?> addBrandToShop(@PathVariable long brandId, @PathVariable long shopId) {
		return new ResponseEntity<>(this.brandService.addBrandToShop(brandId, shopId), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getbrandbyshop/{shopId}")
	public ResponseEntity<?> getBrand(@PathVariable long shopId) {
		return new ResponseEntity<>(this.brandService.getBrand(shopId), HttpStatus.OK);
	}
}
