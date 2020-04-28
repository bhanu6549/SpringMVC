package com.mindtree.candyShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.candyShop.entity.Candy;
import com.mindtree.candyShop.exception.AppException;
import com.mindtree.candyShop.service.CommonService;

@RestController
public class HomeController {
	@Autowired
	CommonService cmr;
	@GetMapping("/order/{candyId}/{quantity}")
	public double generateBill(@PathVariable int candyId,@PathVariable int quantity)
	{
		try {
			return cmr.generateBill(candyId,quantity);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	@GetMapping("/find/candybyshopid/{shopId}")
	public List<Candy> findCandiesByshop(@PathVariable int shopId)
	{
		 return cmr.findCandy(shopId);
		
	}
	@GetMapping("/count")
	public  List<Candy> countLessThenFive()
	
	{
		 return cmr.countLessThenfive();
		
		
	}
	

}
