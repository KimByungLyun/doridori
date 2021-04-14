package com.circle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.circle.domain.proudct.OptionType;
import com.circle.domain.proudct.Options;
import com.circle.domain.proudct.Product;





public interface OptionTypeRepository extends JpaRepository<OptionType,Long> {

	
	
}
