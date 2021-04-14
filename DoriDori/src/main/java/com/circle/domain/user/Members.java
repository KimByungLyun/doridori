package com.circle.domain.user;

import java.util.List;

import javax.persistence.Entity;
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
public class Members {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_members")
	@SequenceGenerator(sequenceName = "seq_members", name="seq_members", allocationSize = 1 )
	Long memberId;
	
	String password;
	String email;
	String name;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date regDate;
	
	Integer state;
}
