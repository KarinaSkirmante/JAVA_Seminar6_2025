package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;

public interface ISchoolFilteringService {

	public abstract ArrayList<Grade> selectGradesByStudentId(long id) throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByStudentId(long id) throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception;
	
	public abstract float calculateAVGGradeInCourseId(long id) throws Exception;
}
