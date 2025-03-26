package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;

public interface IStudentRepo extends CrudRepository<Student, Long>{
	//izveidos šādu SQL vaicājumu:
	//SELECT T1.st_id, T1.name, T1.surname FROM student_table as T1 JOIN grade_table as T2 ON T1.st_id=T2.st_id WHERE T2.grvalue<4;
	ArrayList<Student> findByGradesGrvalueLessThan(int i);

}
