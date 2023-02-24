package co.industriasfrc.ejercicios_1_2_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.industriasfrc.ejercicios_1_2_3.entities.Laptop;

public interface Laptoprepository extends JpaRepository<Laptop,Long> {
    
}
