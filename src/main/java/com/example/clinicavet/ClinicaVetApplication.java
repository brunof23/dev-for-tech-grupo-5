package com.example.clinicavet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class ClinicaVetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaVetApplication.class, args);
        System.out.println("http://localhost:8080/swagger-ui/index.html");
    }

}
