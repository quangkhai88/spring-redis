package com.tqk;

import com.tqk.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.tqk")
public class SpringRedisApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Override
	public void run(String... args) throws Exception {

		studentService.saveStudent(new Student(1, "TQK", Student.Gender.MALE));
		studentService.saveStudent(new Student(2, "LAD", Student.Gender.FEMALE));
		studentService.findAll().forEach(System.out :: println);
		System.out.println("-------------------");
		studentService.deleteStudentById("1");
		System.out.println(studentService.findStudent("2"));
		System.out.println("-------------------");
		System.out.println(studentService.findStudent("1"));

		studentService.deleteAllStudent();

		System.exit(0);
	}

	public static void main(String[] args) {

		SpringApplication redisApp = new SpringApplication(SpringRedisApplication.class);

		redisApp.run(args);

	}

}
