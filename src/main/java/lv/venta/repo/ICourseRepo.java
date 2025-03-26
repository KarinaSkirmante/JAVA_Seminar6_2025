package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Long> {

	//izveidos šādu SQL vaicājumu:
	//SELECT T2.cid, T2.title,  T2.pid, T2.cp FROM grade_table as T1 JOIN course_table as T2 ON T
	//1.cid = T2.cid WHERE T1.st_id=?1;
	//?1 -> pirmais funkcijas parametrs
	public abstract ArrayList<Course> findByGradesStudentStId(long id);

	//izveidos šādu SQL vaicājumu:
	//SELECT * FROM course_table WHERE pid = 1;
	//?1 -> pirmais funkcijas parametrs
	public abstract ArrayList<Course> findByProfessorPId(long id);

}
