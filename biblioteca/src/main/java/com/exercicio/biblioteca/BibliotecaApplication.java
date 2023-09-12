package com.exercicio.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class 	BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("2222"));
		System.out.println("separador");
		System.out.println(new BCryptPasswordEncoder().encode("1993"));

	}


}
