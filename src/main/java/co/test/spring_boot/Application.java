package co.test.spring_boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.test.spring_boot.entity.Student;

@SpringBootApplication
public class Application {

	public static List<Student> students;

	public static void main(String[] args) {
		students = new ArrayList<Student>();

		Student one = new Student("Andersson", "Math");
		students.add(one);

		Student two = new Student("Juan", "History");
		students.add(two);

		SpringApplication.run(Application.class, args);
	}
}
