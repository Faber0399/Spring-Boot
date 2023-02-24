package com.industriasfrc.ejercicio2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.industriasfrc.ejercicio2.entities.Laptop;
import com.industriasfrc.ejercicio2.repositories.Laptoprepository;

@SpringBootApplication
public class Ejercicio2Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Ejercicio2Application.class, args);
		Laptoprepository laptoprepository=(Laptoprepository) context.getBean(Laptoprepository.class);
		
		System.out.println(context.getBeansOfType(Laptoprepository.class));
		//CRUD LAPTOPS
		System.out.println("El numero de computadores actualmente es: "+laptoprepository.count());
		Laptop laptop1=new Laptop("Pavillo ","HP","2021","Windows","Full","Gamer",true);
		Laptop laptop2=new Laptop("G15 ","Dell","2020","Linux","Low","Executive",false);

		laptoprepository.save(laptop1);
		laptoprepository.save(laptop2);
		System.out.println("El numero de computadores actualmente es: "+laptoprepository.count());

	}

}
