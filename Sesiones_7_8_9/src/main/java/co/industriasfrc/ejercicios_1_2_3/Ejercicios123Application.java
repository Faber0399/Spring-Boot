package co.industriasfrc.ejercicios_1_2_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import co.industriasfrc.ejercicios_1_2_3.entities.Laptop;
import co.industriasfrc.ejercicios_1_2_3.repositories.Laptoprepository;

@SpringBootApplication
public class Ejercicios123Application {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(Ejercicios123Application.class, args);
		Laptoprepository laptoprepository=context.getBean(Laptoprepository.class);

		Laptop laptop1=new Laptop("Pavillo ","HP","2021","Windows","Full","Gamer",true);
		Laptop laptop2=new Laptop("G15 ","Dell","2020","Linux","Low","Executive",false);

		laptoprepository.save(laptop1);
		laptoprepository.save(laptop2);
		System.out.println("El numero de computadores actualmente es: "+laptoprepository.count());
	}

}
