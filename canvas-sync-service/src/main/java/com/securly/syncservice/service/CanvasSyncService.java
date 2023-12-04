package com.securly.syncservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securly.syncservice.controller.exception.CanvasAccountException;
import com.securly.syncservice.controller.exception.CanvasCourseException;
import com.securly.syncservice.invoker.CanvasAccountInvoker;
import com.securly.syncservice.invoker.CanvasCourseInvoker;
import com.securly.syncservice.model.CanvasAcount;
import com.securly.syncservice.model.CanvasCourse;
import com.securly.syncservice.repository.CanavasAccountSyncRepository;
import com.securly.syncservice.repository.CanvaseCourceSyncRepository;

import lombok.extern.slf4j.Slf4j;

@Service("canvasSyncService")
@Slf4j
public class CanvasSyncService {

	@Autowired
	private CanvasAccountInvoker canvasAccountInvoker;
   
	@Autowired
	private CanvasCourseInvoker canvasCourseInvoker;
	
	@Autowired
	private CanvaseCourceSyncRepository canvaseCourceSyncRepository;
	
	@Autowired
	private CanavasAccountSyncRepository canavasAccountSyncRepository;

	
	public void sync() {

		try {
			// get accounts from canvas
			List <CanvasAcount> canvasAccountsList = canvasAccountInvoker.getAllCanvasAccounts();
			
			
			// sync canvas accounts into database  
			syncAccounts(canvasAccountsList);
			
			// get Course from canvas
			List <CanvasCourse> canvasCourseList = canvasCourseInvoker.getAllCanvasCourses();
		
			// sync canvas course into database  
			syncCourse(canvasCourseList);
			
		}catch(CanvasAccountException accountException) {
			throw accountException;
		}catch(CanvasCourseException courseException) {
			throw courseException;
		}catch(Exception exception) {
			throw new CanvasAccountException("Account Error",CanvasAccountException.ErrorCode.ACCOUNT_CREATION_FAILED);
		}
		
	}


	private void syncCourse(List<CanvasCourse> canvasCourseList) {

		try {
			// sync canvas accounts into database
			List<com.securly.syncservice.dao.CanvasCourse> canvasCourseDaoList = translateModelToDaoCanvasCourse(
					canvasCourseList);
			canvasCourseDaoList.forEach(canvasCourse -> {
				com.securly.syncservice.dao.CanvasCourse canCourse = canvaseCourceSyncRepository.save(canvasCourse);
				if (null == canCourse.getId()) {
					log.error("Failed to save couse name = {}", canvasCourse.getName());
				}
			});
		} catch (CanvasAccountException accountException) {
			throw accountException;
		} catch (CanvasCourseException courseException) {
			throw courseException;
		} catch (Exception exception) {
			throw new CanvasAccountException("Account Error", CanvasAccountException.ErrorCode.ACCOUNT_CREATION_FAILED);
		}
	}


