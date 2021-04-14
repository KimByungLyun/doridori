package com.circle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.circle.domain.proudct.HotdealProduct;
import com.circle.domain.proudct.StoreLikeList;
import com.circle.domain.user.Members;
import com.circle.service.ProductServiceImpl;
import com.circle.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import lombok.RequiredArgsConstructor;

@Controller
public class AppController {

	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private UserServiceImpl userService;

	//모든 오늘의 핫딜 상품 전체 조회
	@RequestMapping("/app/getAllHotdealProducts")
	@ResponseBody
	public String getAllHotdealProducts(Long memberId) {

		List<HotdealProduct> list = productService.hotdealProductFindAll(memberId);

		ObjectMapper mapper = new ObjectMapper();

		String result = "";

		try {
			result = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return result;
	}

	//최신순으로 오늘의 핫딜 가져오기
	@RequestMapping("/app/getAllHotdealProductsOrderByRegDate")
	@ResponseBody
	public String getAllHotdealProductsOrderByRegDate(Long memberId) {

		List<HotdealProduct> list = productService.hotdealProductFindAllOrderByRegDate(memberId);

		ObjectMapper mapper = new ObjectMapper();

		String result = "";

		try {
			result = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return result;
	}

	//마감순으로 오늘의 핫딜 가져오기
	@RequestMapping("/app/getAllHotdealProductsOrderByexpireDate")
	@ResponseBody
	public String getAllHotdealProductsOrderByexpireDate(Long memberId) {

		List<HotdealProduct> list = productService.hotdealProductFindAllOrderByExpireDate(memberId);

		ObjectMapper mapper = new ObjectMapper();

		String result = "";

		try {
			result = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return result;
	}

	//지난 딜 가져오기
	@RequestMapping("/app/getExpiredHotdealProudct")
	@ResponseBody
	public String getExpiredHotdealProudct(Long memberId) {

		List<HotdealProduct> list = productService.hotdealProductFindExpired(memberId);

		ObjectMapper mapper = new ObjectMapper();

		String result = "";

		try {
			result = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//좋아요 누르기
	@RequestMapping("/app/addStoreLike")
	@ResponseBody
	public String addStoreLike(Long memberId, Long hotdealProudctId) {

		
		
		
		HotdealProduct hp = productService.hotdealProductFindByHotdealProductId(hotdealProudctId, memberId) ;
		Members member = userService.membersFindByMemberId(memberId);
		
		//좋아요를 누른 회원을 찾을 수 없을 경우
		if(member == null) {
			return "2";
		}
		
		StoreLikeList sl = new StoreLikeList(null, hp , member, null);
		
		int value = productService.StoreLikeListInsert(sl);
		
		ObjectMapper mapper = new ObjectMapper();

		String result = "";

		try {
			result = mapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return result;
	} 




}
