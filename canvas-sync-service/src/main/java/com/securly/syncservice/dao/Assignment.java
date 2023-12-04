package com.securly.syncservice.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@Entity
@Table(name ="Assignment")
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "content")
	private boolean content;
	
	@Column(name = "points")
	private boolean points;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "WikiPage")
	private WikiPage wiki_page;
	
}
