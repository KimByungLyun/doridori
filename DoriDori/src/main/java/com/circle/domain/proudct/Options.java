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
public class Options {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_option")
	@SequenceGenerator(sequenceName = "seq_option", name="seq_option", allocationSize = 1 )
	Long optionId;
	private String optionValue;
	
	@ManyToOne
	@JoinColumn(name = "optionTypeId")
	OptionType optionType;
		
	
}
