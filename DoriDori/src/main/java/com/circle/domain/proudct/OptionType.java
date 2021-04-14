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
public class OptionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_option_type")
	@SequenceGenerator(sequenceName = "seq_option_type", name="seq_option_type", allocationSize = 1 )
	Long optionTypeId;
	private String optionTypeName;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
}
