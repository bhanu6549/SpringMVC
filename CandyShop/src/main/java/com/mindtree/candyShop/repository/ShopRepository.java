package com.mindtree.candyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.candyShop.entity.Shop;
@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {

}
