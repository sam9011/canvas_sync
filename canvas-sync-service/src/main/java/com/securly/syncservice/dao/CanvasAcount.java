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
@Table(name = "CanvasAcount")
public class CanvasAcount {
	
	
	// the ID of the Account object
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// The display name of the account
	@Column(name = "name")  
	private String name;
	
	// The UUID of the account
	@Column(name = "uuid")
	private String uuid;
	
	// The account's parent ID, or null if this is the root account
	@Column(name = "parent_account_id")
	private Integer parent_account_id;
	
	// The ID of the root account, or null if this is the root account
	@Column(name = "root_account_id")
	private Integer root_account_id;
	
	// The storage quota for the account in megabytes, if not otherwise specified
	@Column(name = "default_storage_quota_mb")
	private Integer default_storage_quota_mb;
	
	// The storage quota for a user in the account in megabytes, if not otherwise
	// specified
	@Column(name = "default_user_storage_quota_mb")
	private Integer default_user_storage_quota_mb;
	
	// The storage quota for a group in the account in megabytes, if not otherwise
	// specified
	@Column(name = "default_group_storage_quota_mb")
	private Integer default_group_storage_quota_mb;
	
	// The default time zone of the account. Allowed time zones are
	// {http://www.iana.org/time-zones IANA time zones} or friendlier
	// {http://api.rubyonrails.org/classes/ActiveSupport/TimeZone.html Ruby on Rails
	// time zones}.
	@Column(name = "default_time_zone")
	private String default_time_zone;
	
	// The account's identifier in the Student Information System. Only included if
	// the user has permission to view SIS information.
	@Column(name = "sis_account_id")
	private String sis_account_id;
	
	// The account's identifier in the Student Information System. Only included if
	// the user has permission to view SIS information.
	@Column(name = "integration_id")
	private String integration_id;
	
	// The id of the SIS import if created through SIS. Only included if the user
	// has permission to manage SIS information.
	@Column(name = "sis_import_id")
	private Integer sis_import_id;
	
	// The account's identifier that is sent as context_id in LTI launches.
	@Column(name = "lti_guid")
	private String lti_guid;
	
	// The state of the account. Can be 'active' or 'deleted'.
	@Column(name = "workflow_state")
	private String workflow_state;

}
