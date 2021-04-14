package com.circle.domain.proudct.group;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.circle.domain.proudct.HotdealProduct;

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
public class BestSelling {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_best")
	@SequenceGenerator(sequenceName = "seq_best", name="seq_best", allocationSize = 1 )
	Long bestSellingId;
	
	@JoinColumn(name = "hotdealProductId")
	@ManyToOne
	HotdealProduct hotdealProduct; 
}
