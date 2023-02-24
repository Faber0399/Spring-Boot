package co.industriafrc.ejercicio1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

         Saludo saludar = (Saludo) context.getBean("Saludo");
         System.out.println(saludar.imprimirSaludo());
    }
    
    
}
