package com.example.ejemplo_frameworks.repositories;

import com.example.ejemplo_frameworks.entities.Alumno;
import com.example.ejemplo_frameworks.entities.AlumnoMateria;
import com.example.ejemplo_frameworks.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, Integer> {

    List<AlumnoMateria> findAlumnoMateriaByAlumnoid(Alumno alumnoid);

}
