package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.service.ISchoolFilteringService;

@Controller
@RequestMapping("/school/filtering")
public class SchoolFilteringController {
	
	@Autowired
	private ISchoolFilteringService schoolFiltService;
	
	
	@GetMapping("/grades/student/{id}")//localhost:8080/school/filtering/grades/student/1
	public String getControllerGradesByStudent(@PathVariable(name = "id") long id, Model model)
	{
		try {
			ArrayList<Grade> filteredGrades = schoolFiltService.selectGradesByStudentId(id);
			model.addAttribute("package", filteredGrades);
			return "show-grades";//parādīs show-grades.html lapu ar injencētu sarakstu no filteredGrades
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error";
		}
	}
	
	
	@GetMapping("/courses/student/{id}")//localhost:8080/school/filtering/courses/student/1
	public String getControllerCoursesByStudent(@PathVariable(name = "id") long id, Model model)
	{
		try {
			ArrayList<Course> filteredCourses = schoolFiltService.selectCoursesByStudentId(id);
			model.addAttribute("package", filteredCourses);
			return "show-courses";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error";
		}
	}

	
	@GetMapping("/courses/professor/{id}")//localhost:8080/school/filtering/courses/professor/1
	public String getControllerCoursesByProfessor(@PathVariable(name = "id") long id, Model model)
	{
		try {
			ArrayList<Course> filteredCourses = schoolFiltService.selectCoursesByProfessorId(id);
			model.addAttribute("package", filteredCourses);
			return "show-courses";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error";
		}
	}
	
	
	@GetMapping("/courses/avg/{id}")//localhost:8080/school/filtering/courses/avg/1
	public String getControllerAVGGradeInCourse(@PathVariable(name = "id") long id, Model model)
	{
		try {
			float avgGrade = schoolFiltService.calculateAVGGradeInCourseId(id);
			model.addAttribute("avgrade", "AVG grade is: " + avgGrade);
			return "show-avg-grade";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error";
		}
	}
	
	@GetMapping("/student/failed")//localhost:8080/school/filtering/student/failed
	public String getControllerFailedStudents(Model model)
	{
		try {
			ArrayList<Student> filteredStudents = schoolFiltService.selectStudentsWithFailedGrades();
			model.addAttribute("package", filteredStudents);
			return "show-students";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error";
		}
	}
	

}
