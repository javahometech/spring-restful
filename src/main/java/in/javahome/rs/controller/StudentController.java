package in.javahome.rs.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.javahome.rs.pojo.Student;

@RestController
public class StudentController {
	Map<Integer, Student> studentsMap = new HashMap<Integer, Student>();

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("id") Integer id) {
		Student s = studentsMap.get(id);
		return s;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public String addStudent(@RequestBody Student std) {
		studentsMap.put(std.getStdId(), std);
		return "Success";
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public Set<Student> getStudents() {
		Collection<Student> students = studentsMap.values();
		Set<Student> stds = new HashSet<Student>(students);
		return stds;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String updateStudent(@RequestBody Student std) {
		studentsMap.put(std.getStdId(), std);
		return "Success";
	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE
			, produces={"application/json","application/xml"}
	        , consumes={"application/json","application/xml"})
	public String updateStudent(@PathVariable("id") Integer stdId) {
		studentsMap.remove(stdId);
		return "Success";
	}
	
	
}
