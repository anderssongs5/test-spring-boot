package co.test.spring_boot.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.test.spring_boot.Application;
import co.test.spring_boot.entity.Student;

@RestController
@RequestMapping(value = "/rest/student")
public class StudentService {

	@RequestMapping(value = "/hello")
	public String hello(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getSession().getId());

		return "Hello";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Student> getAllStudents() {
		return Application.students;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST, produces = "application/json")
	public Student addStudent(@RequestParam(value = "name") String name,
			@RequestParam(value = "subject") String subject) {
		Student student = new Student(name, subject);

		Application.students.add(student);

		return student;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Student deleteStudent(@PathVariable long id) throws Exception {
		Student student = null;
		for (int i = 0; i < Application.students.size(); i++) {
			Student s = Application.students.get(i);
			if (s.getId() == id) {
				student = s;
				Application.students.remove(i);

				break;
			}
		}

		if (student == null) {
			throw new Exception("Student does not exist");
		}

		return student;
	}
}
