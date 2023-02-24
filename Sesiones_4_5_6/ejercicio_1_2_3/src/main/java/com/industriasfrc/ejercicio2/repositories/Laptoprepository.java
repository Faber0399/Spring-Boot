package com.industriasfrc.ejercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.industriasfrc.ejercicio2.entities.Laptop;

public interface Laptoprepository extends JpaRepository<Laptop,Long> {
    
}
