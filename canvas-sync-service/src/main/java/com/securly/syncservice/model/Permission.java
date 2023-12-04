package com.securly.syncservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
	
	@JsonProperty(value = "create_discussion_topic")
	private boolean create_discussion_topic;
	
	@JsonProperty(value = "create_announcement")
	private boolean create_announcement;

}
