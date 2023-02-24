package co.industriasfrc.ejercicio3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadoresRepository extends JpaRepository<Computadores,Long>{
    
}
