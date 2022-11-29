package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMysqlApplication{
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
		MoneyCourse moneyCourse = new MoneyCourse();
		moneyCourse.MoneyCourse();
	}
}
