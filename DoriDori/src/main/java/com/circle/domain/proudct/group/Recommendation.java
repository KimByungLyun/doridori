package com.circle.domain.proudct.group;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Recommendation {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_recommend")
	@SequenceGenerator(sequenceName = "seq_recommend", name="seq_recommend", allocationSize = 1 )
	Long recommendationId;
	
	@JoinColumn(name = "hotdealProductId")
	@ManyToOne
	HotdealProduct hotdealProduct;
	
	String keyWord;
	
}
