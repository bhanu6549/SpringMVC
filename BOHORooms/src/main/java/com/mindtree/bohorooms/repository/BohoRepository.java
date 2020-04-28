package com.mindtree.bohorooms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.bohorooms.entity.BOHO;
@Repository
public interface BohoRepository extends JpaRepository<BOHO, Long> {

	Optional<BOHO> findByBohoName(String bohoName);

}
