package com.circle.domain.proudct;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
public class MediumCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_medium_category")
	@SequenceGenerator(sequenceName = "seq_medium_category", name="seq_medium_category", allocationSize = 1 )
	Long mediumCategoryId;
	
	private String mediumCategoryName;
	
	private Integer state;
	
	@ManyToOne
	@JoinColumn(name = "mainCategoryId")
	MainCategory mainCategory;
	
}