	private List<com.securly.syncservice.dao.CanvasCourse> translateModelToDaoCanvasCourse(
			List<CanvasCourse> canvasCourseList) {

		List<com.securly.syncservice.dao.CanvasCourse> canvasCourseResponseList = new ArrayList<>();

		try {

			canvasCourseList.forEach(canvasCourse -> {
				com.securly.syncservice.dao.CanvasCourse canvasCours = com.securly.syncservice.dao.CanvasCourse
						.builder().access_restricted_by_date(canvasCourse.isAccess_restricted_by_date())
						.account_id(canvasCourse.getAccount_id())
						.allow_student_assignment_edits(canvasCourse.isAllow_student_assignment_edits())
						.allow_wiki_comments(canvasCourse.isAllow_wiki_comments())
						.apply_assignment_group_weights(canvasCourse.isApply_assignment_group_weights())
						.blueprint(canvasCourse.isBlueprint())
//					.blueprint_restrictions(BluprintRestriction.builder()
//							.availability_dates(canvasCourse.getBlueprint_restrictions().isAvailability_dates())
//							.content(canvasCourse.getBlueprint_restrictions().isContent())
//							.due_dates(canvasCourse.getBlueprint_restrictions().isDue_dates())
//							.points(canvasCourse.getBlueprint_restrictions().isPoints()).build())
//					.blueprint_restrictions_by_object_type(BluprintRestrictionType.builder().assignment(Assignment
//							.builder()
//							.content(canvasCourse.getBlueprint_restrictions_by_object_type().getAssignment().isContent())
//							.points(canvasCourse.getBlueprint_restrictions_by_object_type().getAssignment().isPoints())
//							.wiki_page(WikiPage.builder()
//									.content(canvasCourse.getBlueprint_restrictions_by_object_type().getAssignment()
//											.getWiki_page().isContent())
//									.build())
//							.build()).build())
						.calendar(canvasCourse.getCalendar().getIcs()).course_code(canvasCourse.getCourse_code())
						.course_format(canvasCourse.getCourse_format())
						.course_progress(canvasCourse.getCourse_progress()).created_at(canvasCourse.getCreated_at())
						.default_view(canvasCourse.getDefault_view()).end_at(canvasCourse.getEnd_at())
						.enrollment_term_id(canvasCourse.getEnrollment_term_id())
						.enrollments(canvasCourse.getEnrollments().get(0).getType())
						.grade_passback_setting(canvasCourse.getGrade_passback_setting())
						.grading_periods(canvasCourse.getGrading_periods())
						.grading_standard_id(canvasCourse.getGrading_standard_id())
						.hide_final_grades(canvasCourse.isHide_final_grades())
						.integration_id(canvasCourse.getIntegration_id()).is_public(canvasCourse.is_public())
						.is_public_to_auth_users(canvasCourse.is_public_to_auth_users())
						.license(canvasCourse.getLicense()).locale(canvasCourse.getLocale())
						.name(canvasCourse.getName()).needs_grading_count(canvasCourse.getNeeds_grading_count())
						.open_enrollment(canvasCourse.isOpen_enrollment())
						.original_name(canvasCourse.getOriginal_name())
//					.permissions(Permission.builder()
//							.create_announcement(canvasCourse.getPermissions().isCreate_announcement())
//							.create_discussion_topic(canvasCourse.getPermissions().isCreate_discussion_topic()).build())
						.public_description(canvasCourse.getPublic_description())
						.public_syllabus(canvasCourse.isPublic_syllabus())
						.public_syllabus_to_auth(canvasCourse.isPublic_syllabus_to_auth())
						.restrict_enrollments_to_course_dates(canvasCourse.isRestrict_enrollments_to_course_dates())
						.root_account_id(canvasCourse.getRoot_account_id())
						.self_enrollment(canvasCourse.isSelf_enrollment())
						.sis_course_id(canvasCourse.getSis_course_id()).sis_import_id(canvasCourse.getSis_import_id())
						.start_at(canvasCourse.getStart_at()).storage_quota_mb(canvasCourse.getStorage_quota_mb())
						.storage_quota_used_mb(canvasCourse.getStorage_quota_used_mb())
						.syllabus_body(canvasCourse.getSyllabus_body()).template(canvasCourse.isTemplate())
						.term(canvasCourse.getTerm()).time_zone(canvasCourse.getTime_zone())
						.total_students(canvasCourse.getTotal_students()).uuid(canvasCourse.getUuid())
						.workflow_state(canvasCourse.getWorkflow_state()).build();

				canvasCourseResponseList.add(canvasCours);
			});
		} catch (CanvasAccountException accountException) {
			throw accountException;
		} catch (CanvasCourseException courseException) {
			throw courseException;
		} catch (Exception exception) {
			throw new CanvasAccountException("Account Error", CanvasAccountException.ErrorCode.ACCOUNT_CREATION_FAILED);
		}
		return canvasCourseResponseList;
	}


	private void syncAccounts(List<CanvasAcount> canvasAccountsList) {
		try {
			// sync canvas accounts into database
			List<com.securly.syncservice.dao.CanvasAcount> canvasAccountDaoList = translateModelToDaoCanvasAccount(
					canvasAccountsList);
			canvasAccountDaoList.forEach(canvasAccount -> {
				com.securly.syncservice.dao.CanvasAcount canAccount = canavasAccountSyncRepository.save(canvasAccount);
				if (null == canAccount.getId()) {
					log.error("Failed to save couse name = {}", canvasAccount.getName());
				}
			});
		} catch (CanvasAccountException accountException) {
			throw accountException;
		} catch (CanvasCourseException courseException) {
			throw courseException;
		} catch (Exception exception) {
			throw new CanvasAccountException("Account Error", CanvasAccountException.ErrorCode.ACCOUNT_CREATION_FAILED);
		}

	}


	private List<com.securly.syncservice.dao.CanvasAcount> translateModelToDaoCanvasAccount(
			List<CanvasAcount> canvasAccountsList) {

		List<com.securly.syncservice.dao.CanvasAcount> canvasAccountDaoList = new ArrayList<>();
		try {
			canvasAccountsList.forEach(canwasAccount -> {

				com.securly.syncservice.dao.CanvasAcount canAccount = null;

				canAccount = com.securly.syncservice.dao.CanvasAcount.builder()
						.default_group_storage_quota_mb(canwasAccount.getDefault_group_storage_quota_mb())
						.default_storage_quota_mb(canwasAccount.getDefault_storage_quota_mb())
						.default_time_zone(canwasAccount.getDefault_time_zone())
						.default_user_storage_quota_mb(canwasAccount.getDefault_user_storage_quota_mb())
						.integration_id(canwasAccount.getIntegration_id()).lti_guid(canwasAccount.getLti_guid())
						.workflow_state(canwasAccount.getWorkflow_state()).uuid(canwasAccount.getUuid())
						.sis_import_id(canwasAccount.getSis_import_id())
						.sis_account_id(canwasAccount.getSis_account_id())
						.root_account_id(canwasAccount.getRoot_account_id())
						.parent_account_id(canwasAccount.getParent_account_id()).name(canwasAccount.getName()).build();
				canvasAccountDaoList.add(canAccount);
			});
		} catch (CanvasAccountException accountException) {
			throw accountException;
		} catch (CanvasCourseException courseException) {
			throw courseException;
		} catch (Exception exception) {
			throw new CanvasAccountException("Course Error", CanvasAccountException.ErrorCode.ACCOUNT_CREATION_FAILED);
		}
		return canvasAccountDaoList;
	}
	
}
