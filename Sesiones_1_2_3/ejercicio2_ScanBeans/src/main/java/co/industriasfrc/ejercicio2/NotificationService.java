package co.industriasfrc.ejercicio2;


import org.springframework.stereotype.Component;

@Component
public class NotificationService{
    
    public String imprimirSaludo(){
        return "Hola, te saludo el servicio de notificaciones de Industrias Tecnologicas FRC";
    }

}