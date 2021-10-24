package com.example.ejemplo_frameworks.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
            name = "nombre",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String nombre;

    @Column(
            name = "apellido",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String apellido;

    @Column(
            name = "edad",
            nullable = false
    )
    private Integer edad;

    @Column(
            name = "correo",
            nullable = false,
            columnDefinition = "VARCHAR(40)"
    )
    private String correo;

    @Column(
            name = "fecha_registro",
            nullable = false
    )
    private Date fechaRegistro;

    @PrePersist
    public void setFechaRegistro(){
        this.fechaRegistro = new Date();
    }

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, Integer edad, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
