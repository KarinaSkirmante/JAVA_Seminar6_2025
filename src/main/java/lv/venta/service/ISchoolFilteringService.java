package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Student;

public interface ISchoolFilteringService {

	public abstract ArrayList<Grade> selectGradesByStudentId(long id) throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByStudentId(long id) throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception;
	
	public abstract float calculateAVGGradeInCourseId(long id) throws Exception;
	
	public abstract ArrayList<Student> selectStudentsWithFailedGrades() throws Exception;
	
}
