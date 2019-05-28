package com.neuedu.hospital_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neuedu.hospital_back.mapper")
public class HospitalBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalBackApplication.class, args);
    }

}
