package com.circle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.circle.domain.proudct.StoreLikeList;






public interface StoreLikeListRepository extends JpaRepository<StoreLikeList,Long> {
	
	@Query("select sl from StoreLikeList sl where sl.storeLikeListId = ?2 and sl.member.memberId =  ?1")
	StoreLikeList findByMemberIdAndHotdealProductId(Long memberId, Long hotdealProductId);

}
