package com.circle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.circle.domain.proudct.group.BestSelling;




public interface BestSellingRepository extends JpaRepository<BestSelling,Long> {
	
	/**
	 *	hotdealProductNo로 BestSellilng 상품 검색
	 * */
	@Query("select bs from BestSelling bs where bs.hotdealProduct.hotdealProductId = ?1")
	BestSelling findByhotdealProductNo(Long hotdealProductId);

}
