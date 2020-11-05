package com.catc.hive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.catc.hive.*"})
public class HiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiveApplication.class, args);
	}

}
