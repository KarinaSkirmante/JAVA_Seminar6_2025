package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")//MYSQL - course_table
@Entity
public class Course {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "CId")//MYSQL - c_id
	@Id //ka primārā atslēga (PK)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]{4,50}")
	@Column(name = "Title")
	private String title;
	
	@Min(0)
	@Max(30)
	@Column(name = "Cp")
	private int cp;
	
	@ManyToMany
	@JoinTable(name = "CourseProfessorTable",
	joinColumns = @JoinColumn(name = "CId"),
	inverseJoinColumns = @JoinColumn(name = "PId"))
	private Collection<Professor> professors = new ArrayList<Professor>();
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades;
	
	
	public Course(String title, int cp, Professor ... professors) {
		setTitle(title);
		setCp(cp);
		for(Professor tempP:professors )
		{
			addProfessor(tempP);
		}
		
	}
	
	
	public void addProfessor(Professor professor)
	{
		if(!professors.contains(professor))
		{
			professors.add(professor);
		}
	}
	

}
