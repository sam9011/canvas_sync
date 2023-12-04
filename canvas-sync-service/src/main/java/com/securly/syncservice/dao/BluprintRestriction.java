package com.securly.syncservice.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@Entity
@Table(name = "BluprintRestriction")
public class BluprintRestriction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "content")
	private boolean content;
	  
	@Column(name = "points")
	private boolean points;
	  
	@Column(name = "due_dates")
	private boolean due_dates;
	  
	@Column(name = "availability_dates")
	private boolean availability_dates;

}
