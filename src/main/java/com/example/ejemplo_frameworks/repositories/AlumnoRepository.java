package com.example.ejemplo_frameworks.repositories;

import com.example.ejemplo_frameworks.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    Alumno findAlumnoById(Integer id); // buscamos al objeto Alumno por su ID dandole como parametro este mismo

}
