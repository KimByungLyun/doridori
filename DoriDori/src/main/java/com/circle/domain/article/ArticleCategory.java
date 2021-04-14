package com.circle.domain.article;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ArticleCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_article_category")
	@SequenceGenerator(sequenceName = "seq_article_category", name="seq_article_category", allocationSize = 1 )
	Long articleCatehgoryId;

	String categoryName;
	
}
