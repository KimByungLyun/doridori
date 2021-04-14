package com.circle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.circle.domain.proudct.MainCategory;
import com.circle.domain.proudct.Product;





public interface MainCategoryRepository extends JpaRepository<MainCategory,Long> {

	
	
}
