package com.PaulDev.demo;

import com.PaulDev.demo.DAO.AppDao;
import com.PaulDev.demo.Entity.Instructor;
import com.PaulDev.demo.Entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
			createInstructor(appDao);
		};
	}

	private void createInstructor(AppDao appDao) {
		Instructor instructor = new Instructor("Paul", "Dev", "pauldev@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("ytuboe@youtube.com","okok");
		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving" + instructor);
		appDao.save(instructor);
		System.out.println("DOne");
	}

}
