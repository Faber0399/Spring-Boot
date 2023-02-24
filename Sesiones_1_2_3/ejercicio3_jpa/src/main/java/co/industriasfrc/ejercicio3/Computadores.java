package co.industriasfrc.ejercicio3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Computadores {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String marca;
    private String release;
    private String categoriacomputador;

    public Computadores() {
    }

    public Computadores(Long id, String marca, String release, String categoriacomputador) {
        Id = id;
        this.marca = marca;
        this.release = release;
        this.categoriacomputador = categoriacomputador;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getCategoriacomputador() {
        return categoriacomputador;
    }

    public void setCategoriacomputador(String categoriacomputador) {
        this.categoriacomputador = categoriacomputador;
    }

    @Override
    public String toString() {
        return "Computadores [Id=" + Id + ", marca=" + marca + ", release=" + release + ", categoriacomputador="
                + categoriacomputador + "]";
    }
    

}
