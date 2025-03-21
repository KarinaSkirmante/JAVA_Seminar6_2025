package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long>{

	//izveidos šādu SQL vaicājumu:
	//SELECT * FROM grade_table WHERE st_id = ?1;
	//?1 -> pirmais funkcijas parametrs
	public abstract ArrayList<Grade> findByStudentStId(long id);

}
