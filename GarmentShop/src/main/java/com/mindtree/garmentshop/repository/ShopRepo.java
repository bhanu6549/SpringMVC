package com.mindtree.garmentshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.garmentshop.entity.Shop;
@Repository
public interface ShopRepo extends JpaRepository<Shop, Long>{

}
