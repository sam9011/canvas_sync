package com.securly.syncservice.dao;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

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

@Builder
@Data
@ToString
@Entity
@Table(name = "CanvasCourse")
public class CanvasCourse {
	
		  // the unique identifier for the course
		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		 private Integer id;
		 
		  // the SIS identifier for the course, if defined. This field is only included if
		  // the user has permission to view SIS information.
		  @Column(name = "sis_course_id")
		  private Integer sis_course_id;
		  
		  // the UUID of the course
		  @Column(name = "uuid")
		  private String uuid;
		  
		  // the integration identifier for the course, if defined. This field is only
		  // included if the user has permission to view SIS information.
		  @Column(name = "integration_id")
		  private Integer integration_id;
		  
		  // the unique identifier for the SIS import. This field is only included if the
		  // user has permission to manage SIS information.
		  @Column(name = "sis_import_id")
		  private Integer sis_import_id;
		  
		  // the full name of the course. If the requesting user has set a nickname for
		  // the course, the nickname will be shown here.
		  @Column(name = "name")
		  private String name;
		  
		  // the course code
		  @Column(name = "course_code")
		  private String course_code;
		  
		  // the actual course name. This field is returned only if the requesting user
		  // has set a nickname for the course.
		  @Column(name = "original_name")
		  private String original_name;
		  
		  // the current state of the course one of 'unpublished', 'available',
		  // 'completed', or 'deleted'
		  @Column(name = "workflow_state")
		  private String workflow_state;
		  // the account associated with the course

		  @Column(name = "account_id")
		  private Integer account_id;
		  
		  // the root account associated with the course
		  @Column(name = "root_account_id")
		  private Integer root_account_id;
		  
		  // the enrollment term associated with the course
		  @Column(name = "enrollment_term_id")
		  private Integer enrollment_term_id;
		  
		  // A list of grading periods associated with the course
		  @Column(name = "grading_periods")
		  private String grading_periods;
		  
		  // the grading standard associated with the course
		  @Column(name = "grading_standard_id")
		  private Integer grading_standard_id;
		  
		  // the grade_passback_setting set on the course
		  @Column(name = "grade_passback_setting")
		  private String grade_passback_setting;
		  
		  // the date the course was created.
		  @Column(name = "created_at")
		  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX`")
		  private Timestamp created_at;
		  
		  // the start date for the course, if applicable
		  @Column(name = "start_at")
		  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX`")
		  private Timestamp start_at;
		  
		  // the end date for the course, if applicable
		  @Column(name = "end_at")
		  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX`")
		  private Timestamp end_at;
		  
		  // the course-set locale, if applicable
		  @Column(name = "locale")
		  private String locale;
		  
		  // A list of enrollments linking the current user to the course. for student
		  // enrollments, grading information may be included if include[]=total_scores
		  @Column(name = "enrollments")
		  private String enrollments;
		  
		  // optional: the total number of active and invited students in the course
		  @Column(name = "total_students")
		  private Integer total_students;

		  // course calendar
		  @Column(name = "calendar")
		  private String calendar;
		  
		  // the type of page that users will see when they first visit the course -
		  // 'feed': Recent Activity Dashboard - 'wiki': Wiki Front Page - 'modules':
		  // Course Modules/Sections Page - 'assignments': Course Assignments List -
		  // 'syllabus': Course Syllabus Page other types may be added in the future
		  @Column(name = "default_view")
		  private String default_view;
		  
		  // optional: user-generated HTML for the course syllabus
		  @Column(name = "syllabus_body")
		  private String syllabus_body;
		  
		  // optional: the number of submissions needing grading returned only if the
		  // current user has grading rights and include[]=needs_grading_count
		  @Column(name = "needs_grading_count")
		  private Integer needs_grading_count;
		  
		  
		  // optional: the enrollment term object for the course returned only if
		  // include[]=term
		  @Column(name = "term")
		  private String term;
		  
		  // optional: information on progress through the course returned only if
		  // include[]=course_progress
		  @Column(name = "course_progress")
		  private String course_progress;
		  
		  // weight final grade based on assignment group percentages
		  @Column(name = "apply_assignment_group_weights")
		  private boolean apply_assignment_group_weights;
		  
		  // optional: the permissions the user has for the course. returned only for a
		  // single course and include[]=permissions
		  @OneToOne
		  @PrimaryKeyJoinColumn(name = "Permission")
		  private Permission permissions;
		  

		  @Column(name = "is_public")
		  private boolean is_public;

		  @Column(name = "is_public_to_auth_users")
		  private boolean is_public_to_auth_users;
		  

		  @Column(name = "public_syllabus")
		  private boolean public_syllabus;

		  @Column(name = "public_syllabus_to_auth")
		  private boolean public_syllabus_to_auth;
		  
		  // optional: the public description of the course
		  @Column(name = "public_description")
		  private String public_description;

		  @Column(name = "storage_quota_mb")
		  private Integer storage_quota_mb;

		  @Column(name = "storage_quota_used_mb")
		  private Integer storage_quota_used_mb;

		  @Column(name = "hide_final_grades")
		  private boolean hide_final_grades;

		  @Column(name = "license")
		  private String license;

		  @Column(name = "allow_student_assignment_edits")
		  private boolean allow_student_assignment_edits;

		  @Column(name = "allow_wiki_comments")
		  private boolean allow_wiki_comments;

		  @Column(name = "allow_student_forum_attachments")
		  private boolean allow_student_forum_attachments;

		  @Column(name = "open_enrollment")
		  private boolean open_enrollment;

		  @Column(name = "self_enrollment")
		  private boolean self_enrollment;

		  @Column(name = "restrict_enrollments_to_course_dates")
		  private boolean restrict_enrollments_to_course_dates;

		  @Column(name = "course_format")
		  private String course_format;
		  
		  // optional: this will be true if this user is currently prevented from viewing
		  // the course because of date restriction settings
		  @Column(name = "access_restricted_by_date")
		  private boolean access_restricted_by_date;
		  
		  // The course's IANA time zone name.
		  @Column(name = "time_zone")
		  private String time_zone;

		  // optional: whether the course is set as a Blueprint Course (blueprint fields
		  // require the Blueprint Courses feature)
		  @Column(name = "blueprint")
		  private boolean blueprint;
		  
		  // optional: Set of restrictions applied to all locked course objects
		  @OneToOne
		  @PrimaryKeyJoinColumn(name = "BluprintRestriction")
		  private BluprintRestriction blueprint_restrictions;
		  
		  // optional: Sets of restrictions differentiated by object type applied to
		  // locked course objects
		  @OneToOne
		  @PrimaryKeyJoinColumn(name = "BluprintRestrictionType")
		  private BluprintRestrictionType blueprint_restrictions_by_object_type; 
		  
		  
		  // optional: whether the course is set as a template (requires the Course
		  // Templates feature)
		  @Column(name = "template")
		  private boolean template;

}
