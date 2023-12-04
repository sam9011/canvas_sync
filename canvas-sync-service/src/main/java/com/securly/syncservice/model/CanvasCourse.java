package com.securly.syncservice.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
public class CanvasCourse {
	
		  // the unique identifier for the course
		  @JsonProperty(value = "id")
		  private Integer id;
		 
		  // the SIS identifier for the course, if defined. This field is only included if
		  // the user has permission to view SIS information.
		  @JsonProperty(value = "sis_course_id")
		  private Integer sis_course_id;
		  
		  // the UUID of the course
		  @JsonProperty(value = "uuid")
		  private String uuid;
		  
		  // the integration identifier for the course, if defined. This field is only
		  // included if the user has permission to view SIS information.
		  @JsonProperty(value = "integration_id")
		  private Integer integration_id;
		  
		  // the unique identifier for the SIS import. This field is only included if the
		  // user has permission to manage SIS information.
		  @JsonProperty(value = "sis_import_id")
		  private Integer sis_import_id;
		  
		  // the full name of the course. If the requesting user has set a nickname for
		  // the course, the nickname will be shown here.
		  @JsonProperty(value = "name")
		  private String name;
		  
		  // the course code
		  @JsonProperty(value = "course_code")
		  private String course_code;
		  
		  // the actual course name. This field is returned only if the requesting user
		  // has set a nickname for the course.
		  @JsonProperty(value = "original_name")
		  private String original_name;
		  
		  // the current state of the course one of 'unpublished', 'available',
		  // 'completed', or 'deleted'
		  @JsonProperty(value = "workflow_state")
		  private String workflow_state;
		  // the account associated with the course

		  @JsonProperty(value = "account_id")
		  private Integer account_id;
		  
		  // the root account associated with the course
		  @JsonProperty(value = "root_account_id")
		  private Integer root_account_id;
		  
		  // the enrollment term associated with the course
		  @JsonProperty(value = "enrollment_term_id")
		  private Integer enrollment_term_id;
		  
		  // A list of grading periods associated with the course
		  @JsonProperty(value = "grading_periods")
		  private String grading_periods;
		  
		  // the grading standard associated with the course
		  @JsonProperty(value = "grading_standard_id")
		  private Integer grading_standard_id;
		  
		  // the grade_passback_setting set on the course
		  @JsonProperty(value = "grade_passback_setting")
		  private String grade_passback_setting;
		  
		  // the date the course was created.
		  @JsonProperty(value = "created_at")
		  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX`")
		  private Timestamp created_at;
		  
		  // the start date for the course, if applicable
		  @JsonProperty(value = "start_at")
		  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX`")
		  private Timestamp start_at;
		  
		  // the end date for the course, if applicable
		  @JsonProperty(value = "end_at")
		  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX`")
		  private Timestamp end_at;
		  
		  // the course-set locale, if applicable
		  @JsonProperty(value = "locale")
		  private String locale;
		  
		  // A list of enrollments linking the current user to the course. for student
		  // enrollments, grading information may be included if include[]=total_scores
		  @JsonProperty(value = "enrollments")
		  private List<Enrollments> enrollments;
		  
		  // optional: the total number of active and invited students in the course
		  @JsonProperty(value = "total_students")
		  private Integer total_students;

		  // course calendar
		  @JsonProperty(value = "calendar")
		  private Calender calendar;
		  
		  // the type of page that users will see when they first visit the course -
		  // 'feed': Recent Activity Dashboard - 'wiki': Wiki Front Page - 'modules':
		  // Course Modules/Sections Page - 'assignments': Course Assignments List -
		  // 'syllabus': Course Syllabus Page other types may be added in the future
		  @JsonProperty(value = "default_view")
		  private String default_view;
		  
		  // optional: user-generated HTML for the course syllabus
		  @JsonProperty(value = "syllabus_body")
		  private String syllabus_body;
		  
		  // optional: the number of submissions needing grading returned only if the
		  // current user has grading rights and include[]=needs_grading_count
		  @JsonProperty(value = "needs_grading_count")
		  private Integer needs_grading_count;
		  
		  
		  // optional: the enrollment term object for the course returned only if
		  // include[]=term
		  @JsonProperty(value = "term")
		  private String term;
		  
		  // optional: information on progress through the course returned only if
		  // include[]=course_progress
		  @JsonProperty(value = "course_progress")
		  private String course_progress;
		  
		  // weight final grade based on assignment group percentages
		  @JsonProperty(value = "apply_assignment_group_weights")
		  private boolean apply_assignment_group_weights;
		  
		  // optional: the permissions the user has for the course. returned only for a
		  // single course and include[]=permissions
		  @JsonProperty(value = "permissions")
		  private Permission permissions;
		  

		  @JsonProperty(value = "is_public")
		  private boolean is_public;

		  @JsonProperty(value = "is_public_to_auth_users")
		  private boolean is_public_to_auth_users;
		  

		  @JsonProperty(value = "public_syllabus")
		  private boolean public_syllabus;

		  @JsonProperty(value = "public_syllabus_to_auth")
		  private boolean public_syllabus_to_auth;
		  
		  // optional: the public description of the course
		  @JsonProperty(value = "public_description")
		  private String public_description;

		  @JsonProperty(value = "storage_quota_mb")
		  private Integer storage_quota_mb;

		  @JsonProperty(value = "storage_quota_used_mb")
		  private Integer storage_quota_used_mb;

		  @JsonProperty(value = "hide_final_grades")
		  private boolean hide_final_grades;

		  @JsonProperty(value = "license")
		  private String license;

		  @JsonProperty(value = "allow_student_assignment_edits")
		  private boolean allow_student_assignment_edits;

		  @JsonProperty(value = "allow_wiki_comments")
		  private boolean allow_wiki_comments;

		  @JsonProperty(value = "allow_student_forum_attachments")
		  private boolean allow_student_forum_attachments;

		  @JsonProperty(value = "open_enrollment")
		  private boolean open_enrollment;

		  @JsonProperty(value = "self_enrollment")
		  private boolean self_enrollment;

		  @JsonProperty(value = "restrict_enrollments_to_course_dates")
		  private boolean restrict_enrollments_to_course_dates;

		  @JsonProperty(value = "course_format")
		  private String course_format;
		  
		  // optional: this will be true if this user is currently prevented from viewing
		  // the course because of date restriction settings
		  @JsonProperty(value = "access_restricted_by_date")
		  private boolean access_restricted_by_date;
		  
		  // The course's IANA time zone name.
		  @JsonProperty(value = "time_zone")
		  private String time_zone;

		  // optional: whether the course is set as a Blueprint Course (blueprint fields
		  // require the Blueprint Courses feature)
		  @JsonProperty(value = "blueprint")
		  private boolean blueprint;
		  
		  // optional: Set of restrictions applied to all locked course objects
		  @JsonProperty(value = "blueprint_restrictions")
		  private BluprintRestriction blueprint_restrictions;
		  
		  // optional: Sets of restrictions differentiated by object type applied to
		  // locked course objects
		  @JsonProperty(value = "blueprint_restrictions_by_object_type")
		  private BluprintRestrictionType blueprint_restrictions_by_object_type; 
		  
		  
		  // optional: whether the course is set as a template (requires the Course
		  // Templates feature)
		  @JsonProperty(value = "template")
		  private boolean template;

}
