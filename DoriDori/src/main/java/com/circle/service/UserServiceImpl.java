package com.circle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circle.domain.proudct.HotdealProduct;
import com.circle.domain.proudct.StoreLikeList;
import com.circle.domain.user.Members;
import com.circle.repository.HotdealProductRepository;
import com.circle.repository.MembersRepository;
import com.circle.repository.StoreLikeListRepository;

import lombok.RequiredArgsConstructor;



@Service
public class UserServiceImpl {

	@Autowired
	MembersRepository membersRepo;
	
	//member
	/**
	 * memberId로 회원 조회
	 * */
	
	public Members membersFindByMemberId(Long memberId) {
		
		return membersRepo.findById(memberId).orElse(null);
	}
			
	
	

}
