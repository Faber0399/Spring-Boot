package co.industriasfrc.ejercicio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjerciciojpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjerciciojpaApplication.class, args);

		ComputadoresRepository repository = context.getBean(ComputadoresRepository.class);

		//System.out.println("El numero de computadores actualmente es: "+repository.count());

		//Computadores computador1= new Computadores(null, "Dell", "2022", "Gamer");
		Computadores computador5= new Computadores(null, "HP2", "2022", "Ejecutive");
		//repository.save(computador1);
		repository.save(computador5); 

		System.out.println("El numero de computadores actualmente es: "+repository.count());

		System.out.println(repository.findAll());
	}

}
