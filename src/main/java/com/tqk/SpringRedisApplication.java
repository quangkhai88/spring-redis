package com.tqk;

import com.tqk.bean.Gender;
import com.tqk.bean.Student;
import com.tqk.dao.RedisRepositoryImpl;
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


	@Autowired
	private RedisRepositoryImpl redisRepository;

	@Override
	public void run(String... args) {


		//testRedisCrudRepository();

		testRedisRepository();

		System.exit(0);
	}

	private void testRedisRepository() {


		redisRepository.addStudent(new Student(1, "TQK", Gender.MALE));
		redisRepository.addStudent(new Student(2, "LAD", Gender.FEMALE));


		redisRepository.getStudents().forEach((k,v) -> {
			System.out.println(v);
		});

		redisRepository.remvoveAllStudent();

	}


	public static void main(String[] args) {

		SpringApplication redisApp = new SpringApplication(SpringRedisApplication.class);

		redisApp.run(args);

	}


	private void testRedisCrudRepository() {
		studentService.deleteAllStudent();

		studentService.saveStudent(new Student(1, "TQK", Gender.MALE));
		studentService.saveStudent(new Student(2, "LAD", Gender.FEMALE));

		studentService.findAll().forEach(System.out :: println);

		System.out.println("-------------------");
		System.out.println("findById: "+studentService.findById("2"));

		System.out.println("-------------------");
		System.out.println("findByName: " + studentService.findByName("TQK"));

		studentService.deleteAllStudent();

	}
}
