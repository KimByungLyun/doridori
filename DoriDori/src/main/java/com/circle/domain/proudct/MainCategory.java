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
public class MainCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_main_category")
	@SequenceGenerator(sequenceName = "seq_main_category", name="seq_main_category", allocationSize = 1 )
	Long mainCategoryId;
	
	
	private String mainCategoryName;
	
	@ManyToOne
	@JoinColumn(name = "childId")
	Child child;
	
	
	private Integer state;
	
	
	 
}
