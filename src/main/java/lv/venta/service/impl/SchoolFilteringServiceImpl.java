package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ISchoolFilteringService;

@Service
public class SchoolFilteringServiceImpl implements ISchoolFilteringService {

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo grRepo;
	
	@Autowired
	private ICourseRepo coRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
		if( id <= 0)
		{
			throw new Exception("Id should be positive");
		}
		
		if(!studRepo.existsById(id))
		{
			throw new Exception("Student with id " + id + " doesn't exist");
		}
		ArrayList<Grade> result = grRepo.findByStudentStId(id);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no grade linked to student");
		}
		
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception {
		if( id <= 0)
		{
			throw new Exception("Id should be positive");
		}
		
		if(!studRepo.existsById(id))
		{
			throw new Exception("Student with id " + id + " doesn't exist");
		}
		
		ArrayList<Course> result = coRepo.findByGradesStudentStId(id);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no course linked to student");
		}
		
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		if( id <= 0)
		{
			throw new Exception("Id should be positive");
		}
		
		if(!profRepo.existsById(id))
		{
			throw new Exception("Professor with id " + id + " doesn't exist");
		}
		
		
		ArrayList<Course> result = coRepo.findByProfessorPId(id);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no course linked to profesor");
		}
		
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseId(long id) throws Exception {
		if( id <= 0)
		{
			throw new Exception("Id should be positive");
		}
		
		if(!coRepo.existsById(id))
		{
			throw new Exception("Course with id " + id + " doesn't exist");
		}
		
		
		if(!grRepo.existsByCourseCId(id))
		{
			throw new Exception("There is no course linked to grades");
		}
		
		float result = grRepo.calculateAVGGradeByCourseId(id);
		
		return result;
	}
	
	//TODO
	//uztaisīt abstrakto funkciju - izfiltrēt visus studentus, kuriem ir vismaz viena
	//nesekmīga atzīme
	//pāŗrakstīt so metodi arī šajā klasē
	

}
