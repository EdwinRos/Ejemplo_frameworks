package com.example.ejemplo_frameworks.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
            name = "nombre",
            nullable = false,
            columnDefinition = "VARCHAR(40)"
    )
    private String nombre;

    @Column(
            name = "fecha_registro",
            nullable = false
    )
    private Date fechaRegistro;

    @PrePersist
    public void setFechaRegistro(){
        this.fechaRegistro = new Date();
    }

    public Materia() {
    }

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
