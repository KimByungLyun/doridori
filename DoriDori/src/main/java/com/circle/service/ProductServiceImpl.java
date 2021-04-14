package com.circle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.circle.domain.proudct.HotdealProduct;
import com.circle.domain.proudct.StoreLikeList;
import com.circle.repository.HotdealProductRepository;
import com.circle.repository.StoreLikeListRepository;

import lombok.RequiredArgsConstructor;



@Service
public class ProductServiceImpl {

	@Autowired
	private HotdealProductRepository hotdealProductRepo;
	@Autowired
	private StoreLikeListRepository storeLikeListRepo;

	//**** hotdeal Product *****
	/**
	 * 핫딜 상품 전체 조회
	 * */
	public List<HotdealProduct> hotdealProductFindAll(Long memberId) {
		return hotdealProductRepo.findAll();
	}


	/**
	 * 핫딜 상품 핫딜 상품 id로 조회
	 * */
	public HotdealProduct hotdealProductFindByHotdealProductId(Long hotdealProuductId, Long memberId) {
		
		HotdealProduct hp = hotdealProductRepo.findById(hotdealProuductId).orElse(null);
		
		if(hp!=null) {
			if(storeLikeListRepo.findByMemberIdAndHotdealProductId(memberId, hp.getHotdealProductId())==null) {
				hp.setLikeState(0);
			} else {
				hp.setLikeState(1);
			}
		}
		return hp;
	}
	
	/**
	 * 핫딜 상품 신제품순으로 조회 (마감일이 지나지 않은 상품 중)
	 * */
	public List<HotdealProduct> hotdealProductFindAllOrderByRegDate(Long memberId){
		List<HotdealProduct> list = hotdealProductRepo.findAllOrderByRegdate();				

		//상품을 조회하고자 하는 멤버가 해당 상품의 좋아요를 눌렀는지 안눌렀는지 파악

		list = checkIsLiked(list, memberId);

		return list;
	}

	
	public List<HotdealProduct> checkIsLiked(List<HotdealProduct> list, Long memberId){

		for(HotdealProduct hp : list) {
			if(storeLikeListRepo.findByMemberIdAndHotdealProductId(memberId, hp.getHotdealProductId())==null) {
				hp.setLikeState(0);
			} else {
				hp.setLikeState(1);
			}
		}

		return list;
	}

	/**
	 * 핫딜 상품 마감순으로 조회 (마감일이 지나지 않은 상품 중)
	 * */
	public List<HotdealProduct> hotdealProductFindAllOrderByExpireDate(Long memberId){

		List<HotdealProduct> list = hotdealProductRepo.findAllOrderByExpiredate();			

		//상품을 조회하고자 하는 멤버가 해당 상품의 좋아요를 눌렀는지 안눌렀는지 파악

		list = checkIsLiked(list, memberId);

		return list;
	}

	/**
	 * 마감일이 지난 핫딜 상품 조회
	 * */
	public List<HotdealProduct> hotdealProductFindExpired(Long memberId){
		List<HotdealProduct> list = hotdealProductRepo.findAllExpired();				
		//상품을 조회하고자 하는 멤버가 해당 상품의 좋아요를 눌렀는지 안눌렀는지 파악

		list = checkIsLiked(list, memberId);

		return list;
	}

	/**
	 * 핫딜 상품 삽입
	 * */

	public int hotdealProductInsert(HotdealProduct hotdealProduct) {
		if(hotdealProductRepo.save(hotdealProduct)==null) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * 핫딜 상품 수정
	 * */

	/**
	 * 핫딜 상품 삭제
	 * */



	// ***** StoreLikeList *****
	public int StoreLikeListInsert(StoreLikeList storeLikeList) {
		
		if(storeLikeListRepo.save(storeLikeList)==null) {
			return 0;
		} else {
			return 1;
		}
	}	

}
