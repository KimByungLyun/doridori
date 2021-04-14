package com.circle.domain.proudct;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@ToString
public class HotdealProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_hotdeal_product")
	@SequenceGenerator(sequenceName = "seq_hotdeal_product", name="seq_hotdeal_product", allocationSize = 1 )
	Long hotdealProductId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date regDate;
	
	Integer price;
	
	String url;
	
	String mall;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date expireDate;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	Product product;

	Integer state;
	
	@Transient
	Integer likeState;
}
