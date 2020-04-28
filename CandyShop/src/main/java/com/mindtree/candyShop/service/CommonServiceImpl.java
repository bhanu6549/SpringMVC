package com.mindtree.candyShop.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.candyShop.entity.Candy;
import com.mindtree.candyShop.entity.Shop;
import com.mindtree.candyShop.exception.AppException;
import com.mindtree.candyShop.repository.CandyRepository;
import com.mindtree.candyShop.repository.ShopRepository;
@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	CandyRepository cr;
	@Autowired
	ShopRepository sr;
	@Override
	public double generateBill(int candyId, int quantity) throws AppException {
		List<Candy> list=cr.findAll();
		for (Candy candy : list) {
			if(candy.getId()==candyId)
			{
				if(candy.getStock()>quantity)
				{
					double cost=candy.getPrice();
					double tax=12*cost/100;
					double deliverycharge=2*cost/100;
					return quantity*(cost+tax+deliverycharge);
				}
				else
				{
					try {
					throw new AppException("no stock available");
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				}
			}
			else
			{
				try
				{
					throw new AppException("No candy id present");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			
		}
		
		return -1;
	}

	@Override
	public List<Candy> findCandy(int shopId) {
		List<Shop> shop=getshop();
		for (Shop shop2 : shop) {
			if(shop2.getId()==shopId)
			{
				 return shop2.getCandies();
			}
				
		}
		return null;
		
	}

	private List<Shop> getshop() {
		return sr.findAll();
		
	}

	@Override
	public List<Candy> countLessThenfive() {
		List<Candy> listcandies=cr.findAll();
		List<Candy> li=new LinkedList<Candy>();
		for (Candy candy : listcandies) {
			if(candy.getStock()>3)
			{
				li.add(candy);
			}
			
		}
		return li;
	}


}
