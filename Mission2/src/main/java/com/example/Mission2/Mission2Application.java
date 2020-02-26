package com.example.Mission2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class Mission2Application {

	@RequestMapping("/hello1234")
	@ResponseBody
	public String sayHello() {
		return "Hey Hi Hello" +
				"\nWhat's good in da hood?" +
				"\nRed riding hood," +
				"\nConvection hood";
	}
	//////over here butt butt
	@RequestMapping("/pet")
	@ResponseBody
	public String getPetID() {
		return null;
	}
	public static void main(String[] args)
	{
		SpringApplication.run(Mission2Application.class, args);
	}


}
