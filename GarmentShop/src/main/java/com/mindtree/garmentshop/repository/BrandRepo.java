package com.mindtree.garmentshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.garmentshop.entity.Brand;
@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {

}
