package com.circle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.circle.domain.proudct.Product;
import com.circle.domain.proudct.SubCategory;





public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {

	
	
}
