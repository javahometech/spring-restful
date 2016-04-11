package in.javahome.restclient;

import org.springframework.web.client.RestTemplate;

import in.javahome.rs.pojo.Student;

public class ClientApp {
	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		String URL = "http://localhost:2016/restfulws/services/student/1";
		Student std = template.getForObject(URL, Student.class);
		System.out.println(std.getName());
		System.out.println(std.getPhone());
		System.out.println(std.getAddress());
	}
}
