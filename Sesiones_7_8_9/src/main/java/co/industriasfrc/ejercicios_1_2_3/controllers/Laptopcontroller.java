package co.industriasfrc.ejercicios_1_2_3.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.industriasfrc.ejercicios_1_2_3.entities.Laptop;
import co.industriasfrc.ejercicios_1_2_3.repositories.Laptoprepository;



@RestController
public class Laptopcontroller {

    private final Logger log = LoggerFactory.getLogger(Laptopcontroller.class);

    private Laptoprepository laptoprepository;

    /* public Laptopcontroller(Laptoprepository laptoprepository) {
        this.laptoprepository = laptoprepository;
    } */
    @Autowired
    public void setLaptoprepository(Laptoprepository laptoprepository) {
        this.laptoprepository = laptoprepository;
    }

    @GetMapping("api/laptops")
    public List<Laptop> laptops() {
        
        return laptoprepository.findAll(); 
    }

    @GetMapping("api/laptops/{id}")
    public ResponseEntity<Laptop> laptopById(@PathVariable Long id){
        Optional<Laptop> opt_laptop=laptoprepository.findById(id);
        if(opt_laptop.isPresent()){
            return ResponseEntity.ok(opt_laptop.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("api/laptops/create")
    public Laptop createLaptop(@RequestBody Laptop laptop){
        return laptoprepository.save(laptop);
    }

    @PutMapping("api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null ){ // si no tiene id quiere decir que sí es una creación
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptoprepository.existsById(laptop.getId())){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        // El proceso de actualización
        Laptop result = laptoprepository.save(laptop);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }

    @DeleteMapping("api/laptops/{id}")
    public ResponseEntity<Laptop> delete (@PathVariable Long id){
        if(!laptoprepository.existsById(id)){
            log.info("Intentando eliminar un libro que no existe");
            return ResponseEntity.notFound().build();
        }

        laptoprepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("Rest request for delete All boks");
        laptoprepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}


