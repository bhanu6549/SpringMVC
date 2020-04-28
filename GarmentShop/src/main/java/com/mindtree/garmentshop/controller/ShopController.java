package com.mindtree.garmentshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.garmentshop.entity.Shop;
import com.mindtree.garmentshop.service.ShopService;

@RestController
public class ShopController {
	@Autowired
	ShopService shopService;
	@PostMapping("/addshop")
	public ResponseEntity<?>addShop(@RequestBody Shop shop)
	{
		return new ResponseEntity<>(this.shopService.addShop(shop),HttpStatus.OK);
	}

}
