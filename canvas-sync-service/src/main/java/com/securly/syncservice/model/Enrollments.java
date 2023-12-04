package com.securly.syncservice.model;

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
public class Enrollments {
	
	private String type;
	private String role;
	private Integer role_id;
	private Integer user_id;
    private String enrollment_state;


}
