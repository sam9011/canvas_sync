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
public class CanvasAcount {
	
	
	// the ID of the Account object
	@JsonProperty(value = "id")
	private Integer id;
	
	// The display name of the account
	@JsonProperty("name")  
	private String name;
	
	// The UUID of the account
	@JsonProperty("uuid")
	private String uuid;
	
	// The account's parent ID, or null if this is the root account
	@JsonProperty("parent_account_id")
	private Integer parent_account_id;
	
	// The ID of the root account, or null if this is the root account
	@JsonProperty("root_account_id")
	private Integer root_account_id;
	
	// The storage quota for the account in megabytes, if not otherwise specified
	@JsonProperty("default_storage_quota_mb")
	private Integer default_storage_quota_mb;
	
	// The storage quota for a user in the account in megabytes, if not otherwise
	// specified
	@JsonProperty("default_user_storage_quota_mb")
	private Integer default_user_storage_quota_mb;
	
	// The storage quota for a group in the account in megabytes, if not otherwise
	// specified
	@JsonProperty("default_group_storage_quota_mb")
	private Integer default_group_storage_quota_mb;
	
	// The default time zone of the account. Allowed time zones are
	// {http://www.iana.org/time-zones IANA time zones} or friendlier
	// {http://api.rubyonrails.org/classes/ActiveSupport/TimeZone.html Ruby on Rails
	// time zones}.
	@JsonProperty("default_time_zone")
	private String default_time_zone;
	
	// The account's identifier in the Student Information System. Only included if
	// the user has permission to view SIS information.
	@JsonProperty("sis_account_id")
	private String sis_account_id;
	
	// The account's identifier in the Student Information System. Only included if
	// the user has permission to view SIS information.
	@JsonProperty(value ="integration_id")
	private String integration_id;
	
	// The id of the SIS import if created through SIS. Only included if the user
	// has permission to manage SIS information.
	@JsonProperty(value = "sis_import_id")
	private Integer sis_import_id;
	
	// The account's identifier that is sent as context_id in LTI launches.
	@JsonProperty("lti_guid")
	private String lti_guid;
	
	// The state of the account. Can be 'active' or 'deleted'.
	@JsonProperty("workflow_state")
	private String workflow_state;

}
