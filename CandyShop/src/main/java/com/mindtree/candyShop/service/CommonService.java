package com.mindtree.candyShop.service;

import java.util.List;

import com.mindtree.candyShop.entity.Candy;
import com.mindtree.candyShop.exception.AppException;

public interface CommonService {

	double generateBill(int candyId, int quantity) throws AppException;

	List<Candy> findCandy(int shopId);

	List<Candy> countLessThenfive();

}
