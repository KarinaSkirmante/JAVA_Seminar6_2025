package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Person {
	
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]{3,10}([ ][A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]{3,10})?")
	@Column(name = "Name")//MYSQL - name
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]{3,15}([-][A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]{3,15})?")
	@Column(name = "Surname")//MYSQL - surname
	private String surname;
	
	public Person(String name, String surname)
	{
		setName(name);
		setSurname(surname);
	}
	

}
