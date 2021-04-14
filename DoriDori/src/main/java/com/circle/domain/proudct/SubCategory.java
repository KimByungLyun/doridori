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
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_sub_category")
	@SequenceGenerator(sequenceName = "seq_sub_category", name="seq_sub_category", allocationSize = 1 )
	Long subCategoryId;
	
	private String subCategoryName;
	
	@ManyToOne
	@JoinColumn(name = "mediumCategoryId")
	MediumCategory mediumCategory;
	
	private Integer state;
	
}
