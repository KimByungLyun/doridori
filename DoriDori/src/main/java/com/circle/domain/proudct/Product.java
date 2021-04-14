package com.circle.domain.proudct;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_product")
	@SequenceGenerator(sequenceName = "seq_product", name="seq_product", allocationSize = 1 )
	Long productId;
	
	String productName;
	String brand;
	String image;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date regDate;
	
	@ManyToOne
	@JoinColumn(name = "subCategoryId")
	SubCategory subCategory;
	
//	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//	List<OptionType> optionTypes = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "mallId")
	Mall mall;
	
	Integer state;
	
	
	
}
