package com.mindtree.mobilestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.mobilestore.entity.Mobile;
@Repository
public interface MobileRepo extends JpaRepository<Mobile, Long> {

}
