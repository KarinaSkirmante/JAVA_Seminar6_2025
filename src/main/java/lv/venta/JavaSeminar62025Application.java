package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class JavaSeminar62025Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar62025Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testDB(IStudentRepo studRepo, IProfessorRepo profRepo, 
			ICourseRepo couRepo, IGradeRepo grRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student st1 = new Student("Jānis", "Bērziņš");
				Student st2 = new Student("Anna Paula", "Jauka-Nejauka");
				studRepo.saveAll(Arrays.asList(st1, st2));
				
				Professor p1 = new Professor("Karina", "Šķirmante", Degree.mg);
				Professor p2 = new Professor("Kārlis", "Immers", Degree.mg);
				Professor p3 = new Professor("Artūrs", "Orbidāns", Degree.mg);
				Professor p4 = new Professor("Kārlis", "Laborants", Degree.bsc);
				profRepo.saveAll(Arrays.asList(p1, p2, p3, p4));
				
				Course c1 = new Course("Tīklu operētajsistēmas", 6, p2);
				Course c2 = new Course("Programmēšana tīmeklī JAVA", 6, p1);
				Course c3 = new Course("Datorsistēmu arhitektūra", 6, p3, p4);
				Course c4 = new Course("Datu Struktūras un pamatalgoritmi", 3, p1);
				couRepo.saveAll(Arrays.asList(c1, c2, c3, c4));
				
				p1.addCourse(c2);
				p1.addCourse(c4);
				p2.addCourse(c1);
				p3.addCourse(c3);
				p4.addCourse(c3);
				profRepo.saveAll(Arrays.asList(p1, p2, p3, p4));
				
				Grade g1 = new Grade(10, st2, c2);//10 nopelnīja Anna Paula JAVA kursa
				Grade g2 = new Grade(8, st1, c2);//8 nopelnīja Jānis JAVA kursā
				Grade g3 = new Grade(3, st2, c1);//3 nopelnīja Anna Paula OS kursā
				Grade g4 = new Grade(5, st1, c1);//5 nopelnija Jānis OS kursā
				Grade g5 = new Grade(4, st1,c3);//4 nopelnīja Jānis DatorSis kursā
				Grade g6 = new Grade(10, st2,c3);//10 nopelnīja Anna Paula DatorSis kursā
				
				grRepo.saveAll(Arrays.asList(g1, g2, g3, g4, g5, g6));
				
			}
		};
	}
	

}
