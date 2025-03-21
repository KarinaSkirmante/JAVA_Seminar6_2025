package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private long cId;
	
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]{4,20}")
	@Column(name = "Title")
	private String title;
	
	@Min(0)
	@Max(30)
	@Column(name = "Cp")
	private int cp;
	
	@OneToOne
	@JoinColumn(name = "PId")//jānorāda uz otras klases PK kolonnas nosaukumu
	private Professor professor;
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades;
	
	
	public Course(String title, int cp, Professor professor) {
		setTitle(title);
		setCp(cp);
		setProfessor(professor);
	}
	
	

}
