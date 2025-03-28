package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
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
//kopīgās lietas (id, name, surname) tiek ievietotas personas tabulā, bet bērnu klases individualie parametri bērnu tabulā
//@Inheritance(strategy = InheritanceType.JOINED)

//veidojas katrai klasei sava tabula, bet bāzes tabula ir tukša un visi bāzes dati ir iekš bērnu tabulām
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//visi dati(gan bērnu, gan bāzes) būs apvienoti vienā tabula, pieliekot klāt datu tipu
//saja gadījuma jānoņem visas @Table anotacijas no bērnu klasēm
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)


@Table(name = "PersonTable")
@Entity
public class Person {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "PeId")//MYSQL - p_id
	@Id //ka primārā atslēga (PK)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long peid;
	
		
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
