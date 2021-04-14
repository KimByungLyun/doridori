package com.circle.controller;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.circle.domain.proudct.HotdealProduct;
import com.circle.domain.proudct.OptionType;
import com.circle.domain.proudct.Options;
import com.circle.domain.proudct.Product;
import com.circle.repository.HotdealProductRepository;
import com.circle.repository.OptionRepository;
import com.circle.repository.OptionTypeRepository;
import com.circle.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@SpringBootTest
class DoriDoriApplicationTests {

	@Autowired
	ProductRepository pr;
	
	@Autowired
	OptionRepository or;
	
	@Autowired
	OptionTypeRepository otr;
	
	@Autowired
	HotdealProductRepository hpr;
	
	@Test
	void contextLoads() {
		otr.save(new OptionType());
	}

}
