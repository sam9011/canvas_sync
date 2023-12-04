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
public class Assignment {

	@JsonProperty("content")
	private boolean content;
	
	@JsonProperty("points")
	private boolean points;
	
	@JsonProperty("wiki_page")
	private WikiPage wiki_page;
	
}
