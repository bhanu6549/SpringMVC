package com.mindtree.candyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.candyShop.entity.Candy;
@Repository
public interface CandyRepository extends JpaRepository<Candy,Integer> {

}
