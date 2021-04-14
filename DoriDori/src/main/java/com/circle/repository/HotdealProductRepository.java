package com.circle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.circle.domain.proudct.HotdealProduct;
import com.circle.domain.proudct.group.BestSelling;


public interface HotdealProductRepository extends JpaRepository<HotdealProduct,Long> {

	/**
	 * 마감순 조회
	 * */
	@Query("select hp from HotdealProduct hp where hp.expireDate < CURRENT_TIMESTAMP ORDER BY hp.expireDate")
	List<HotdealProduct> findAllOrderByExpiredate();
	
	/**
	 * 최신순 조회
	 * */
	@Query("select hp from HotdealProduct hp where hp.expireDate < CURRENT_TIMESTAMP ORDER BY hp.regDate")
	List<HotdealProduct> findAllOrderByRegdate();
	
	/**
	 * 마감된 상품 조회
	 * */
	@Query("select hp from HotdealProduct hp where hp.expireDate > CURRENT_TIMESTAMP")
	List<HotdealProduct> findAllExpired();
	
	
}
