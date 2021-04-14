package com.circle.domain.proudct;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.circle.domain.user.Members;
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
public class StoreLikeList {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_like")
	@SequenceGenerator(sequenceName = "seq_like", name="seq_like", allocationSize = 1 )
	Long storeLikeListId;

	@JoinColumn(name = "hotdeal_product_Id")
	@ManyToOne
	HotdealProduct hotdealProduct;
	
	@ManyToOne
	@JoinColumn(name = "memberId")
	Members member;
	
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date regDate;

	
}
