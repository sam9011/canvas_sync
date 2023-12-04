package com.securly.syncservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BluprintRestriction {
	
	@JsonProperty(value = "content")
	private boolean content;
	  
	@JsonProperty(value = "points")
	private boolean points;
	  
	@JsonProperty(value = "due_dates")
	private boolean due_dates;
	  
	@JsonProperty(value = "availability_dates")
	private boolean availability_dates;

}
